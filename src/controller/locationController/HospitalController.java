package controller.locationController;

import controller.datasource.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client1.City;
import models.location1.Hospital;
import models.location1.Location;

/**
 *
 * @author Joseph
 */
public class HospitalController {

    public static final HospitalController INSTANCE = new HospitalController();

    private final String insert = "insert into hospital(name, x, y, width, height, sickPercentage, fixed, openTime, closeTime, days, locationCategoryId)"
            + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private final String update = "update hospital"
            + " set sickPercentage = ?, fixed = ?, set days= ?, set openTime = ?, set closeTime = ?"
            + " where id = ? ";
    private final String selectAll = "select id, name, x, y, width, height, sickPercentage, fixed, openTime, closeTime, days, locationCategoryId"
            + " from hospital"
            + " where locationCategoryId = ? ";

    private final String delete = "delete"
            + " from hospital "
            + " where id =?";

    private PreparedStatement deleteStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    private HospitalController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(Hospital c) {
        int id = -1;
        try {
            this.insertStatement.setString(1, c.getName());
            this.insertStatement.setInt(2, c.getX());
            this.insertStatement.setInt(3, c.getY());
            this.insertStatement.setInt(4, c.getWidth());
            this.insertStatement.setInt(5, c.getHeight());
            this.insertStatement.setDouble(6, c.getAverage_sick());
            this.insertStatement.setInt(7, c.getFixedLocation());
            this.insertStatement.setInt(8, c.getOpenTime());
            this.insertStatement.setInt(9, c.getCloseTime());
            this.insertStatement.setString(10, c.getDays());
            this.insertStatement.setInt(11, c.getLocationCategoryId());
            this.insertStatement.executeUpdate();
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            c.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean update(Hospital c) {
        try {
            this.updateStatement.setDouble(1, c.getAverage_sick());
            this.updateStatement.setInt(2, c.getFixedLocation());
            this.updateStatement.setString(3, c.getDays());
            this.updateStatement.setInt(4, c.getOpenTime());
            this.updateStatement.setInt(5, c.getCloseTime());
            this.updateStatement.setInt(6, c.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<Location> selectAll(int categoryId, City c) {
        List<Location> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, categoryId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                Hospital h = new Hospital(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4),
                        set.getInt(5), set.getInt(6), set.getDouble(7), set.getInt(8), set.getInt(9), set.getInt(10), set.getString(11), set.getInt(12),c);
                list.add(h);
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
