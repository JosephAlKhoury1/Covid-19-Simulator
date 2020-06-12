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

public class HumanStateController {

    public static final HumanStateController INSTANCE = new HumanStateController();

    private final String insert = "insert into humanstate(name,colorName,symptomStageId)"
            + " values(?, ?, ?)";
    private final String update = "update humanstate"
            + " set name = ?, colorName = ?"
            + " where id = ?";
    private final String selectAll = "select id , name, colorName"
            + " from humanstate "
            + " where symptomStageId = ?";
    private final String delete = "delete "
            + " from humanstate "
            + " where id= ?";
    private final String select = "select id, name, colorName"
            + " from humanstate "
            + " where symptomStageId = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;
    private PreparedStatement selectStatement;

    public HumanStateController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
            this.selectStatement = DataSource.getConnection().prepareStatement(this.select);
        } catch (SQLException ex) {
            Logger.getLogger(HumanStateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(HumanStat sn) {
        int id = -1;
        try {
            this.insertStatement.setString(1, sn.getName());
            this.insertStatement.setString(2, sn.getColorName());
            this.insertStatement.setInt(3, sn.getSymptomeStage().getId());
            this.insertStatement.executeUpdate();
            ResultSet set = this.insertStatement.getGeneratedKeys();
            if (set.next()) {
                id = set.getInt(1);
            }
            sn.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(HumanStateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean update(HumanStat st) {
        try {
            this.updateStatement.setString(1, st.getName());
            this.updateStatement.setString(2, st.getColorName());
            this.updateStatement.setInt(3, st.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HumanStateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<HumanStat> selectAll(int symStageId) {
        List<HumanStat> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, symStageId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                HumanStat sn = new HumanStat(set.getInt(1), set.getString(2), set.getString(3));
                list.add(sn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HumanStateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HumanStateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public HumanStat select(int symStageId) {
        HumanStat h = null;
        try {
            this.selectStatement.setInt(1, symStageId);
            ResultSet set = this.selectStatement.executeQuery();
            if (set.next()) {
                h = new HumanStat(set.getInt(1), set.getString(2), set.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HumanStateController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return h;
    }
}
