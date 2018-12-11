import DAO.DaoFactory;
import DAO.FlatDao;
import DAO.MySqlDaoFactory;
import entity.Flat;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.List;

public class Tests {

    @Test
    public void testGetAll() throws Exception{
        DaoFactory daoFactory = new MySqlDaoFactory();
        List<Flat> list;
        try(Connection con = daoFactory.getConnection()){
            FlatDao flatDao = daoFactory.getFlatDao(con);
            list = flatDao.getAllFlat();
            System.out.println(list.toString());
        }
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void testGetFlatByDistrictAndPrice() throws Exception{
        DaoFactory daoFactory = new MySqlDaoFactory();
        List<Flat> list;
        try(Connection con = daoFactory.getConnection()){
            FlatDao flatDao = daoFactory.getFlatDao(con);
            list = flatDao.getFlatByDistrictAndPrice("Дарницький", 10000, 20000);
            System.out.println(list.toString());
        }
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }

    @Test
    public void testGetFlatByRoomQuantity() throws Exception{
        DaoFactory daoFactory = new MySqlDaoFactory();
        List<Flat> list;
        try(Connection con = daoFactory.getConnection()){
            FlatDao flatDao = daoFactory.getFlatDao(con);
            list = flatDao.getFlatByRoomQuantity(2);
            System.out.println(list.toString());
        }
        assertNotNull(list);
        assertTrue(list.size() > 0);
    }
}
