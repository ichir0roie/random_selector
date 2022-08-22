package com.ichir0roie.random_selector.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "group_id") val groupId:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name = "rate") val rate:Float,
)