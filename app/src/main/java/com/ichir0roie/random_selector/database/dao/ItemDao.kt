package com.ichir0roie.random_selector.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.ichir0roie.random_selector.database.entity.Item

@Dao
interface ItemDao {
    @Query("select * from Item")
    fun getAll():List<Item>
}