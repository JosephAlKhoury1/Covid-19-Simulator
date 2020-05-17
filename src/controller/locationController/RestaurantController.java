/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import models.location1.Location;
import models.location1.Restaurant;

/**
 *
 * @author Joseph
 */
public class RestaurantController {

    public static final RestaurantController INSTANCE = new RestaurantController();

    private final String insert = "insert into restaurant(name, x, y, width, height, sickPercentage, openTime, closeTime, locationCategoryId)"
            + " values(?, ?, ?, ?, ?, ?, ?, ?, ?) ";
    private final String update = "update restaurant"
            + " set sickPercentage = ?"
            + " where id = ? ";
    private final String selectAll = "select id, name, x, y, width, height, sickPercentage, openTime, closeTime, locationCategoryId"
            + " from restaurant"
            + " where locationCategoryId = ? ";

    private final String delete = "delete"
            + " from restaurant "
            + " where id =?";

    private PreparedStatement deleteStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    private RestaurantController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(Restaurant c) {
        int id = -1;
        try {
            this.insertStatement.setString(1, c.getName());
            this.insertStatement.setInt(2, c.getX());
            this.insertStatement.setInt(3, c.getY());
            this.insertStatement.setInt(4, c.getWidth());
            this.insertStatement.setInt(5, c.getHeight());
            this.insertStatement.setDouble(6, c.getAverage_sick());
            this.insertStatement.setDouble(7, c.getOpenTime());
            this.insertStatement.setDouble(8, c.getCloseTime());
            this.insertStatement.setInt(9, c.getLocationCategoryId());
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

    public boolean update(Restaurant c) {
        try {
            this.updateStatement.setDouble(1, c.getAverage_sick());
            this.updateStatement.setInt(2, c.getId());
            this.updateStatement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<Location> selectAll(int categoryId) {
        List<Location> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, categoryId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                list.add(new Restaurant(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4),
                        set.getInt(5), set.getInt(6), set.getDouble(7), set.getDouble(8), set.getDouble(9), set.getInt(10)));
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
