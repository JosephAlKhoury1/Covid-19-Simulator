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
import models.model.Model;
import models.model.SymptomsType;

public class ModelController {

    public final static ModelController INSTANCE = new ModelController();
    private final String insertModel = "insert into models(name)"
            + " values(?)";
    private final String updateModel = "update models"
            + " set name = ?"
            + " where id = ?";
    private final String selectAll = "select id, name"
            + "from models";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selsectAllStatement;

    private ModelController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insertModel, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.updateModel);
            this.selsectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int insertModel(Model m) {
        try {
            this.insertStatement.setString(1, m.getModelName());
            int id = -1;
            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating model failed, no rows affected.");
            }
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            for (SymptomsType s : m.getListSymptomsType()) {
                s.setModelId(id);
                m.setModelId(id);
                SymptomsController.INSTANCE.insertSymptom(s);
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
            this.updateStatement.setInt(2, m.getModelId());
            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("update model failed, no rows affected.");
            }
            for (SymptomsType s : m.getListSymptomsType()) {
                SymptomsController.INSTANCE.updateSymptom(s);
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<Model> selectAll() {
        try {
            List<Model> list = new ArrayList();
            ResultSet set = this.selsectAllStatement.executeQuery();
            while (set.next()) {
                List<SymptomsType> listS = SymptomsController.INSTANCE.selectAllSymptom(set.getInt(1));
                list.add(new Model(set.getInt(1), set.getString(2), listS));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
