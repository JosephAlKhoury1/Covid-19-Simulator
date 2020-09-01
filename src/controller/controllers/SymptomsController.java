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
import models.model.SymptomType;

/**
 *
 * @author Joseph
 */
public class SymptomsController {

    public static final SymptomsController INSTANCE = new SymptomsController();

    private final String insertSymptom = "insert into symptoms(name, contagiousDay, modelId)"
            + " values(?, ?, ?)";
    private final String updateSymptom = "update symptoms "
            + " set name = ?, contagiousDay = ? "
            + " where id = ?";
    private final String selectAll = "select id, name, contagiousDay "
            + " from symptoms "
            + " where modelId = ?";
    private final String delete = "delete "
            + " from symptoms "
            + " where id = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    public SymptomsController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insertSymptom, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.updateSymptom);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(SymptomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertSymptom(SymptomType st) {
        int id = -1;
        try {
            this.insertStatement.setString(1, st.getName());
            this.insertStatement.setInt(2, st.getContagiousDay());
            this.insertStatement.setInt(3, st.getModel().getModelId());
            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating symptom failed, no rows affected.");
            }
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean updateSymptom(SymptomType st) {
        try {
            this.updateStatement.setString(1, st.getName());
            this.updateStatement.setInt(2, st.getContagiousDay());
            this.updateStatement.setInt(3, st.getId());
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

    public List<SymptomType> selectAllSymptom(int modelId) {
        try {
            List<SymptomType> list = new ArrayList();
            this.selectAllStatement.setInt(1, modelId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                List<SymptomStage> listSS = SymptomStageController.INSTANCE.selectAll(set.getInt(1));
                List<HumanAge> listHA = HumanAgeController.INSTANCE.selectAll(set.getInt(1));
                list.add(new SymptomType(set.getInt(1), set.getString(2), set.getInt(3)));
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
            Logger.getLogger(SymptomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
