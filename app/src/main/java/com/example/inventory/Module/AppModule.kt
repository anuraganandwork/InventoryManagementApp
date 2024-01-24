package com.example.inventory.Module

import android.content.Context
import androidx.room.Room
import com.example.inventory.Data.Databasse
import com.example.inventory.Data.Farmer_Dao
import com.example.inventory.Repository.Repo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun invenRepo():Repo{
    return Repo()
    }

    @Singleton
    @Provides
    fun provideDao(farmerdb:Databasse) : Farmer_Dao
    = farmerdb.Farmer_Dao()


    @Singleton
    @Provides
    fun providesNotesDatabase(@ApplicationContext context: Context) : Databasse
            = Room.databaseBuilder(
        context,
        Databasse::class.java,
        "Farmer_db")
        .fallbackToDestructiveMigration()
        .build()
}