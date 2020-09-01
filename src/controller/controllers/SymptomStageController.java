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
import models.model.HumanStat;
import models.model.SymptomStage;

/**
 *
 * @author Joseph
 */
public class SymptomStageController {

    public static final SymptomStageController INSTANCE = new SymptomStageController();

    private final String insert = "insert into symptomstages(name, day, deathPercentage, immunePercentage, col, symptomId)"
            + "values(?, ?, ?, ?, ?, ?)";
    private final String update = "update symptomstages "
            + " set name = ?, day = ?, deathPercentage = ?, immunePercentage = ?, col = ?"
            + " where id = ?";
    private final String selectAll = "select id, name, day, deathPercentage, immunePercentage, col "
            + " from symptomstages"
            + " where symptomId = ?";
    private final String delete = "delete "
            + " from symptomstages "
            + " where id = ? ";

    private final String insertModel = "insert into symptomStagesModel(name, deathPercentage, immunePercentage, col,  modelId)"
            + "values(?, ?, ?, ?, ?)";
    private final String updateModel = "update symptomStagesModel set name = ?, deathPercentage = ?, immunePercentage = ?, col = ?"
            + " where id = ?";
    private final String selectAllModel = "select id, name, immunePercentage,deathPercentage,  col "
            + " from symptomStagesModel "
            + " where modelId = ? ";
    private final String deleteModel = "delete "
            + " from symptomStagesModel "
            + " where id = ? ";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    private PreparedStatement insertModelStatement;
    private PreparedStatement updateModelStatement;
    private PreparedStatement selectAllModelStatement;
    private PreparedStatement deleteModelStatement;

    private SymptomStageController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);

            this.insertModelStatement = DataSource.getConnection().prepareStatement(this.insertModel, Statement.RETURN_GENERATED_KEYS);
            this.updateModelStatement = DataSource.getConnection().prepareStatement(this.updateModel);
            this.selectAllModelStatement = DataSource.getConnection().prepareStatement(this.selectAllModel);
            this.deleteModelStatement = DataSource.getConnection().prepareStatement(this.deleteModel);
        } catch (SQLException ex) {
            Logger.getLogger(SymptomStageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(SymptomStage ss) {
        try {
            this.insertStatement.setString(1, ss.getName());
            this.insertStatement.setInt(2, ss.getDayNum());
            this.insertStatement.setDouble(3, ss.getDeathPercentage());
            this.insertStatement.setDouble(4, ss.getImmunePercentage());
            this.insertStatement.setInt(5, ss.getIndex());
            this.insertStatement.setInt(6, ss.getSymptomType().getId());
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

    public int insertModel(SymptomStage ss) {
        try {
            this.insertModelStatement.setString(1, ss.getName());
            this.insertModelStatement.setDouble(2, ss.getDeathPercentage());
            this.insertModelStatement.setDouble(3, ss.getImmunePercentage());
            this.insertModelStatement.setInt(4, ss.getIndex());
            this.insertModelStatement.setInt(5, ss.getModel().getModelId());
            int id = -1;
            int affectedRows = this.insertModelStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating symptom failed, no rows affected.");
            }
            ResultSet generatedKeys = this.insertModelStatement.getGeneratedKeys();
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

    public boolean update(SymptomStage ss) {
        try {
            this.updateStatement.setString(1, ss.getName());
            this.updateStatement.setInt(2, ss.getDayNum());
            this.updateStatement.setDouble(3, ss.getDeathPercentage());
            this.updateStatement.setDouble(4, ss.getImmunePercentage());
            this.updateStatement.setInt(5, ss.getIndex());
            this.updateStatement.setInt(6, ss.getId());
            System.out.println("id = " + ss.getId());
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

    public boolean updateModel(SymptomStage ss) {
        try {
            this.updateModelStatement.setString(1, ss.getName());
            this.updateModelStatement.setDouble(2, ss.getDeathPercentage());
            this.updateModelStatement.setDouble(3, ss.getImmunePercentage());
            this.updateModelStatement.setInt(4, ss.getIndex());
            this.updateModelStatement.setInt(5, ss.getId());
            int affectedRows = this.updateModelStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating symptom failed, no rows affected.");
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<SymptomStage> selectAll(int SymptomId) {
        try {
            List<SymptomStage> list = new ArrayList();
            this.selectAllStatement.setInt(1, SymptomId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                //list.add(new SymptomStage(set.getInt(1), set.getString(2), set.getInt(3), set.getDouble(4), set.getDouble(5), set.getInt(6)));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<SymptomStage> selectAllModel(int modelId) {
        try {
            List<SymptomStage> list = new ArrayList();
            this.selectAllModelStatement.setInt(1, modelId);
            ResultSet set = this.selectAllModelStatement.executeQuery();
            while (set.next()) {
                HumanStat humanState = HumanStateController.INSTANCE.select(set.getInt(1));
                list.add(new SymptomStage(set.getInt(1), set.getString(2), set.getDouble(3), set.getDouble(4), set.getInt(5)));
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
            Logger.getLogger(SymptomStageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteModel(int id) {
        try {
            this.deleteModelStatement.setInt(1, id);
            this.deleteModelStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SymptomStageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
