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
import models.model.HumanAge;
import models.model.SymptomAge;
import models.model.SymptomType;

/**
 *
 * @author Joseph
 */
public class HumanAgeSymptomController {

    public static final HumanAgeSymptomController INSTANCE = new HumanAgeSymptomController();
    private final String insert = "insert into humanagesymptom(idSymptom, idHumanAge, percentage)"
            + " values(?, ?, ?)";
    private final String update = "update humanagesymptom"
            + " set percentage = ?"
            + " where id = ?";
    private final String selectAll = "select id , idSymptom, idHumanAge, percentage"
            + " from humanagesymptom "
            + " where idHumanAge = ?";
    private final String delete = " delete"
            + " from humanagesymptom "
            + " where id = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    private HumanAgeSymptomController() {

        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(SymptomStageTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(SymptomAge sage) {
        try {
            this.insertStatement.setInt(1, sage.getSymptomType().getId());
            this.insertStatement.setInt(2, sage.getHumanAge().getId());
            this.insertStatement.setDouble(3, sage.getPercentage());

            int id = -1;
            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating symptom failed, no rows affected.");
            }
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            sage.setId(id);
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean update(SymptomAge age) {
        try {
            this.updateStatement.setDouble(1, age.getPercentage());
            this.updateStatement.setInt(2, age.getId());
            int affectedRows = this.updateStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating symptom failed, no rows affected.");
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<SymptomAge> selectAll(HumanAge humanAge, List<SymptomType> listSymptom) {
        try {
            List<SymptomAge> list = new ArrayList();
            this.selectAllStatement.setInt(1, humanAge.getId());
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                SymptomType st = null;
                for (SymptomType stg : listSymptom) {
                    if (stg.getId() == set.getInt(2)) {
                        st = stg;
                        break;
                    }
                }
                list.add(new SymptomAge(set.getInt(1), humanAge, st, set.getDouble(4)));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HumanAgeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
