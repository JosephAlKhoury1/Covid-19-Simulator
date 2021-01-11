package controller.controllers;

import controller.datasource.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.model.HumanAge;
import models.model.Model;
import models.model.PauseTime;
import models.model.SymptomStage;
import models.model.SymptomType;

public class ModelController {

    public final static ModelController INSTANCE = new ModelController();
    private final String insertModel = "insert into models(name, ismain, infectedNumber, runTime, virusName, contagiousDay)"
            + " values(?, ?, ?, ?, ?, ?)";
    private final String updateModel = "update models"
            + " set name = ?, infectedNumber = ?, runTime = ?, virusName = ?, contagiousDay = ?"
            + " where id = ?";
    private final String selectAllMain = "select id, name, infectedNumber, runTime, virusName, contagiousDay"
            + " from models"
            + " where ismain = 1";
    private final String selectAll = "select id, name "
            + " from models ";
    private final String select = "select name, infectedNumber, runTime, virusName, contagiousDay"
            + " from models "
            + " where id = ?";
    private final String setModelNonMain = "update models"
            + " set ismain = 0"
            + " where id = ?";
    private final String setModelMain = "update models"
            + " set ismain = 1"
            + " where id = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllMainStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement selectStatement;
    private PreparedStatement setModelNomMainStatement;
    private PreparedStatement setModelMainStatement;

    private ModelController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insertModel, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.updateModel);
            this.selectAllMainStatement = DataSource.getConnection().prepareStatement(this.selectAllMain);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.selectStatement = DataSource.getConnection().prepareStatement(this.select);
            this.setModelNomMainStatement = DataSource.getConnection().prepareStatement(this.setModelNonMain);
            this.setModelMainStatement = DataSource.getConnection().prepareStatement(this.setModelMain);
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertModel(Model m) {
        int id = -1;
        try {
            this.insertStatement.setString(1, m.getModelName());
            this.insertStatement.setInt(2, 1);
            this.insertStatement.setInt(3, m.getInfectedNumber());
            this.insertStatement.setInt(4, m.getRunTime());
            this.insertStatement.setString(5, m.getVirusName());
            this.insertStatement.setInt(6, m.getContagiousDay());
            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating model failed, no rows affected.");
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

    public boolean updateModel(Model m) {
        try {
            this.updateStatement.setString(1, m.getModelName());
            this.updateStatement.setInt(2, m.getInfectedNumber());
            this.updateStatement.setInt(3, m.getRunTime());
            this.updateStatement.setString(4, m.getVirusName());
            this.updateStatement.setInt(5, m.getContagiousDay());
            this.updateStatement.setInt(6, m.getModelId());
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

    public List<Model> selectAllMain() {
        try {
            List<Model> list = new ArrayList();
            ResultSet set = this.selectAllMainStatement.executeQuery();
            while (set.next()) {
                List<SymptomStage> listSS = SymptomStageController.INSTANCE.selectAllModel(set.getInt(1));
                List<SymptomType> listS = SymptomsController.INSTANCE.selectAllSymptom(set.getInt(1));
                List<HumanAge> listHA = HumanAgeController.INSTANCE.selectAll(set.getInt(1));
                List<PauseTime> listPt = PauseTimeController.INSTANCE.selectAll(set.getInt(1));
                for (SymptomType st : listS) {
                    st.setListSage(SymptomStageTypeController.INSTANCE.selectAll(st, listSS));
                }
                for (HumanAge ha : listHA) {
                    ha.setListSymptomAges(HumanAgeSymptomController.INSTANCE.selectAll(ha, listS));
                }
                list.add(new Model(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4), set.getString(5), set.getInt(6), listS, listSS, listHA, listPt));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setModelMain(int id) {
        try {
            this.setModelMainStatement.setInt(1, id);
            this.setModelMainStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setModelNonMain(int id) {
        try {
            this.setModelNomMainStatement.setInt(1, id);
            this.setModelNomMainStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Map<Integer, String> selectAll() {
        try {
            Map<Integer, String> list = new HashMap();
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                list.put(set.getInt(1), set.getString(2));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Model select(int id) {
        try {
            this.selectStatement.setInt(1, id);
            ResultSet set = this.selectStatement.executeQuery();
            Model m = null;
            while (set.next()) {
                List<SymptomStage> listSS = SymptomStageController.INSTANCE.selectAllModel(id);
                List<SymptomType> listS = SymptomsController.INSTANCE.selectAllSymptom(id);
                List<HumanAge> listHA = HumanAgeController.INSTANCE.selectAll(id);
                List<PauseTime> listPt = PauseTimeController.INSTANCE.selectAll(id);
                for (SymptomType st : listS) {
                    st.setListSage(SymptomStageTypeController.INSTANCE.selectAll(st, listSS));
                }
                for (HumanAge ha : listHA) {
                    ha.setListSymptomAges(HumanAgeSymptomController.INSTANCE.selectAll(ha, listS));
                }
                m = new Model(id, set.getString(1), set.getInt(2), set.getInt(3), set.getString(4), set.getInt(5), listS, listSS, listHA, listPt);
            }
            setModelMain(id);
            return m;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
