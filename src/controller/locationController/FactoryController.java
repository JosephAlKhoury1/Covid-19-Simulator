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
import models.location1.Factory;
import models.location1.Location;

public class FactoryController {

    public static final FactoryController INSTANCE = new FactoryController();

    private final String insert = "insert into factory(name, x, y, width, height, sickPercentage, locationCategoryId)"
            + " values(?, ?, ?, ?, ?, ?, ?) ";
    private final String update = "update factory"
            + " set sickPercentage = ?"
            + " where id = ? ";
    private final String selectAll = "select id, name, x, y, width, height, sickPercentage"
            + " from factory"
            + " where locationCategoryId = ? ";

    private final String delete = "delete"
            + " from factory "
            + " where id =?";

    private PreparedStatement deleteStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    private FactoryController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(FactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(Factory c) {
        int id = -1;
        try {
            this.insertStatement.setString(1, c.getName());
            this.insertStatement.setInt(2, c.getX());
            this.insertStatement.setInt(3, c.getY());
            this.insertStatement.setInt(4, c.getWidth());
            this.insertStatement.setInt(5, c.getHeight());
            this.insertStatement.setDouble(6, c.getAverage_sick());
            this.insertStatement.setInt(7, c.getLocationCategoryId());
            this.insertStatement.executeUpdate();
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            c.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(FactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean update(Factory c) {
        try {
            this.updateStatement.setDouble(1, c.getAverage_sick());
            this.updateStatement.setInt(2, c.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<Location> selectAll(int categoryId, City c) {
        List<Location> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, categoryId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                Factory h = new Factory(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4),
                        set.getInt(5), set.getInt(6), set.getDouble(7), categoryId, c);
                list.add(h);
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(FactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FactoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
