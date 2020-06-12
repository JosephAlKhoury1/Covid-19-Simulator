package models.client1;

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
        if (Data.housePopulationPercentage.isEmpty()) {
            return 0;
        }
        while (true) {
            int index = uniformFixedSeed.nextInt(Data.housePopulationPercentage.size());
            Double prob = Data.housePopulationPercentage.get(index).getPercentage() / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return index;
            }
        }
    }

    public static HumanCityAgeType getHumanAgeTypeWithoutChildren() {
        while (true) {
            int index = uniformFixedSeed.nextInt(Data.populationAgePercentageWithoutChildren.size());
            HumanCityAgeType ht = (HumanCityAgeType) Data.populationAgePercentageWithoutChildren.get(index);
            Double prob = ht.getHumanPercentage() / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return ht;
            }
        }
    }

    public static HumanCityAgeType getHumanAgeType() {
        while (true) {
            int index = uniformFixedSeed.nextInt(Data.populationAgePercentage.size());
            HumanCityAgeType ht = (HumanCityAgeType) Data.populationAgePercentage.get(index);
            Double prob = ht.getHumanPercentage() / 100d;
            double newRandom = uniformFixedSeed.nextDouble();
            if (newRandom <= prob) {
                return ht;
            }
        }
    }

    public static int getHumanAge(HumanCityAgeType humanAgeType) {
        return getNextIntBetween2Number(humanAgeType.getMin(), humanAgeType.getMax());
    }

    public static ReligionType getHouseReligionType() {
        if (Data.houseReligionTypePercentage.size() == 0) {
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
