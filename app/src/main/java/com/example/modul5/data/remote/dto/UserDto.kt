package com.example.modul5.data.remote.dto
import com.example.modul5.data.model.Student
data class UserDto(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val email: String,
    val university: String
)
fun UserDto.toStudent(): Student {
    return Student(
        id = id,
        name = "$firstName $lastName",
        email = email,
        university = university
    )
}