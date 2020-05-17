/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.client1;

import models.client.*;
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Joseph
 */
public class Data {

    public static int TileWidth = 25, TileHeight = 25;
    public static Map<Integer, ICity> listCity = new HashMap();
    public static Map<Integer, Double> housePopulationPercentage = new HashMap();

    public static Map<HumanAgeType, Double> populationAgePercentage = new HashMap();
    public static Map<HumanAgeType, Double> populationAgePercentageWithoutChildren = new HashMap();

    public static Map<ReligionType, Double> houseReligionTypePercentage = new HashMap();
    public static Map<Integer, Double> houseToVisitPercentage = new HashMap();

    public static Map<SexeType, Double> humanSex = new HashMap();
    public static int numberPopulation = 0;

    public static void initHousePopulationPercentage() {
        housePopulationPercentage.put(0, 5d);
        housePopulationPercentage.put(1, 5d);
        housePopulationPercentage.put(2, 15d);
        housePopulationPercentage.put(3, 15d);
        housePopulationPercentage.put(4, 22d);
        housePopulationPercentage.put(5, 20d);
        housePopulationPercentage.put(6, 13d);
        housePopulationPercentage.put(7, 5d);
    }

    public static void iniPopulationAgePercentage() {
        populationAgePercentage.put(HumanAgeType.under5, 5d);
        populationAgePercentage.put(HumanAgeType.between5and10, 10d);
        populationAgePercentage.put(HumanAgeType.between10and18, 13d);
        populationAgePercentage.put(HumanAgeType.between18and27, 15d);
        populationAgePercentage.put(HumanAgeType.between27and40, 15d);
        populationAgePercentage.put(HumanAgeType.between40and50, 15d);
        populationAgePercentage.put(HumanAgeType.between50and60, 10d);
        populationAgePercentage.put(HumanAgeType.between60and70, 10d);
        populationAgePercentage.put(HumanAgeType.between70and80, 5d);
        populationAgePercentage.put(HumanAgeType.above80, 2d);
    }

    /////////Childrens can't be alone in a house
    public static void initPopulationAgePercentageWithoutChildren() {
        populationAgePercentageWithoutChildren.put(HumanAgeType.under5, 0d);
        populationAgePercentageWithoutChildren.put(HumanAgeType.between5and10, 0d);
        populationAgePercentageWithoutChildren.put(HumanAgeType.between10and18, 0d);
        populationAgePercentageWithoutChildren.put(HumanAgeType.between18and27, 15d);
        populationAgePercentageWithoutChildren.put(HumanAgeType.between27and40, 25d);
        populationAgePercentageWithoutChildren.put(HumanAgeType.between40and50, 20d);
        populationAgePercentageWithoutChildren.put(HumanAgeType.between50and60, 20d);
        populationAgePercentageWithoutChildren.put(HumanAgeType.between60and70, 13d);
        populationAgePercentageWithoutChildren.put(HumanAgeType.between70and80, 5d);
        populationAgePercentageWithoutChildren.put(HumanAgeType.above80, 2d);
    }

    public static void initHouseToVisitPercentage() {
        houseToVisitPercentage.put(0, 50d);
        houseToVisitPercentage.put(1, 20d);
        houseToVisitPercentage.put(2, 15d);
        houseToVisitPercentage.put(3, 10d);
        houseToVisitPercentage.put(4, 5d);
    }

    public static void initHumanSex() {
        humanSex.put(SexeType.male, 50d);
        humanSex.put(SexeType.female, 50d);
    }

    public static void initHouseReligionTypePercentage() {
        houseReligionTypePercentage.put(ReligionType.islamicReligion, 50d);
        houseReligionTypePercentage.put(ReligionType.christianReligion, 50d);
    }

    public static void initData() {
        initHousePopulationPercentage();
        initHouseReligionTypePercentage();
        initHouseToVisitPercentage();
        initHumanSex();
        initPopulationAgePercentageWithoutChildren();
        iniPopulationAgePercentage();
    }

    public static Color getColor(HumanStat humanStat) {
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
    }
}
