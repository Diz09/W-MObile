package com.example.mobile_4;

public class Mahasiswa {
    private String nama;
    private String npm;
    private String nohp;
    public Mahasiswa(String nama, String npm, String nohp) {
        this.nama = nama;
        this.npm = npm;
        this.nohp = nohp;
    }
    public String getNama() {
        return nama;
    }
    public void setNama() { this.nama = nama; }
    public String getNpm() {
        return npm;
    }
    public void setNpm() {
        this.npm = npm;
    }
    public String getNohp() {
        return nohp;
    }
    public void setNohp() {
        this.nohp = nohp;
    }
}
