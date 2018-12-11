package DAO;

import entity.Flat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MySqlFlatDao implements FlatDao {

    private final Connection connection;

    public MySqlFlatDao(Connection connection) {
        this.connection = connection;
    }

    public Flat create() {
        return null;
    }

    public Flat read(int key) throws SQLException {
        String sql = "SELECT * FROM flatdb.flat WHERE id = ?;";
        PreparedStatement prst = connection.prepareStatement(sql);
        prst.setInt(1, key);

        ResultSet rs = prst.executeQuery();
        rs.next();
        Flat flat = Flat.newBuilder()
                .setId(rs.getInt("id"))
                .setDistrict(rs.getString("district"))
                .setAddress(rs.getString("address"))
                .setArea(rs.getDouble("area"))
                .setRoomQuantity(rs.getInt("roomquantity"))
                .setPrice(rs.getInt("price"))
                .build();

        return flat;
    }

    public List<Flat> getAllFlat() throws SQLException {
        String sql = "SELECT * FROM flatdb.flat;";
        PreparedStatement prst = connection.prepareStatement(sql);

        ResultSet rs = prst.executeQuery();
        List<Flat> list = new ArrayList<Flat>();
        while(rs.next()) {
            Flat flat = Flat.newBuilder()
                    .setId(rs.getInt("id"))
                    .setDistrict(rs.getString("district"))
                    .setAddress(rs.getString("address"))
                    .setArea(rs.getDouble("area"))
                    .setRoomQuantity(rs.getInt("roomquantity"))
                    .setPrice(rs.getInt("price"))
                    .build();
            list.add(flat);
        }
        return list;
    }

    public void addFlat(Flat flat) {

    }

    public List<Flat> getFlatByDistrictAndPrice(String district, int lowPrice, int highPrice)throws SQLException {
        String sql = "SELECT * FROM flatdb.flat WHERE district = \'" + district +
                "\' and price between " + lowPrice + " and " + highPrice + ";";
        PreparedStatement prst = connection.prepareStatement(sql);

        ResultSet rs = prst.executeQuery();
        List<Flat> list = new ArrayList<>();
        while(rs.next()) {
            Flat flat = Flat.newBuilder()
                    .setId(rs.getInt("id"))
                    .setDistrict(rs.getString("district"))
                    .setAddress(rs.getString("address"))
                    .setArea(rs.getDouble("area"))
                    .setRoomQuantity(rs.getInt("roomquantity"))
                    .setPrice(rs.getInt("price"))
                    .build();
            list.add(flat);
        }
        return list;
    }

    public List<Flat> getFlatByRoomQuantity(int roomQuantity) throws SQLException {
        String sql = "SELECT * FROM flatdb.flat where roomquantity = " + roomQuantity + ";";
        PreparedStatement prst = connection.prepareStatement(sql);

        ResultSet rs = prst.executeQuery();
        List<Flat> list = new ArrayList<>();
        while(rs.next()) {
            Flat flat = Flat.newBuilder()
                    .setId(rs.getInt("id"))
                    .setDistrict(rs.getString("district"))
                    .setAddress(rs.getString("address"))
                    .setArea(rs.getDouble("area"))
                    .setRoomQuantity(rs.getInt("roomquantity"))
                    .setPrice(rs.getInt("price"))
                    .build();
            list.add(flat);
        }
        return list;
    }
}
