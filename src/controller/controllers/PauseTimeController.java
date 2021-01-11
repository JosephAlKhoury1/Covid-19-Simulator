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
import models.model.PauseTime;

public class PauseTimeController {

    public static final PauseTimeController INSTANCE = new PauseTimeController();

    private final String insert = "insert into pausetime(day, modelId)"
            + " values(?, ?)";
    private final String update = "update pausetime"
            + " set day = ? "
            + " where id = ?";
    private final String selectAll = "select id ,day"
            + " from pausetime "
            + " where modelId = ?";
    private final String delete = " delete"
            + " from pausetime "
            + " where id = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    private PauseTimeController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(LocationToGoController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertModel(PauseTime pt) {
        int id = -1;
        try {
            this.insertStatement.setInt(1, pt.getDays());
            this.insertStatement.setInt(2, pt.getModel().getModelId());
            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating pause time failed, no rows affected.");
            }
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean updateModel(PauseTime pt) {
        try {
            this.updateStatement.setInt(1, pt.getDays());
            this.updateStatement.setInt(2, pt.getId());
            int affectedRows = this.updateStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("update model failed, no rows affected.");
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<PauseTime> selectAll(int modelId) {
        try {
            List<PauseTime> list = new ArrayList();
            this.selectAllStatement.setInt(1, modelId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                list.add(new PauseTime(set.getInt(1), set.getInt(2)));
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
            Logger.getLogger(PauseTimeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
