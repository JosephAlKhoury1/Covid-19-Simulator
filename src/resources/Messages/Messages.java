package resources.Messages;

public class Messages {

    public final static String ENG = "eng";
    public final static String FRA = "fra";
    public final static String Ar = "ar";

    public static String currantLanguage = ENG;
    public static final String PERCENTAGEOFHUMANHAVINTHISAGE = "Percentage of humans having this age";
    public static final String PERCENTAGEOFHUMANHAVINTHISAGEWITHWARNING = "Percentage of humans having this age. \n"
            + "The sum of the percentage is not equal to 100";

    public static final String SYMPTOMNAMECANTBENULLWARNING = "Symptom name can't be null";
    public static final String SYMPTOMEXISTWARNING = "Symptom exist";

    public static final String IMMUNEDEATHWARNINGMESSAGE = "The sum of the death percentage and the immune percentage is not equal to 100.";
    public static final String AGEPERCENTAGEWARNING = "The sum of the symptoms percentage in this age is not equal to 100.";

    public static final String DELETEHUMANAGE = "Are you sure you want to delete this age?";
    public static final String DELETESYMPTOMTYPE = "Are you sure you want to delete this symptom?";
    public static final String DELETESYMPTOMSTAGE = "Are you sure you want to delete this stage?";

    public static final String STOPRUNNING = "Are you sure you want to stop running?";

    public static String getLoadModelHelpMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Choose the virus model you want to open.";
        } else {
            return "";
        }
    }

    public static String getNoModelToBeLoadedWarningMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "No model exist!";
        } else {
            return "";
        }
    }

    public static String getCreatModelExistErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "The model name exist!";
        } else {
            return "";
        }
    }

    public static String getCreatModelNullErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "The model name can't be null!";
        } else {
            return "";
        }
    }

    public static String getCreatModelHelpMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "<html>Create a new model.If you choose the copy option, you have to choose a model.<br>"
                    + "It will return a copy of the model you choose.<html> ";
        } else {
            return "";
        }
    }

    public static String getCreateModelStartSpaceErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Name can't start with a space!";
        } else {
            return "";
        }
    }

    public static String createNewLocationHelpMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "<html><p>Create new locations. Specify the quantity,<br/> open days and open and close time.</p></html> ";
        } else {
            return "";
        }
    }

    public static String createNewLocationQuantityMusstBeNumber() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Quantity must be a number!";
        } else {
            return "";
        }
    }

    public static String createNewLocationQuantityCantbeNull() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Quantity can't be 0.";
        } else {
            return "";
        }
    }

    public static String newCityHelpMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "<html><p>Create new city. Specify the name.<br/>"
                    + "Name can't be null or begin with space.";
        } else {
            return "";
        }
    }

    public static String newCityExistErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "This name exist!";
        } else {
            return "";
        }
    }

    public static String newCityNullErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "City name can't be null";
        } else {
            return "";
        }
    }

    public static String newCityStartSpaceErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "City name can't start with space!";
        } else {
            return "";
        }
    }

    public static String loadCityHelpMessage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Choose the city you want to open.";
        } else {
            return "";
        }
    }

    public static String runTimeEqual0() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "The run time is 0! \n"
                    + "This will cause unlimited run time.";
        } else {
            return "";
        }
    }

    public static String infectedNumberEqual0() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "\n The infected number is 0!\n"
                    + "The statistique won't change over time. \n";
        } else {
            return "";
        }
    }

    public static String doYouWantToContinue() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "\n Do you want to continue?";
        } else {
            return "";
        }
    }

    public static String openTimeError() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Open time could not be bigger then close time!";
        } else {
            return "";
        }
    }

    public static String closeTimeError() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Close time could not be smaller then open time!";
        } else {
            return "";
        }
    }

    public static String timeExist() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "The Time you choose is including in another row!";
        } else {
            return "";
        }
    }

    public static String TimeCantBeConsidered() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "The time can't be considered!";
        } else {
            return "";
        }
    }

    public static String SymptomExist() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Symptom exist!";
        } else {
            return "";
        }
    }

    public static String AddNewSymptom() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Add a new Symptom.";
        } else {
            return "";
        }
    }

    public static String AddNewSymptomStage() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Add a new Symptom Stage.";
        } else {
            return "";
        }
    }

    public static String SymptomStageExist() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "The symptom stage exist!";
        } else {
            return "";
        }
    }

    public static String HousePopulationPercentageBad() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "The sum of the percentage is not eqaul to 100 !";
        } else {
            return "";
        }
    }

    public static String DoYouWantToRefresh() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Are you sure you want to refresh the model?\n"
                    + "This option will make you lose your data.";
        } else {
            return "";
        }
    }

    public static String deleteCityAgeWarning() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Are you sure you want to delete?\n";
        } else {
            return "";
        }
    }

    public static String cantAddCityAge() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "You can't add new age beacase you have one invalid!\n";
        } else {
            return "";
        }
    }

    public static String ThisAgeIsContainsInOtherAge() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "You can't put this age\n"
                    + "Because it is a membre in another age interval!";
        } else {
            return "";
        }
    }

    public static String YouHaveToUseAValidNumberError() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "You have to use a valid number!";
        } else {
            return "";
        }
    }

    public static String ThisAgeIsInvalid() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "This age interval is invalid!";
        } else {
            return "";
        }
    }

    public static String cantAddModelAge() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "You can't add new age beacause you have one invalid!\n";
        } else {
            return "";
        }
    }

    public static String badNumberFormat() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "This value have to be a number!\n";
        } else {
            return "";
        }
    }

    public static String minAgeCantBeHigherThanMaxAge() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Min age can't be higher than max age!\n";
        } else {
            return "";
        }
    }

    public static String maxAgeCantBeLowerThanMinAge() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Max age can't be lower than min age!\n";
        } else {
            return "";
        }
    }

    public static String timeExistInOtherInterval() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "This time exist in other interval!\n";
        } else {
            return "";
        }
    }

    public static String cantAddNewtimeInterval() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "You can't add new time beacause you have one invalid!\n";
        } else {
            return "";
        }
    }

    public static String contagiousDay() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Contagious day(Latent period)";
        } else {
            return "";
        }
    }

    public static String day() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Day";
        } else {
            return "";
        }
    }

    public static String time() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Time";
        } else {
            return "";
        }
    }

    public static String runTime() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Run time";
        } else {
            return "";
        }
    }

    public static String humanSituations() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Human Situations";
        } else {
            return "";
        }
    }

    public static String nonHospital() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Non hospital";
        } else {
            return "";
        }
    }

    public static String hospital() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Hospital";
        } else {
            return "";
        }
    }

    public static String symtoms() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Symptoms";
        } else {
            return "";
        }
    }

    public static String symptoms() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Symptoms";
        } else {
            return "";
        }
    }

    public static String percentageCanBbeGreaterThen100() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Percentage can't be greater then 100!";
        } else {
            return "";
        }
    }

    public static String error() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Error";
        } else {
            return "";
        }
    }

    public static String deleteLocation() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Delete Location";
        } else {
            return "";
        }
    }

    public static String deleteLocationMessage(String name) {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Are you sure do you want to delete the location " + name + "?";
        } else {
            return "";
        }
    }

    public static String addLocationStartWithSpaceError() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Name can't start with space!";
        } else {
            return "";
        }
    }

    public static String addLocationNameExistError() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "This name exist!";
        } else {
            return "";
        }
    }

    public static String addLocationNameNullError() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "The name can't be empty!";
        } else {
            return "";
        }
    }

    public static String numberCantBeZero() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Number can't be zero!";
        } else {
            return "";
        }
    }

    public static String numberBetween(int i, int size) {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "The number must be between " + i + " and " + size + "!";
        } else {
            return "";
        }
    }

    public static String deletePauseTimeWarning() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Are you sure do you want to delete this pause time?";
        } else {
            return "";
        }
    }

    public static String deleteHousePopulation() {
        if (Messages.currantLanguage.equals(Messages.ENG)) {
            return "Are you sure do you want to delete this population?";
        } else {
            return "";
        }
    }
}
