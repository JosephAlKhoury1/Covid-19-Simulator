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
import models.client.SexeType;

/**
 *
 * @author Joseph
 */
public class SexeTypeController {

    public static final SexeTypeController INSTANCE = new SexeTypeController();

    private final String insert = "insert into citysextype(name, percentage, cityid)"
            + " values(?, ?, ?)";
    private final String update = "update citysextype "
            + " set name = ?, percentage = ?"
            + " where id = ?";
    private final String selectAll = "select id, name, percentage"
            + " from citysextype"
            + " where cityid = ?";
    private final String delete = "delete"
            + " from citysextype "
            + " where id = ?";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    private SexeTypeController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(SexeTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(SexeType st) {
        int id = -1;
        try {
            this.insertStatement.setString(1, st.getName());
            this.insertStatement.setDouble(2, st.getPercentage());
            this.insertStatement.setInt(3, st.getCity().getId());
            this.insertStatement.executeUpdate();
            ResultSet set = this.insertStatement.getGeneratedKeys();
            if (set.next()) {
                id = set.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean update(SexeType st) {
        try {
            this.updateStatement.setString(1, st.getName());
            this.updateStatement.setDouble(2, st.getPercentage());
            this.updateStatement.setInt(3, st.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<SexeType> selectAl(int cityId) {
        List<SexeType> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, cityId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                list.add(new SexeType(set.getInt(1), set.getString(2), set.getDouble(3)));
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SexeTypeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
