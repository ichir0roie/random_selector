package com.ichir0roie.random_selector

import android.content.Context
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.ichir0roie.random_selector.database.AppDatabase
import com.ichir0roie.random_selector.database.entity.ItemGroup
import com.ichir0roie.random_selector.databinding.ActivityMainBinding
import com.ichir0roie.random_selector.view_model.TestCoroutine
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val viewModel:TestCoroutine by lazy {
        ViewModelProvider(this).get(TestCoroutine::class.java)
    }

    // https://kotlinlang.org/api/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines/-coroutine-scope/
//    var scope: CoroutineScope? =null;
//
//    companion object{
//        private lateinit var context: Context
//        fun setContext(con:Context){
//            context=con
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

//        MainActivity.Companion.setContext(this);
////        fun showData()=scope.launch { testDatabase() }
////        showData()
//        scope= CoroutineScope(context)
        viewModel.test()
    }


    fun testDatabase(): List<ItemGroup> {
        Log.d("test","testDatabase")
        val db = applicationContext?.let {
            Log.d("test","context is exist")
            Room.databaseBuilder(
                it,
                AppDatabase::class.java, "database-name"
            ).build()
        }
        db?.let{
            Log.d("test","db is exist")
            val itemGroup= it.itemGroupDao().getAll();
            Log.d("test",itemGroup.toString());
            return itemGroup
        }
        val l=listOf<ItemGroup>()
        return l
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}