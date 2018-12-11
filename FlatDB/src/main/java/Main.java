import DAO.DaoFactory;
import DAO.FlatDao;
import DAO.MySqlDaoFactory;
import entity.Flat;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DaoFactory daoFactory = new MySqlDaoFactory();

        try (Connection con = daoFactory.getConnection()) {
            FlatDao flatDao = daoFactory.getFlatDao(con);
            List<Flat> list1 = flatDao.getFlatByDistrictAndPrice("Подільський", 10000, 20000);
            System.out.println(list1.toString());

            List<Flat> list2 = flatDao.getFlatByRoomQuantity(2);
            System.out.println(list2.toString());


        }
    }
}
