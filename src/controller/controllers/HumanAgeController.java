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
import models.model.SymptomStage;

/**
 *
 * @author Joseph
 */
public class HumanAgeController {

    public static final HumanAgeController INSTANCE = new HumanAgeController();

    private final String insert = "insert into humanage(name, minAge, maxAge, percentage, symptomId)"
            + "values(?, ?, ?, ?, ?)";
    private final String update = "update humanage "
            + " set name = ?, minAge = ?, maxAge = ?, percentage = ? "
            + " where id = ?";
    private final String selectAll = "select id, name, minAge, maxAge, percentage"
            + " from humanage"
            + " where symptomId = ?";
    private final String delete = "delete "
            + " from humanage "
            + " where id = ? ";

    private final String insertModel = "insert into humanagemodel(name, minAge, maxAge, modelId)"
            + "values(?, ?, ?, ?)";
    private final String updateModel = "update humanagemodel set name = ?, minAge = ?, maxAge = ?"
            + " where id = ?";
    private final String selectAllModel = "select id, name, minAge, maxAge"
            + " from humanagemodel "
            + " where modelId = ? ";
    private final String deleteModel = "delete "
            + " from humanagemodel "
            + " where id = ? ";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    private PreparedStatement insertModelStatement;
    private PreparedStatement updateModelStatement;
    private PreparedStatement selectAllModelStatement;
    private PreparedStatement deleteModelStatement;

    private HumanAgeController() {
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
            Logger.getLogger(HumanAgeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(HumanAge ss) {
        try {
            this.insertStatement.setString(1, ss.getName());
            this.insertStatement.setInt(2, ss.getMinAge());
            this.insertStatement.setInt(3, ss.getMaxAge());
            this.insertStatement.setDouble(4, ss.getPercentage());
            this.insertStatement.setInt(5, ss.getSymptomeType().getId());
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

    public int insertModel(HumanAge ss) {
        try {
            this.insertModelStatement.setString(1, ss.getName());
            this.insertModelStatement.setInt(2, ss.getMinAge());
            this.insertModelStatement.setInt(3, ss.getMaxAge());
            this.insertModelStatement.setInt(4, ss.getModel().getModelId());
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

    public boolean update(HumanAge ss) {
        try {
            this.updateStatement.setString(1, ss.getName());
            this.updateStatement.setInt(2, ss.getMinAge());
            this.updateStatement.setInt(3, ss.getMaxAge());
            this.updateStatement.setDouble(4, ss.getPercentage());
            this.updateStatement.setInt(5, ss.getId());
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

    public boolean updateModel(HumanAge ss) {
        try {
            this.updateModelStatement.setString(1, ss.getName());
            this.updateModelStatement.setInt(2, ss.getMinAge());
            this.updateModelStatement.setInt(3, ss.getMaxAge());
            this.updateModelStatement.setInt(4, ss.getId());
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

    public List<HumanAge> selectAll(int SymptomId) {
        try {
            List<HumanAge> list = new ArrayList();
            this.selectAllStatement.setInt(1, SymptomId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                list.add(new HumanAge(set.getInt(1), set.getString(2), set.getDouble(5), set.getInt(3), set.getInt(4)));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<HumanAge> selectAllModel(int modelId) {
        try {
            List<HumanAge> list = new ArrayList();
            this.selectAllModelStatement.setInt(1, modelId);
            ResultSet set = this.selectAllModelStatement.executeQuery();
            while (set.next()) {
                list.add(new HumanAge(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4)));
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

    public void deleteModel(int id) {
        try {
            this.deleteModelStatement.setInt(1, id);
            this.deleteModelStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HumanAgeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
