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
import models.model.SymptomStage;
import models.model.SymptomStageType;
import models.model.SymptomType;

/**
 *
 * @author Joseph
 */
public class SymptomStageTypeController {

    public static final SymptomStageTypeController INSTANCE = new SymptomStageTypeController();
    private final String insert = "insert into symptomstagetype(idSymptom, idSymptomStage, days)"
            + " values(?, ?, ?)";
    private final String update = "update symptomstagetype"
            + " set days = ?"
            + " where id = ?";
    private final String selectAll = "select id , idSymptomStage, days"
            + " from symptomstagetype "
            + " where idSymptom = ?";
    private final String delete = " delete"
            + " from symptomstagetype "
            + " where id = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    private SymptomStageTypeController() {

        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(SymptomStageTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(SymptomStageType stt) {
        try {
            this.insertStatement.setInt(1, stt.getSymptomType().getId());
            this.insertStatement.setInt(2, stt.getSymptomStage().getId());
            this.insertStatement.setInt(3, stt.getDay());

            int id = -1;
            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating symptom failed, no rows affected.");
            }
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            stt.setId(id);
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public List<SymptomStageType> selectAll(SymptomType symptom, List<SymptomStage> listStage) {
        try {
            List<SymptomStageType> list = new ArrayList();
            this.selectAllStatement.setInt(1, symptom.getId());
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                SymptomStage st = null;
                for (SymptomStage stg : listStage) {
                    if (stg.getId() == set.getInt(2)) {
                        st = stg;
                        break;
                    }
                }
                list.add(new SymptomStageType(set.getInt(1), symptom, st, set.getInt(3), symptom.getModel()));
            }
            set.close();
            SymptomStageType[] tab = new SymptomStageType[list.size()];
            for (SymptomStageType stt : list) {
                tab[stt.getSymptomStage().getIndex() - 1] = stt;
            }
            list.clear();
            for (SymptomStageType stt : tab) {
                list.add(stt);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean update(SymptomStageType age) {
        try {
            this.updateStatement.setInt(1, age.getDay());
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

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HumanAgeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
