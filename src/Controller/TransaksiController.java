/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.TransaksiModel;
/**
 *
 * @author Acer
 */

public class TransaksiController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/akhir_oop";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public List<TransaksiModel> getAllTransaksi() {
        List<TransaksiModel> transaksiList = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM tbl_transaksi");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String kodePemesanan = resultSet.getString("kode_pemesanan");
                String pemesan = resultSet.getString("pemesan");
                String nomorKamar = resultSet.getString("nomor_kamar");
                String checkIn = resultSet.getString("check_in");
                String checkOut = resultSet.getString("check_out");
                String pembayaran = resultSet.getString("pembayaran");
                double dibayarkan = resultSet.getDouble("dibayarkan");

                TransaksiModel transaksi = new TransaksiModel();
                transaksi.setKodePemesanan(kodePemesanan);
                transaksi.setPemesan(pemesan);
                transaksi.setNomorKamar(nomorKamar);
                transaksi.setCheckIn(checkIn);
                transaksi.setCheckOut(checkOut);
                transaksi.setPembayaran(pembayaran);
                transaksi.setDibayarkan(dibayarkan);

                transaksiList.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transaksiList;
    }

    public void addTransaksi(TransaksiModel transaksi) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO tbl_transaksi (kode_pemesanan, pemesan, nomor_kamar, check_in, check_out, pembayaran, dibayarkan) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            statement.setString(1, transaksi.getKodePemesanan());
            statement.setString(2, transaksi.getPemesan());
            statement.setString(3, transaksi.getNomorKamar());
            statement.setString(4, transaksi.getCheckIn());
            statement.setString(5, transaksi.getCheckOut());
            statement.setString(6, transaksi.getPembayaran());
            statement.setDouble(7, transaksi.getDibayarkan());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTransaksi(TransaksiModel transaksi) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE tbl_transaksi SET pemesan=?, nomor_kamar=?, check_in=?, check_out=?, pembayaran=?, dibayarkan=? WHERE kode_pemesanan=?")) {

            statement.setString(1, transaksi.getPemesan());
            statement.setString(2, transaksi.getNomorKamar());
            statement.setString(3, transaksi.getCheckIn());
            statement.setString(4, transaksi.getCheckOut());
            statement.setString(5, transaksi.getPembayaran());
            statement.setDouble(6, transaksi.getDibayarkan());
            statement.setString(7, transaksi.getKodePemesanan());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTransaksi(String kodePemesanan) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM tbl_transaksi WHERE kode_pemesanan=?")) {

            statement.setString(1, kodePemesanan);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean isKodePemesananExists(String kodePemesanan) {
    // Buat koneksi ke database
    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/akhir_oop", "root", "")) {
        // Persiapkan query untuk mencari kode pemesanan
        String query = "SELECT COUNT(*) FROM tbl_transaksi WHERE kode_pemesanan = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, kodePemesanan);

        // Jalankan query dan ambil hasilnya
        ResultSet rs = stmt.executeQuery();
        rs.next();
        int count = rs.getInt(1);

        // Jika jumlah data dengan kode pemesanan tersebut lebih dari 0, berarti sudah ada
        return count > 0;
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
        return false;
    }
}


    public TransaksiModel getTransaksiByKodePemesanan(String kodePemesanan) {
        TransaksiModel transaksi = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM tbl_transaksi WHERE kode_pemesanan=?")) {

            statement.setString(1, kodePemesanan);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String pemesan = resultSet.getString("pemesan");
                String nomorKamar = resultSet.getString("nomor_kamar");
                String checkIn = resultSet.getString("check_in");
                String checkOut = resultSet.getString("check_out");
                String pembayaran = resultSet.getString("pembayaran");
                double dibayarkan = resultSet.getDouble("dibayarkan");

                transaksi = new TransaksiModel();
                transaksi.setKodePemesanan(kodePemesanan);
                transaksi.setPemesan(pemesan);
                transaksi.setNomorKamar(nomorKamar);
                transaksi.setCheckIn(checkIn);
                transaksi.setCheckOut(checkOut);
                transaksi.setPembayaran(pembayaran);
                transaksi.setDibayarkan(dibayarkan);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return transaksi;
    }
    
}


