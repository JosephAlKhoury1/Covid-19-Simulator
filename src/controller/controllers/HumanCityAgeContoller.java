/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import models.client1.HumanCityAgeType;
import models.model.HumanAgeType;

/**
 *
 * @author Joseph
 */
public class HumanCityAgeContoller {

    public static final HumanCityAgeContoller INSTANCE = new HumanCityAgeContoller();

    private final String insert = "insert into humanCityAgeType(name, minAge, maxAge, humanPercentage, goSchoolPercentage,"
            + " goUniversityPercentage, goWorkPercentage, cityId)"
            + "values(?,?,?,?,?,?,?,?)";
    private final String update = "update humanCityAgeType set humanPercentage=?, goSchoolPercentage=?, goUniversityPercentage, goWorkPercentage=?"
            + "where id=?";
    private final String selectAll = "select id, cityId, name, minAge, maxAge, humanPercentage, "
            + "goSchoolPercentage, goUniversityPercentage, goWorkPercentage"
            + " from humanCityAgeType  "
            + " where cityId=? ";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    public HumanCityAgeContoller() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(selectAll);
        } catch (SQLException ex) {
            Logger.getLogger(HumanCityAgeContoller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertHumanAgeType(HumanCityAgeType hat) {
        try {
            this.insertStatement.setString(1, hat.getType());
            this.insertStatement.setInt(2, hat.getMin());
            this.insertStatement.setInt(3, hat.getMax());
            this.insertStatement.setDouble(4, hat.getHumanPercentage());
            this.insertStatement.setDouble(5, hat.getGoSchoolPercentage());
            this.insertStatement.setDouble(6, hat.getGoUniversityPercentage());
            this.insertStatement.setDouble(7, hat.getGoWorkPercentage());
            this.insertStatement.setInt(8, hat.getCityId());
            int id = this.insertStatement.executeUpdate();
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean updateHumanAgeType(HumanAgeType hat) {
        try {
            this.updateStatement.setDouble(1, hat.getHumanPercentage());
            this.updateStatement.setDouble(1, hat.getGoSchoolPercentage());
            this.updateStatement.setDouble(3, hat.getGoUniversityPercentage());
            this.updateStatement.setDouble(4, hat.getGoWorkPercentage());
            this.updateStatement.setInt(5, hat.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<HumanCityAgeType> selectAllHumaAgeType(int cityId) {
        try {
            List<HumanCityAgeType> list = new ArrayList();
            this.selectAllStatement.setInt(1, cityId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                list.add(new HumanCityAgeType(set.getInt(1), set.getInt(2), set.getString(3), set.getInt(4), set.getInt(5),
                        set.getDouble(6), set.getDouble(7), set.getDouble(8), set.getDouble(9)));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
