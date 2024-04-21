package com.application.note

import android.app.Application
import androidx.room.Room
import com.application.note.database.NoteDatabase
import com.application.note.repositories.NoteRepo
import com.application.note.repositories.NoteRepoImpl
import org.koin.core.context.startKoin
import org.koin.dsl.bind
import org.koin.dsl.module

class KoinApp: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules( module {
                single {
                    Room
                        .databaseBuilder(this@KoinApp, NoteDatabase::class.java, "db")
                        .build()
                }
                single {
                    NoteRepoImpl(get())
                } bind NoteRepo::class
            })
        }
    }
}