/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Acer
 */
// Package dan import yang diperlukan
// ...

public class TamuModel {
    private int id;
    private String nama;
    private String alamat;
    private String jenisKelamin;
    private String kartuKredit;
    private String nomorTelepon;

    // Konstruktor
    public TamuModel(int id, String nama, String alamat, String jenisKelamin, String kartuKredit, String nomorTelepon) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.jenisKelamin = jenisKelamin;
        this.kartuKredit = kartuKredit;
        this.nomorTelepon = nomorTelepon;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getKartuKredit() {
        return kartuKredit;
    }

    public void setKartuKredit(String kartuKredit) {
        this.kartuKredit = kartuKredit;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
}