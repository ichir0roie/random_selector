package com.ichir0roie.random_selector.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class ItemGroup(
    @PrimaryKey val id:Int,
    @ColumnInfo(name = "name") val name:String,
    @ColumnInfo(name="range")val range: Int,
)