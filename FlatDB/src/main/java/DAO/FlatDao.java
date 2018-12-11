package DAO;

import entity.Flat;

import java.sql.SQLException;
import java.util.List;

public interface FlatDao {

//    public Flat create();
    public Flat read(int key) throws SQLException;
//    public void update(Flat flat);
//    public void delete(Flat flat);
    public List<Flat> getAllFlat() throws SQLException;
    void addFlat(Flat flat);
    public List<Flat> getFlatByDistrictAndPrice(String district,
                                         int lowPrice,
                                         int highPrice) throws SQLException;
    public List<Flat> getFlatByRoomQuantity(int roomQuantity) throws SQLException;
}
