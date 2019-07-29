package com.destiny.aplikasiebn.Model;

public class Model {
    String gambar,nama,deskripsi;
    String no,caragambar,caranama,caradeskripsi;
    public Model(){

    }

    public Model(String gambar,String nama,String deskripsi){
        this.gambar=gambar;
        this.nama=nama;
        this.deskripsi=deskripsi;
    }

    public Model(String no,String caragambar,String caranama,String caradeskripsi){
        this.no=no;
        this.caragambar=caragambar;
        this.caranama=caranama;
        this.caradeskripsi=caradeskripsi;
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

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getCaragambar() {
        return caragambar;
    }

    public void setCaragambar(String caragambar) {
        this.caragambar = caragambar;
    }

    public String getCaranama() {
        return caranama;
    }

    public void setCaranama(String caranama) {
        this.caranama = caranama;
    }

    public String getCaradeskripsi() {
        return caradeskripsi;
    }

    public void setCaradeskripsi(String caradeskripsi) {
        this.caradeskripsi = caradeskripsi;
    }
}
