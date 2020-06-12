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
import models.client1.HumanCityAgeType;
import models.client1.LocationToGo;

/**
 *
 * @author Joseph
 */
public class HumanCityAgeContoller {

    public static final HumanCityAgeContoller INSTANCE = new HumanCityAgeContoller();

    private final String insert = "insert into humancityagetype(name, minAge, maxAge, humanPercentage, placeNumber, workPercentage, cityId)"
            + " values(?,?,?,?,?,?,?)";
    private final String update = "update humancityagetype  "
            + " set name = ?, minAge = ?, maxAge = ?, humanPercentage = ?, placeNumber = ?, workPercentage = ? "
            + " where id = ?";
    private final String selectAll = "select id, name, minAge, maxAge, humanPercentage, placeNumber, workPercentage "
            + " from humancityagetype  "
            + " where cityId = ? ";

    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    public HumanCityAgeContoller() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(selectAll);
        } catch (SQLException ex) {
            Logger.getLogger(HumanCityAgeContoller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insertHumanAgeType(HumanCityAgeType hat) {
        int id = -1;
        try {
            this.insertStatement.setString(1, hat.getName());
            this.insertStatement.setInt(2, hat.getMin());
            this.insertStatement.setInt(3, hat.getMax());
            this.insertStatement.setDouble(4, hat.getHumanPercentage());
            this.insertStatement.setInt(5, hat.getPlaceNumber());
            this.insertStatement.setDouble(6, hat.getWorkPercentage());
            this.insertStatement.setInt(7, hat.getCity().getId());

            int affectedRows = this.insertStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating Human age type failed, no rows affected.");
            }
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            hat.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean updateHumanAgeType(HumanCityAgeType hat) {
        try {
            this.updateStatement.setString(1, hat.getName());
            this.updateStatement.setInt(2, hat.getMin());
            this.updateStatement.setInt(3, hat.getMax());
            this.updateStatement.setDouble(4, hat.getHumanPercentage());
            this.updateStatement.setInt(5, hat.getPlaceNumber());
            this.updateStatement.setDouble(6, hat.getWorkPercentage());
            this.updateStatement.setInt(7, hat.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<HumanCityAgeType> selectAllHumaAgeType(int cityId) {
        try {
            List<HumanCityAgeType> list = new ArrayList();
            this.selectAllStatement.setInt(1, cityId);
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                List<LocationToGo> listLocationTo = LocationToGoController.INSTANCE.selectAll(set.getInt(1));
                List<String> listN = LocationToGoController.INSTANCE.selectAllName(set.getInt(1));
                list.add(new HumanCityAgeType(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4), set.getDouble(5), set.getInt(6), set.getDouble(7), listLocationTo, listN));
            }
            set.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ModelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
