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
import models.model.SexeType;

/**
 *
 * @author Joseph
 */
public class SexeTypeController {

    public static final SexeTypeController INSTANCE = new SexeTypeController();

    private final String insert = "insert into sexeTypes(name, percentage, modelId)"
            + "values(?, ?, ?)";
    private final String update = "update sexeTypes set percentage = ?"
            + "where id = ?";
    private final String selectAll = "select id, modelId, name, percentage"
            + "from sexeTypes"
            + "where modelId = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    private SexeTypeController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
        } catch (SQLException ex) {
            Logger.getLogger(SexeTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(SexeType st) {
        try {
            this.insertStatement.setString(1, st.getName());
            this.insertStatement.setDouble(2, st.getHumanPercentage());
            this.insertStatement.setInt(3, st.getModelId());
            int id = this.insertStatement.executeUpdate();
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean update(SexeType st) {
        try {
            this.updateStatement.setDouble(1, st.getHumanPercentage());
            this.updateStatement.setInt(2, st.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<SexeType> selectAl(int modelId) {
        try {
            List<SexeType> list = new ArrayList();
            this.selectAllStatement.setInt(1, modelId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                list.add(new SexeType(set.getInt(1), set.getInt(2), set.getString(3), set.getDouble(4)));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
