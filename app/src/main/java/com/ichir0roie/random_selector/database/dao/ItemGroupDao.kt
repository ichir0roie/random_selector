package com.ichir0roie.random_selector.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.ichir0roie.random_selector.database.entity.ItemGroup

@Dao
interface ItemGroupDao{
    @Query("select * from ItemGroup")
    fun getAll():List<ItemGroup>
}
