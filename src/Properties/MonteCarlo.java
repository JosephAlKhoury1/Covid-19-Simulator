package Properties;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import models.client.Data;
import models.client.HousePopulation;
import models.client.HumanCityAgeType;
import models.client.ReligionType;
import models.client.SexeType;

public class MonteCarlo {

    public static Random uniformVarSeed = new Random();
    public static Random uniformFixedSeed = new Random(123);
    static int[] housePopulation = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

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
        if (Data.housePopulationPercentage.isEmpty()) {
            int num = uniformFixedSeed.nextInt(housePopulation.length);
            return housePopulation[num];
        }
        boolean allZero = true;
        double newPer = 0;
        for (HousePopulation hp : Data.housePopulationPercentage) {
            newPer += hp.getPercentage();
            if (hp.getPercentage() > 0) {
                allZero = false;
            }
        }

        Map<HousePopulation, Double> newMap = new HashMap();
        List<HousePopulation> newList = new ArrayList();

        if (allZero) {
            double newPercentage = 100 / Data.housePopulationPercentage.size();
            for (HousePopulation ha : Data.housePopulationPercentage) {
                newMap.put(ha, newPercentage);
                newList.add(ha);
            }
        } else {
            for (HousePopulation ha : Data.housePopulationPercentage) {
                if (ha.getPercentage() != 0) {
                    double per = 100 * ha.getPercentage() / newPer;
                    newMap.put(ha, per);
                    newList.add(ha);
                }
            }
        }

        while (true) {
            int index = uniformFixedSeed.nextInt(newList.size());
            HousePopulation h = newList.get(index);
            Double prob = newMap.get(h) / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return index;
            }
        }
    }

    public static HumanCityAgeType getHumanAgeTypeWithoutChildren() {
        if (Data.populationAgePercentageWithoutChildren.isEmpty()) {
            return null;
        }
        int sumPercentage = 0;
        boolean allZero = true;
        for (HumanCityAgeType ha : Data.populationAgePercentageWithoutChildren) {
            if (ha.isMaxIsValid() && ha.isMinIsValid()) {
                sumPercentage += ha.getHumanPercentage();
                if (ha.getHumanPercentage() > 0) {
                    allZero = false;
                }
            }
        }
        Map<HumanCityAgeType, Double> newMap = new HashMap();
        List<HumanCityAgeType> newList = new ArrayList();
        if (allZero) {
            double newPercentage = 100 / Data.populationAgePercentageWithoutChildren.size();
            for (HumanCityAgeType ha : Data.populationAgePercentageWithoutChildren) {
                if (ha.isMaxIsValid() && ha.isMinIsValid()) {
                    newMap.put(ha, newPercentage);
                    newList.add(ha);
                }
            }
        } else {
            for (HumanCityAgeType ha : Data.populationAgePercentageWithoutChildren) {
                if (ha.isMaxIsValid() && ha.isMinIsValid()) {
                    if (ha.getHumanPercentage() != 0) {
                        double per = 100 * ha.getHumanPercentage() / sumPercentage;
                        newMap.put(ha, per);
                        newList.add(ha);
                    }
                }
            }
        }
        while (true) {
            int index = uniformFixedSeed.nextInt(newMap.size());
            HumanCityAgeType ht = newList.get(index);
            Double prob = newMap.get(ht) / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return ht;
            }
        }
    }

    public static HumanCityAgeType getHumanAgeType() {
        if (Data.populationAgePercentageWithoutChildren.isEmpty()) {
            return null;
        }
        int sumPercentage = 0;
        boolean allZero = true;
        for (HumanCityAgeType ha : Data.populationAgePercentage) {
            if (ha.isMaxIsValid() && ha.isMinIsValid()) {
                sumPercentage += ha.getHumanPercentage();
                if (ha.getHumanPercentage() > 0) {
                    allZero = false;
                }
            }
        }
        Map<HumanCityAgeType, Double> newMap = new HashMap();
        List<HumanCityAgeType> newList = new ArrayList();
        if (allZero) {
            double newPercentage = 100 / Data.populationAgePercentage.size();
            for (HumanCityAgeType ha : Data.populationAgePercentage) {
                if (ha.isMaxIsValid() && ha.isMinIsValid()) {
                    newMap.put(ha, newPercentage);
                    newList.add(ha);
                }
            }
        } else {
            for (HumanCityAgeType ha : Data.populationAgePercentage) {
                if (ha.isMaxIsValid() && ha.isMinIsValid()) {
                    if (ha.getHumanPercentage() != 0) {
                        double per = 100 * ha.getHumanPercentage() / sumPercentage;
                        newMap.put(ha, per);
                        newList.add(ha);
                    }
                }
            }
        }
        while (true) {
            int index = uniformFixedSeed.nextInt(newMap.size());
            HumanCityAgeType ht = newList.get(index);
            Double prob = newMap.get(ht) / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return ht;
            }
        }
    }

    public static int getHumanAge(HumanCityAgeType humanAgeType) {
        if (humanAgeType == null) {
            int index = getNextInt(100);
            return Data.listAge.get(index);
        }
        return getNextIntBetween2Number(humanAgeType.getMin(), humanAgeType.getMax());
    }

    public static ReligionType getHouseReligionType() {
        if (Data.houseReligionTypePercentage.isEmpty()) {
            return null;
        }
        ReligionType rt = null;
        while (true) {
            int index = uniformFixedSeed.nextInt(Data.houseReligionTypePercentage.size());
            rt = (ReligionType) Data.houseReligionTypePercentage.get(index);
            Double prob = rt.getPercentage() / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return rt;
            }
        }
    }

    public static SexeType getSexeType() {
        if (Data.sexeTypePercentage.isEmpty()) {
            return null;
        }
        while (true) {
            int index = uniformFixedSeed.nextInt(Data.sexeTypePercentage.size());
            SexeType st = (SexeType) Data.sexeTypePercentage.get(index);
            Double prob = st.getPercentage() / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return st;
            }
        }
    }

    public static boolean checkProb(double prob) {
        Double pro = prob / 100d;
        double newRandom = uniformFixedSeed.nextDouble();
        if (newRandom <= pro) {
            return true;
        } else {
            return false;
        }
    }
}
