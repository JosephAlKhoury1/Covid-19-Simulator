package controller.controllers;

import controller.datasource.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client.LocationToGo;

public class LocationToGoController {

    public static final LocationToGoController INSTANCE = new LocationToGoController();

    private final String insert = "insert into locationtogo(name, percentage, ageId)"
            + " values(?, ?, ?)";
    private final String update = "update locationtogo"
            + " set name = ?, percentage = ?"
            + " where id = ?";
    private final String selectAll = "select id ,name, percentage"
            + " from locationtogo "
            + " where ageId = ?";
    private final String delete = " delete"
            + " from locationtogo "
            + " where id = ?";

    private final String selectAllName = "select name "
            + " from locationtogo "
            + " where ageId = ?";

    private final String insertCity = "insert into locationtogocity(name, cityId)"
            + " values(?, ?)";

    private final String selectAllCity = "select id ,name"
            + " from locationtogocity "
            + " where cityId = ?";
    private final String deleteCity = " delete"
            + " from locationtogocity "
            + " where id = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement selectAllNameStatement;
    private PreparedStatement insertCityStatement;
    private PreparedStatement selectAllCityStatement;
    private PreparedStatement deleteCityStatement;

    private LocationToGoController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
            this.selectAllNameStatement = DataSource.getConnection().prepareStatement(this.selectAllName);
            this.insertCityStatement = DataSource.getConnection().prepareStatement(this.insertCity, Statement.RETURN_GENERATED_KEYS);
            this.selectAllCityStatement = DataSource.getConnection().prepareStatement(this.selectAllCity);
            this.deleteCityStatement = DataSource.getConnection().prepareStatement(this.deleteCity);
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(LocationToGo l) {
        int id = -1;
        try {
            this.insertStatement.setString(1, l.getName());
            this.insertStatement.setDouble(2, l.getPercentage());
            this.insertStatement.setInt(3, l.getAgeType().getId());
            this.insertStatement.executeUpdate();
            ResultSet set = this.insertStatement.getGeneratedKeys();
            if (set.next()) {
                id = set.getInt(1);
            }
            l.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean update(LocationToGo hp) {
        try {
            this.updateStatement.setString(1, hp.getName());
            this.updateStatement.setDouble(2, hp.getPercentage());
            this.updateStatement.setInt(3, hp.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<LocationToGo> selectAll(int ageId) {
        List<LocationToGo> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, ageId);
            ResultSet set = this.selectAllStatement.executeQuery();

            while (set.next()) {
                list.add(new LocationToGo(set.getInt(1), set.getString(2), set.getDouble(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> selectAllName(int ageId) {
        List<String> list = new ArrayList();
        try {

            this.selectAllNameStatement.setInt(1, ageId);
            ResultSet set = this.selectAllNameStatement.executeQuery();
            while (set.next()) {
                list.add(set.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int insertCity(LocationToGo l) {
        int id = -1;
        try {
            this.insertCityStatement.setString(1, l.getName());
            this.insertCityStatement.setInt(2, l.getCity().getId());
            this.insertCityStatement.executeUpdate();
            ResultSet set = this.insertCityStatement.getGeneratedKeys();
            if (set.next()) {
                id = set.getInt(1);
            }
            l.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public List<LocationToGo> selectAllCity(int cityId) {
        List<LocationToGo> list = new ArrayList();
        try {
            this.selectAllCityStatement.setInt(1, cityId);
            ResultSet set = this.selectAllCityStatement.executeQuery();

            while (set.next()) {
                list.add(new LocationToGo(set.getInt(1), set.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void deleteCity(int id) {
        try {
            this.deleteCityStatement.setInt(1, id);
            this.deleteCityStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
