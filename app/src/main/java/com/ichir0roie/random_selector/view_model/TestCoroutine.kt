package com.ichir0roie.random_selector.view_model

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.ichir0roie.random_selector.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

val AndroidViewModel.context: Context
    get() = getApplication()

class TestCoroutine(application: Application): AndroidViewModel(application) {

    fun test(){
        viewModelScope.launch(Dispatchers.IO){
            testDatabase()
        }
    }

    private fun testDatabase(){
        Log.d("test","testDatabase")
        val db = context?.let {
            Log.d("test","context is exist")
            Room.databaseBuilder(
                it,
                AppDatabase::class.java, "database-name"
            ).build()
        }
        db?.let{
            Log.d("test","db is exist")
            val itemGroup= db.itemGroupDao().getAll();
            Log.d("test",itemGroup.toString());
        }
    }
}