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
import models.client1.HousePopulation;

public class HousePopulationController {

    public static final HousePopulationController INSTANCE = new HousePopulationController();

    private final String insert = "insert into housepopulation(number,percentage, cityid)"
            + " values(?, ?, ?)";
    private final String update = "update housepopulation"
            + " set number = ?, percentage = ?"
            + " where id = ?";
    private final String selectAll = "select id ,number, percentage"
            + " from housepopulation "
            + " where cityId = ?";
    private final String delete = " delete"
            + " from housepopulation "
            + " where id = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    private HousePopulationController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(HousePopulationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(HousePopulation hp) {
        int id = -1;
        try {
            this.insertStatement.setInt(1, hp.getNumber());
            this.insertStatement.setDouble(2, hp.getPercentage());
            this.insertStatement.setInt(3, hp.getCity().getId());
            this.insertStatement.executeUpdate();
            ResultSet set = this.insertStatement.getGeneratedKeys();
            if (set.next()) {
                id = set.getInt(1);
            }
            hp.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(HousePopulationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean update(HousePopulation hp) {
        try {
            this.updateStatement.setInt(1, hp.getNumber());
            this.updateStatement.setDouble(2, hp.getPercentage());
            this.updateStatement.setInt(3, hp.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HousePopulationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<HousePopulation> selectAll(int cityId) {
        List<HousePopulation> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, cityId);
            ResultSet set = this.selectAllStatement.executeQuery();

            while (set.next()) {
                list.add(new HousePopulation(set.getInt(1), set.getInt(2), set.getDouble(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HousePopulationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HousePopulationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
