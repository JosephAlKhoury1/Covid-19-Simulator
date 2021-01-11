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
import models.client.ReligionType;

public class ReligionTypeController {

    public final static ReligionTypeController INSTANCE = new ReligionTypeController();

    private final String insert = "insert into religiontype(name, percentage, prayPlace, cityid)"
            + " values(?, ?, ?, ?)";
    private final String update = "update religiontype"
            + " set name = ? , percentage = ?, prayPlace = ?"
            + " where id = ?";
    private final String selectAll = "select id, name, percentage, prayPlace "
            + " from religiontype "
            + " where cityid= ?";
    private final String delete = "delete "
            + " from religiontype"
            + " where id = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatememt;

    private ReligionTypeController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatememt = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(ReligionTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(ReligionType rt) {
        int id = -1;
        try {
            this.insertStatement.setString(1, rt.getName());
            this.insertStatement.setDouble(2, rt.getPercentage());
            this.insertStatement.setString(3, rt.getPrayLocation());
            this.insertStatement.setInt(4, rt.getCity().getId());
            this.insertStatement.executeUpdate();
            ResultSet set = this.insertStatement.getGeneratedKeys();
            if (set.next()) {
                id = set.getInt(1);
            }
            rt.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ReligionTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean update(ReligionType rt) {
        try {
            this.updateStatement.setString(1, rt.getName());
            this.updateStatement.setDouble(2, rt.getPercentage());
            this.updateStatement.setString(3, rt.getPrayLocation());
            this.updateStatement.setInt(4, rt.getId());
            this.updateStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReligionTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<ReligionType> selectAll(int cityId) {
        List<ReligionType> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, cityId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                ReligionType r = new ReligionType(set.getInt(1), set.getString(2), set.getDouble(3), set.getString(4));
                list.add(r);
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReligionTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatememt.setInt(1, id);
            this.deleteStatememt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReligionTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
