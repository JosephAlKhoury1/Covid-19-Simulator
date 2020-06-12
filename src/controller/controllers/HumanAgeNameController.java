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
import models.model.HumanAgeName;

public class HumanAgeNameController {
    
    public static final HumanAgeNameController INSTANCE = new HumanAgeNameController();
    
    private String insert = "insert into humanagename(name, minAge, maxAge)"
            + " values(?, ?, ?)";
    private String selectAll = "select id , name, minAge, maxAge"
            + " from humanagename ";
    private String delete = "delete "
            + " from humanagename "
            + " where id= ?";
    
    private PreparedStatement insertStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;
    
    public HumanAgeNameController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(HumanAgeNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int insert(HumanAgeName sn) {
        int id = -1;
        try {
            this.insertStatement.setString(1, sn.getName());
            this.insertStatement.setInt(2, sn.getMinAge());
            this.insertStatement.setInt(3, sn.getMaxAge());
            this.insertStatement.executeUpdate();
            ResultSet set = this.insertStatement.getGeneratedKeys();
            if (set.next()) {
                id = set.getInt(1);
            }
            sn.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(HumanAgeNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public List<HumanAgeName> selectAll() {
        List<HumanAgeName> list = new ArrayList();
        try {
            
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                HumanAgeName sn = new HumanAgeName(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4));
                list.add(sn);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HumanAgeNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HumanAgeNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
