package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Model.TamuModel;

public class TamuController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/akhir_oop";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public List<TamuModel> getAllUsers() {
        List<TamuModel> userList = new ArrayList<>();
        
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM tbl_tamu");
                ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String alamat = resultSet.getString("alamat");
                String jenisKelamin = resultSet.getString("jenis_kelamin");
                String kartuKredit = resultSet.getString("kartu_kredit");
                String nomorTelepon = resultSet.getString("nomor_telepon");

                TamuModel user = new TamuModel(id, nama, alamat, jenisKelamin, kartuKredit, nomorTelepon);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void addUser(TamuModel user) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "INSERT INTO tbl_tamu (nama, alamat, jenis_kelamin, kartu_kredit, nomor_telepon) " +
                        "VALUES (?, ?, ?, ?, ?)")) {

            statement.setString(1, user.getNama());
            statement.setString(2, user.getAlamat());
            statement.setString(3, user.getJenisKelamin());
            statement.setString(4, user.getKartuKredit());
            statement.setString(5, user.getNomorTelepon());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(TamuModel user) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement(
                        "UPDATE tbl_tamu SET nama=?, alamat=?, jenis_kelamin=?, kartu_kredit=?, nomor_telepon=? WHERE id=?")) {

            statement.setString(1, user.getNama());
            statement.setString(2, user.getAlamat());
            statement.setString(3, user.getJenisKelamin());
            statement.setString(4, user.getKartuKredit());
            statement.setString(5, user.getNomorTelepon());
            statement.setInt(6, user.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement("DELETE FROM tbl_tamu WHERE id=?")) {

            statement.setInt(1, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public TamuModel getTamuById(int tamuId) {
        TamuModel tamu = null;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM tbl_tamu WHERE id=?")) {

            statement.setInt(1, tamuId);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nama = resultSet.getString("nama");
                String alamat = resultSet.getString("alamat");
                String jenisKelamin = resultSet.getString("jenis_kelamin");
                String kartuKredit = resultSet.getString("kartu_kredit");
                String nomorTelepon = resultSet.getString("nomor_telepon");

                tamu = new TamuModel(id, nama, alamat, jenisKelamin, kartuKredit, nomorTelepon);
            }

            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tamu;
    }
}
