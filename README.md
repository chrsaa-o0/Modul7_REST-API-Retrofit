# Modul7_REST-API-Retrofit

Nama: Charisa Salsabila Larasati

NIM: 24515020111022

Deskripsi: Tugas praktikum Pengembangan Aplikasi Perangkat Bergerak (PAPB) mengenai integrasi REST API menggunakan Retrofit, DTO mapping, asynchronous callback, serta penerapan fitur pencarian data secara online pada Arsitektur Aplikasi Android.

Proyek ini merupakan pengembangan lanjutan dari modul arsitektur sebelumnya yang menggunakan sumber data eksternal secara langsung dari layanan web service (DummyJSON API). Prinsip Clean Architecture dan pemisahan lapisan (Separation of Concerns) tetap dijaga ketat, di mana komponen UI (`HomeScreen`, `DetailScreen`) hanya bertugas merender state dan menerima interaksi pengguna tanpa pernah menyentuh jaringan secara langsung.

Dalam pengembangannya, implementasi mencakup pembuatan antarmuka jaringan `StudentApiService` dengan endpoint pencarian (`users/search?q={query}`), pengelolaan DTO dan mapping data ke model `Student`, serta pembungkusan proses asinkron berbasis callback melalui `StudentRemoteDataSource` dan `StudentRepository`. Selain itu, fungsionalitas tombol Cari dirancang agar mampu memuat data berdasarkan kata kunci, menangani kondisi query kosong dengan memuat ulang daftar awal, serta mempertahankan loading dan error state demi pengalaman pengguna yang optimal. Navigasi antar-layar menuju halaman detail berdasarkan ID unik juga tetap terintegrasi dengan mulus.
