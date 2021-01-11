package controller.locationController;

import controller.datasource.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.location.DayRow;
import models.location.TimeRow;

public class TimeRowController {

    public final static TimeRowController INSTANCE = new TimeRowController();
    private final String insert = "insert into timerows(name, openTime, closeTime, percentage, dayRowId)"
            + "values(?, ?, ?, ?, ?)";
    private final String update = "update timerows"
            + " set name = ?, openTime = ?, closeTime = ?, percentage = ?"
            + " where id = ?";
    private final String selectAll = "select id, name, openTime, closeTime, percentage"
            + " from timerows"
            + " where dayRowId = ?";

    private final String delete = "delete "
            + " from timerows "
            + " where id =?";

    private PreparedStatement deleteStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    private TimeRowController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(TimeRow row) {
        int id = -1;
        try {
            this.insertStatement.setString(1, row.getName());
            this.insertStatement.setInt(2, row.getOpenTime());
            this.insertStatement.setInt(3, row.getCloseTime());
            this.insertStatement.setDouble(4, row.getHumanPercentage());
            this.insertStatement.setInt(5, row.getDayrow().getId());

            this.insertStatement.executeUpdate();
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            row.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean update(TimeRow row) {
        try {
            this.updateStatement.setString(1, row.getName());
            this.updateStatement.setInt(2, row.getOpenTime());
            this.updateStatement.setInt(3, row.getCloseTime());
            this.updateStatement.setDouble(4, row.getHumanPercentage());
            this.updateStatement.setInt(5, row.getId());
            this.updateStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public List<TimeRow> selectAll(DayRow day) {
        List<TimeRow> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, day.getId());
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                TimeRow tr = new TimeRow(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4), set.getDouble(5), day);
                list.add(tr);
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
