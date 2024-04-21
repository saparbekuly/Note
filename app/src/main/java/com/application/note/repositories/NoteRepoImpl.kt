package com.application.note.repositories

import com.application.note.database.NoteDatabase
import com.application.note.database.NoteEntity
import kotlinx.coroutines.flow.Flow

class NoteRepoImpl(database: NoteDatabase) : NoteRepo {
    private val dao = database.noteDao()

    override suspend fun addNote(note: NoteEntity) = dao.addNote(note)

    override suspend fun deleteNote(note: NoteEntity) = dao.deleteNote(note)

    override suspend fun getNotes(): Flow<List<NoteEntity>> = dao.getNotes()
}