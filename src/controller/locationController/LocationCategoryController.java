package controller.locationController;

import controller.datasource.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client.City;
import models.location.DayRow;
import models.location.Location;
import models.location.LocationCategory;

public class LocationCategoryController {

    public static final LocationCategoryController INSTANCE = new LocationCategoryController();

    private final String insert = "insert into locationcategories(name, kind, quantity, percentageToBeSick,  cityid)"
            + " values(?, ?, ?, ?, ?)";
    private final String update = "update locationcategories "
            + " set name = ? , kind = ?, quantity = ?, percentageToBeSick = ?"
            + " where id = ?";
    private final String selectAll = "select id, name, kind, quantity, percentageToBeSick"
            + " from locationcategories "
            + " where cityid = ? ";

    private final String delete = "delete "
            + " from locationcategories "
            + " where id = ?";
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement deleteStatement;

    private LocationCategoryController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(this.insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.deleteStatement = DataSource.getConnection().prepareStatement(this.delete);
        } catch (SQLException ex) {
            Logger.getLogger(LocationCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int insert(LocationCategory lc) {
        int id = -1;
        try {
            this.insertStatement.setString(1, lc.getName());
            this.insertStatement.setString(2, lc.getKind());
            this.insertStatement.setInt(3, lc.getQuantity());
            this.insertStatement.setDouble(4, lc.getPercentageToBeSick());
            this.insertStatement.setInt(5, lc.getCityId());
            this.insertStatement.executeUpdate();
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            lc.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(LocationCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean update(LocationCategory lc) {
        try {
            this.updateStatement.setString(1, lc.getName());
            this.updateStatement.setString(2, lc.getKind());
            this.updateStatement.setInt(3, lc.getQuantity());
            this.updateStatement.setDouble(4, lc.getPercentageToBeSick());
            this.updateStatement.setInt(5, lc.getId());
            this.updateStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public Map<String, LocationCategory> selectAllMap(City city) {
        Map<String, LocationCategory> list = new HashMap();
        try {
            this.selectAllStatement.setInt(1, city.getId());
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                String kind = set.getString(3);
                int lcId = set.getInt(1);
                List<Location> listLoc = new ArrayList();
                if (null != kind) {
                    switch (kind) {
                        case "House":
                            listLoc = HouseController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "Hospital":
                            listLoc = HospitalController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "Church":
                            listLoc = ChurchController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "Mosque":
                            listLoc = MosqueController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "School":
                            listLoc = SchoolController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "University":
                            listLoc = UniversityController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "Restaurant":
                            listLoc = RestaurantController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "Shop":
                            listLoc = ShopController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "SuperMarket":
                            listLoc = SuperMarketController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "Factory":
                            listLoc = FactoryController.INSTANCE.selectAll(lcId, city);
                            break;
                        case "RefugeeCamp":
                            //lc.setListLocation(Re.INSTANCE.selectAll(lcId));
                            break;
                        case "DisplacementCamp":
                            //lc.setListLocation(.INSTANCE.selectAll(lcId));
                            break;
                        default:
                            break;
                    }
                }
                LocationCategory lc = new LocationCategory(set.getInt(1), set.getString(2), set.getString(3), set.getDouble(5), set.getInt(4),
                        city, listLoc);
                List<DayRow> listDay = DayRowController.INSTANCE.selectAll(lc);
                lc.setListDayRow(listDay);
                list.put(set.getString(2), lc);
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(LocationCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void delete(int id) {
        try {
            this.deleteStatement.setInt(1, id);
            this.deleteStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LocationCategoryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
