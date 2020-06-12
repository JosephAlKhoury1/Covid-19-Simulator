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
import models.model.ReligionName;

public class ReligionNameController {

    public static final ReligionNameController INSTANCE = new ReligionNameController();

    private String insert = "insert into religionname(name, prayLoc)"
            + " values(?, ?)";
    private String selectAll = "select id , name, prayLoc"
            + " from religionname ";
    private String delete = "delete "
            + " from religionname "
            + " where id= ?";

    private PreparedStatement insertStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    public ReligionNameController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(ReligionNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(ReligionName sn) {
        int id = -1;
        try {
            this.insertStatement.setString(1, sn.getName());
            this.insertStatement.setString(2, sn.getPrayLocation());
            this.insertStatement.executeUpdate();
            ResultSet set = this.insertStatement.getGeneratedKeys();
            if (set.next()) {
                id = set.getInt(1);
            }
            sn.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ReligionNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public List<ReligionName> selectAll() {
        List<ReligionName> list = new ArrayList();
        try {

            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                ReligionName sn = new ReligionName(set.getInt(1), set.getString(2), set.getString(3));
                list.add(sn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReligionNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReligionNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
