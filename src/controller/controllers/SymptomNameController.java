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
import models.model.SymptomName;

public class SymptomNameController {

    public static final SymptomNameController INSTANCE = new SymptomNameController();

    private String insert = "insert into symptomname(name)"
            + " values(?)";
    private String selectAll = "select id , name"
            + " from symptomname ";
    private String delete = "delete "
            + " from symptomname "
            + " where id= ?";

    private PreparedStatement insertStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    public SymptomNameController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(SymptomNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(SymptomName sn) {
        int id = -1;
        try {
            this.insertStatement.setString(1, sn.getName());
            this.insertStatement.executeUpdate();
            ResultSet set = this.insertStatement.getGeneratedKeys();
            if (set.next()) {
                id = set.getInt(1);
            }
            sn.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(SymptomNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public List<SymptomName> selectAll() {
        List<SymptomName> list = new ArrayList();
        try {

            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                SymptomName sn = new SymptomName(set.getInt(1), set.getString(2));
                list.add(sn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SymptomNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SymptomNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
