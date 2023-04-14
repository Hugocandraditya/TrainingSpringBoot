# TrainingSpringBoot
fitur pembayaran

PaymentService
prepare - berguna untuk melakukan persiapan untuk memilih paket layanan dan nomor pembayaran
presentment - berguna untuk memverif kembali paket pilihan dan nomor rekening pilahan 
execute - melakukan pembayaran dan memverif pin transaksi untuk mengeluarkan bukti transaksi

User
inquiry data user untuk kebutuhan verifikasi paymentservice
inquiry no rekening berdasarkan user untuk mengeluarkan nomor rekening apa saja yang bisa digunakan user
inquiry no rekening berdasarkan id untuk memverif nomor rekening yang diinputkan user
verif pin untuk memverifikasi pin execute payment

micro project
database yang digunakan untuk memproses payment
