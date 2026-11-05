package com.example.modul5.data.repository

import com.example.modul5.data.model.Student
import com.example.modul5.data.remote.StudentRemoteDataSource
import com.example.modul5.data.remote.dto.toStudent
interface StudentRepository {
    fun getStudents(callback: (Result<List<Student>>) -> Unit)
    fun getStudent(id: Int, callback: (Result<Student>) -> Unit)
    fun searchStudents(query: String, callback: (Result<List<Student>>) -> Unit)
}
class DefaultStudentRepository(
    private val remoteDataSource: StudentRemoteDataSource
) : StudentRepository {
    override fun getStudents(callback: (Result<List<Student>>) -> Unit) {
        remoteDataSource.getStudents { result ->
            callback(result.map { users -> users.map { it.toStudent() } })
        }
    }
    override fun getStudent(id: Int, callback: (Result<Student>) -> Unit) {
        remoteDataSource.getStudent(id) { result ->
            callback(result.map { it.toStudent() })
        }
    }
    override fun searchStudents(query: String, callback: (Result<List<Student>>) -> Unit) {
        remoteDataSource.searchUsers(query) { result ->
            callback(result.map { users -> users.map { it.toStudent() } })
        }
    }
}