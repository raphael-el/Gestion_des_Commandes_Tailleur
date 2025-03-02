package com.example.gestiondescommandes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Commande::class], version = 1)
abstract class CommandeDatabase : RoomDatabase() {
    abstract fun commandeDao(): CommandeDao

    companion object {
        @Volatile
        private var INSTANCE: CommandeDatabase? = null

        fun getDatabase(context: Context): CommandeDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CommandeDatabase::class.java,
                    "commande_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
