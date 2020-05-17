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
import models.model.SymptomsType;

/**
 *
 * @author Joseph
 */
public class SymptomsController {

    public static final SymptomsController INSTANCE = new SymptomsController();

    private final String insertSymptom = "insert into Symptoms(name, humanPercentage, deathPercentage, contagiousDay, modelId)"
            + "values(?, ?, ?, ?, ?)";
    private final String updateSymptom = "update Syptoms set humanPercentage = ?, deathPercentage = ?, contagiousDay = ?"
            + "where id = ?";
    private final String selectAll = "select id, modelId, name, humanPercentage, deathPercentage, contagiousDay "
            + "from Symptoms "
            + "where modelId = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    public SymptomsController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insertSymptom, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.updateSymptom);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
        } catch (SQLException ex) {
            Logger.getLogger(SymptomsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertSymptom(SymptomsType st) {
        try {
            this.insertStatement.setString(1, st.getName());
            this.insertStatement.setDouble(2, st.getPercentage());
            this.insertStatement.setDouble(3, st.getDeathPercentage());
            this.insertStatement.setInt(4, st.getContagiousDays());
            this.insertStatement.setInt(5, st.getModelId());
            int id = -1;
            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating symptom failed, no rows affected.");
            }
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            for (SymptomsStage ss : st.getListSymptomsStage()) {
                ss.setSymptomId(id);
                st.setId(id);
                SymptomStageController.INSTANCE.insert(ss);
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public boolean updateSymptom(SymptomsType st) {
        try {
            this.updateStatement.setDouble(1, st.getPercentage());
            this.updateStatement.setDouble(2, st.getDeathPercentage());
            this.updateStatement.setInt(3, st.getContagiousDays());
            this.updateStatement.setInt(4, st.getId());
            int affectedRows = this.updateStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating symptom failed, no rows affected.");
            }
            for (SymptomsStage ss : st.getListSymptomsStage()) {
                SymptomStageController.INSTANCE.update(ss);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<SymptomsType> selectAllSymptom(int modelId) {
        try {
            List<SymptomsType> list = new ArrayList();
            this.selectAllStatement.setInt(1, modelId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                List<SymptomsStage> listSS = SymptomStageController.INSTANCE.selectAll(set.getInt(1));
                list.add(new SymptomsType(set.getInt(1), set.getInt(2), set.getString(3), set.getDouble(4),
                        set.getDouble(5), set.getInt(6), listSS));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
