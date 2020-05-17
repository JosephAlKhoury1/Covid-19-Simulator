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
import models.model.SymptomsStage;

/**
 *
 * @author Joseph
 */
public class SymptomStageController {

    public static final SymptomStageController INSTANCE = new SymptomStageController();

    private final String insert = "insert into symptomStages(name, day, deathPercentage, immunePercentage, symptomId)"
            + "values(?, ?, ?, ?, ?)";
    private final String update = "update symptomStages set day = ?, deathPercentage = ?, immunePercentage = ?"
            + "where symptomId = ?";
    private final String selectAll = "select id, symptomId, name, day, deathPercentage, immunePercentage"
            + "from symptomStages"
            + "where symptomId = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    private SymptomStageController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
        } catch (SQLException ex) {
            Logger.getLogger(SymptomStageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(SymptomsStage ss) {
        try {
            this.insertStatement.setString(1, ss.getName());
            this.insertStatement.setInt(2, ss.getDay());
            this.insertStatement.setDouble(3, ss.getDeathPercentage());
            this.insertStatement.setDouble(4, ss.getImmunePercentage());
            this.insertStatement.setInt(5, ss.getSymptomId());
            int id = -1;
            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating symptom failed, no rows affected.");
            }
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            ss.setId(id);
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean update(SymptomsStage ss) {
        try {
            this.updateStatement.setInt(1, ss.getDay());
            this.updateStatement.setDouble(2, ss.getDeathPercentage());
            this.updateStatement.setDouble(3, ss.getImmunePercentage());
            this.updateStatement.setInt(4, ss.getSymptomId());
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

    public List<SymptomsStage> selectAll(int SymptomId) {
        try {
            List<SymptomsStage> list = new ArrayList();
            this.selectAllStatement.setInt(1, SymptomId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                list.add(new SymptomsStage(set.getInt(1), set.getInt(2), set.getString(3), set.getInt(4), set.getDouble(5), set.getDouble(6)));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
