package com.application.note.repositories

import com.application.note.database.NoteEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepo {
    suspend fun addNote(note:NoteEntity)
    suspend fun deleteNote(note:NoteEntity)
    suspend fun getNotes(): Flow<List<NoteEntity>>
}