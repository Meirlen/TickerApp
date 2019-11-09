package com.example.gateway.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gateway.converter.CurrencyConverter
import com.example.gateway.entity.Currency

@Database(entities = [Currency::class], version = 1, exportSchema = false)
@TypeConverters(CurrencyConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CurrencyDao

}