package com.example.recyclerview;

// Kelas Mahasiswa yang merepresentasikan objek mahasiswa
public class Mahasiswa {
    private String nama;
    private String npm;
    private String nohp;

    // Konstruktor untuk membuat objek Mahasiswa dengan nama, npm, dan nohp
    public Mahasiswa(String nama, String npm, String nohp){
        this.nama = nama;
        this.npm = npm;
        this.nohp = nohp;
    }

    // Metode getter untuk mengambil nilai nama
    public String getNama(){
        return nama;
    }

    // Metode setter untuk mengatur nilai nama
    public void setNama(String txtNama){
        this.nama = nama; // Bug: Ini harus menjadi this.nama = txtNama; untuk mengatur nilai nama
    }

    // Metode getter untuk mengambil nilai npm
    public String getNpm(){
        return npm;
    }

    // Metode setter untuk mengatur nilai npm
    public void setNpm(String npm) {
        this.npm = npm;
    }

    // Metode getter untuk mengambil nilai nohp
    public String getNohp() {
        return nohp;
    }

    // Metode setter untuk mengatur nilai nohp
    public void setNohp(String nohp) {
        this.nohp = nohp;
    }
}