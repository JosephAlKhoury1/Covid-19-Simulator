package controller.locationController;

import controller.controllers.HousePopulationController;
import controller.controllers.HumanCityAgeContoller;
import controller.controllers.ReligionTypeController;
import controller.controllers.SexeTypeController;
import controller.datasource.DataSource;
import java.rmi.RemoteException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.client1.City;
import models.client1.HousePopulation;
import models.client1.HumanCityAgeType;
import models.client1.ReligionType;
import models.client1.SexeType;
import models.location1.LocationCategory;

public class CityController {
    
    public static final CityController INSTANCE = new CityController();
    
    private final String insert = "insert into cities(name,population,width,heigth, main, countryId)"
            + " values(?, ?, ?, ?, ?, ?)";
    private final String update = "update cities"
            + " set name = ? , population = ? , width = ? , heigth = ?, main = ?"
            + " where id=?";
    private final String selectAll = "select id , name"
            + " from cities";
    
    private final String select = "select id, name, population, width , heigth, main, countryId "
            + " from cities"
            + " where id=?";
    
    private final String getMainCity = "select id, name, population, width, heigth, main, countryId"
            + " from cities "
            + " where main=?";
    
    private final String setCityNonMain = "update cities "
            + " set main = 0 "
            + " where id=? ";
    
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement selectAllStatement;
    private PreparedStatement selectStatement;
    private PreparedStatement getMainCityStatement;
    private PreparedStatement setCityNonMainStatement;
    
    private CityController() {
        try {
            this.insertStatement = DataSource.getConnection().prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            this.updateStatement = DataSource.getConnection().prepareStatement(this.update);
            this.selectAllStatement = DataSource.getConnection().prepareStatement(this.selectAll);
            this.selectStatement = DataSource.getConnection().prepareStatement(this.select);
            this.getMainCityStatement = DataSource.getConnection().prepareStatement(this.getMainCity);
            this.setCityNonMainStatement = DataSource.getConnection().prepareStatement(this.setCityNonMain);
        } catch (SQLException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int insert(City c) {
        int id = -1;
        try {
            this.insertStatement.setString(1, c.getName());
            this.insertStatement.setInt(2, c.getNbPopulation());
            this.insertStatement.setInt(3, c.getWidth());
            this.insertStatement.setInt(4, c.getHeight());
            this.insertStatement.setInt(5, c.getIsMain());
            this.insertStatement.setInt(6, c.getCountryId());
            this.insertStatement.executeUpdate();
            ResultSet generatedKeys = this.insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }
            c.setId(id);
        } catch (SQLException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    
    public boolean update(City c) {
        try {
            this.updateStatement.setString(1, c.getName());
            this.updateStatement.setInt(2, c.getNbPopulation());
            this.updateStatement.setInt(3, c.getWidth());
            this.updateStatement.setInt(4, c.getHeight());
            this.updateStatement.setInt(5, c.getIsMain());
            this.updateStatement.setInt(6, c.getId());
            this.updateStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Map<Integer, String> selectAll() {
        Map<Integer, String> list = new HashMap();
        try {
            ResultSet set = this.selectAllStatement.executeQuery();
            while (set.next()) {
                list.put(set.getInt(1), set.getString(2));
            }
            set.close();
        } catch (SQLException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public City select(int id) {
        City c = null;
        try {
            List<HumanCityAgeType> listHumanAgeType = null;
            List<ReligionType> listR = null;
            List<HousePopulation> listHP = null;
            List<SexeType> listSt = null;
            this.selectStatement.setInt(1, id);
            ResultSet set = this.selectStatement.executeQuery();
            int cityId = -1;
            if (set.next()) {
                cityId = set.getInt(1);
                listHumanAgeType = HumanCityAgeContoller.INSTANCE.selectAllHumaAgeType(cityId);
                listR = ReligionTypeController.INSTANCE.selectAll(cityId);
                listHP = HousePopulationController.INSTANCE.selectAll(cityId);
                listSt = SexeTypeController.INSTANCE.selectAl(cityId);
                c = new City(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4),
                        set.getInt(5), 1, set.getInt(6), listHumanAgeType, listR, listHP, listSt);
                Map<String, LocationCategory> mapLocation = LocationCategoryController.INSTANCE.selectAllMap(c);
                c.setMapLocation(mapLocation);
                c.setIsMain(1);
                this.update(c);
            }
        } catch (SQLException | RemoteException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public City getMainCity(int i) {
        City c = null;
        try {
            List<HumanCityAgeType> listHumanAgeType = null;
            List<ReligionType> listR = null;
            List<HousePopulation> listHP = null;
            List<SexeType> listSt = null;
            this.getMainCityStatement.setInt(1, i);
            ResultSet set = this.getMainCityStatement.executeQuery();
            int cityId = -1;
            if (set.next()) {
                cityId = set.getInt(1);
                listHumanAgeType = HumanCityAgeContoller.INSTANCE.selectAllHumaAgeType(cityId);
                listR = ReligionTypeController.INSTANCE.selectAll(cityId);
                listHP = HousePopulationController.INSTANCE.selectAll(cityId);
                listSt = SexeTypeController.INSTANCE.selectAl(cityId);
                c = new City(set.getInt(1), set.getString(2), set.getInt(3), set.getInt(4),
                        set.getInt(5), 1, set.getInt(6), listHumanAgeType, listR, listHP, listSt);
                Map<String, LocationCategory> mapLocation = LocationCategoryController.INSTANCE.selectAllMap(c);
                c.setMapLocation(mapLocation);
            }
        } catch (SQLException | RemoteException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public void setCityNonMain(int id) {
        try {
            this.setCityNonMainStatement.setInt(1, id);
            this.setCityNonMainStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CityController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
