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
import models.location1.DayRow;
import models.location1.LocationCategory;
import models.location1.TimeRow;

public class DayRowController {

    public static final DayRowController INSTANCE = new DayRowController();

    private final String insert = "insert into dayrows(name, used, locationCategoryId)"
            + "values(?, ?, ?)";

    private final String update = "update dayrows"
            + " set used = ? "
            + " where id = ?";
    private final String selectAll = "select id, name, used"
            + " from dayrows"
            + " where locationCategoryId = ?";

    private final String delete = "delete "
            + " from dayrows "
            + " where id = ?";

    private PreparedStatement deleteStatement;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;

    private DayRowController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(ChurchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(DayRow row) {
        int id = -1;
        try {
            this.insertStatement.setString(1, row.getName());
            this.insertStatement.setInt(2, row.getUsed());
            this.insertStatement.setInt(3, row.getLc().getId());

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

    public boolean update(DayRow row) {
        try {
            this.updateStatement.setInt(1, row.getUsed());
            this.updateStatement.setInt(2, row.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DayRowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public List<DayRow> selectAll(LocationCategory lc) {
        List<DayRow> list = new ArrayList();
        try {
            this.selectAllStatement.setInt(1, lc.getId());
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                DayRow tr = new DayRow(set.getInt(1), set.getString(2), set.getInt(3), lc);
                List<TimeRow> listTimeRow = TimeRowController.INSTANCE.selectAll(tr);
                tr.setListTimeRow(listTimeRow);
                for (TimeRow t : listTimeRow) {
                    t.initPanel();
                }
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
