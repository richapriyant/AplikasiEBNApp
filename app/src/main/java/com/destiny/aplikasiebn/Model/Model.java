package com.destiny.aplikasiebn.Model;

public class Model {
    String gambar,nama,deskripsi;


    public Model(){

    }

    public Model(String gambar,String nama,String deskripsi){
        this.gambar=gambar;
        this.nama=nama;
        this.deskripsi=deskripsi;
    }
    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }
}
