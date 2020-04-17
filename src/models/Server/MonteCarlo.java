/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Server;

import java.util.Random;

/**
 *
 * @author Joseph
 */
public class MonteCarlo {

    static Random uniformVarSeed = new Random();
    static Random uniformFixedSeed = new Random(123);

    public static int getNextInt(int max) {
        return uniformFixedSeed.nextInt(max);
    }

    public static int getNextIntBetween(int first, int last, int max) {
        return uniformFixedSeed.nextInt(max - last) + first;
    }

    public static int getNextIntBetween2Number(int min, int max) {
        return uniformFixedSeed.nextInt(max - min) + min;
    }

    public static int getHousePopulation() {
        while (true) {
            int index = uniformFixedSeed.nextInt(Data.housePopulationPercentage.size());
            Double prob = Data.housePopulationPercentage.get(index) / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return index;
            }
        }
    }

    public static HumanAgeType getHumanAgeType() {
        while (true) {
            int index = uniformFixedSeed.nextInt(Data.populationAgePercentage.size());
            Double prob = Data.populationAgePercentage.get(index) / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return (HumanAgeType) Data.populationAgePercentage.keySet().toArray()[index];
            }
        }
    }

    public static int getHumanAge(HumanAgeType humanAgeType) {
        while (true) {
            return getNextIntBetween2Number(humanAgeType.getMin(), humanAgeType.getMax());
        }

    }

    public static ReligionType getHouseReligionType() {
        while (true) {
            int index = uniformFixedSeed.nextInt(Data.houseReligionTypePercentage.size());
            Double prob = Data.houseReligionTypePercentage.get(index) / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return (ReligionType) Data.houseReligionTypePercentage.keySet().toArray()[index];
            }
        }
    }
}
