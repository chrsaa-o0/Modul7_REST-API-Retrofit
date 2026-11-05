package com.example.modul5.data.source

import com.example.modul5.data.model.Student
class StudentLocalDataSource {
    private val students = listOf(
        Student(id = 2026, name = "Alya Putri", email = "alya@gmail.com", university = "Universitas Brawijaya"),
        Student(id = 2027, name = "Bima Pratama", email = "bima@gmail.com", university = "Universitas Brawijaya"),
        Student(id = 2028, name = "Citra Lestari", email = "citra@gmail.com", university = "Universitas Brawijaya"),
        Student(id = 2029, name = "Danu Wijaya", email = "danu@gmail.com", university = "Universitas Brawijaya"),
        Student(id = 2030, name = "Eka Putri", email = "eka@gmail.com", university = "Universitas Brawijaya")
    )

    fun getStudentById(id: Int): Student? = students.find { it.id == id }
    fun getStudents(): List<Student> = students
}
//class StudentLocalDataSource {
//    private val students = listOf(
//        Student(2026, "Alya Putri", "Teknik Informatika", 2026),
//        Student(2027, "Bima Pratama", "Teknik Informatika", 2026),
//        Student(2028, "Citra Lestari", "Teknik Informatika", 2026),
//        // 2 data mahasiswa baru
//        Student(2029, "Danu Wijaya", "Teknik Informatika", 2026),
//        Student(2030, "Eka Putri", "Teknik Informatika", 2026)
//    )
//    fun getStudentById(id: Int): Student? =
//        students.find { it.id == id }
//    fun getStudents(): List<Student> =
//        students
//}