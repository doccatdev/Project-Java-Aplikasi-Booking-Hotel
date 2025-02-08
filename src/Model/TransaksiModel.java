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

public class TransaksiModel {
    private String kodePemesanan;
    private String pemesan;
    private String nomorKamar;
    private String checkIn;
    private String checkOut;
    private String pembayaran;
    private double dibayarkan;

    // Konstruktor
    public TransaksiModel() {
        generateKodePemesanan();
    }

    // Getter dan Setter
    public String getKodePemesanan() {
        return kodePemesanan;
    }

    public void setKodePemesanan(String kodePemesanan) {
        this.kodePemesanan = kodePemesanan;
    }

    public String getPemesan() {
        return pemesan;
    }

    public void setPemesan(String pemesan) {
        this.pemesan = pemesan;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(String nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getPembayaran() {
        return pembayaran;
    }

    public void setPembayaran(String pembayaran) {
        this.pembayaran = pembayaran;
    }

    public double getDibayarkan() {
        return dibayarkan;
    }

    public void setDibayarkan(double dibayarkan) {
        this.dibayarkan = dibayarkan;
    }

    // Method untuk mengenerate kode pemesanan secara otomatis
    private void generateKodePemesanan() {
        this.kodePemesanan = kodePemesanan;
    }
}
