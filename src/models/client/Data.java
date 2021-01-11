package models.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Joseph
 */
public class Data {

    public static int TileWidth = 25, TileHeight = 25;
    public static String[] tabLocation = {"House", "University", "School", "Church", "Mosque", "Restaurant", "Shop", "Factory", "Hospital"};

    public static Map<Integer, ICity> listCity = new HashMap();
    public static List<HousePopulation> housePopulationPercentage;

    public static List<HumanCityAgeType> populationAgePercentage;
    public static List<HumanCityAgeType> populationAgePercentageWithoutChildren;

    public static List<Integer> listAgeWithoutChildren, listAge;

    public static List<ReligionType> houseReligionTypePercentage;
    public static List<SexeType> sexeTypePercentage;

    public static Map<Integer, Double> houseToVisitPercentage = new HashMap();

    //public static Map<SexeType, Double> humanSex = new HashMap();
    public static int populationNumber = 0;

    public static void initHousePopulationPercentage(List<HousePopulation> listHp) {
        housePopulationPercentage = listHp;
    }

    public static void iniPopulationAgePercentage(List<HumanCityAgeType> list) {
        populationAgePercentage = list;
        listAge = new ArrayList();
        for (int i = 1; i <= 100; i++) {
            listAge.add(i);
        }
    }

    /////////Childrens can't be alone in a house
    public static void initPopulationAgePercentageWithoutChildren(List<HumanCityAgeType> list) {
        populationAgePercentageWithoutChildren = list;
        listAge = new ArrayList();
        for (int i = 10; i <= 100; i++) {
            listAge.add(i);
        }
    }

    public static void initHumanSex(List<SexeType> listS) {
        sexeTypePercentage = listS;
    }

    public static void initHouseReligionTypePercentage(List<ReligionType> listR) {
        houseReligionTypePercentage = listR;
    }

    public static void initHouseToVisitPercentage() {
        houseToVisitPercentage.put(0, 50d);
        houseToVisitPercentage.put(1, 20d);
        houseToVisitPercentage.put(2, 15d);
        houseToVisitPercentage.put(3, 10d);
        houseToVisitPercentage.put(4, 5d);
    }

    public static void initData(List<ReligionType> listR, List<HousePopulation> listHP, List<HumanCityAgeType> listHAT,
            List<SexeType> listST) {
        initHousePopulationPercentage(listHP);
        initPopulationAgePercentageWithoutChildren(listHAT);
        initHouseReligionTypePercentage(listR);
        iniPopulationAgePercentage(listHAT);
        initHumanSex(listST);
        //initHouseToVisitPercentage();
        //initHumanSex();
//        initPopulationAgePercentageWithoutChildren();
//        iniPopulationAgePercentage();
    }

    /*public static Color getColor(HumanStat humanStat) {
        if (null != humanStat) {
            switch (humanStat) {
                case healthy:
                    return Color.GREEN;
                case infected:
                    return Color.ORANGE;
                case immune:
                    return Color.WHITE;
                case inHospital:
                    return Color.RED;
                case sick:
                    return Color.YELLOW;
                case inIcu:
                    return Color.PINK;
                default:
                    break;
            }
        }
        return null;
    }*/
}
