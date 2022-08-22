package com.ichir0roie.random_selector.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ichir0roie.random_selector.database.dao.ItemDao
import com.ichir0roie.random_selector.database.dao.ItemGroupDao
import com.ichir0roie.random_selector.database.entity.Item
import com.ichir0roie.random_selector.database.entity.ItemGroup

@Database(entities = [Item::class,ItemGroup::class],version=1)
abstract class AppDatabase:RoomDatabase(){
    abstract fun itemDao():ItemDao
    abstract fun itemGroupDao():ItemGroupDao
}