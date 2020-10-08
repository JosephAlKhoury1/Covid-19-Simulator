package resources.icon;

public class Messages {

    public final static String EngLang = "eng";
    public final static String FraLang = "fra";
    public final static String ArLang = "ar";

    public static String currantLanguage = EngLang;
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
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Choose the virus model you want to open.";
        } else {
            return "";
        }
    }

    public static String getNoModelToBeLoadedWarningMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "No model exist!";
        } else {
            return "";
        }
    }

    public static String getCreatModelExistErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "The model name exist!";
        } else {
            return "";
        }
    }

    public static String getCreatModelNullErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "The model name can't be null!";
        } else {
            return "";
        }
    }

    public static String getCreatModelHelpMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Create a new model.";
        } else {
            return "";
        }
    }

    public static String getCreateModelStartSpaceErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Name can't start with a space!";
        } else {
            return "";
        }
    }

    public static String createNewLocationHelpMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "<html><p>Create new locations. Specify the quantity,<br/> open days and open and close time.</p></html> ";
        } else {
            return "";
        }
    }

    public static String createNewLocationQuantityMusstBeNumber() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Quantity must be a number!";
        } else {
            return "";
        }
    }

    public static String createNewLocationQuantityCantbeNull() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Quantity can't be 0.";
        } else {
            return "";
        }
    }

    public static String newCityHelpMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "<html><p>Create new city. Specify the name.<br/>"
                    + "Name can't be null or begin with space.";
        } else {
            return "";
        }
    }

    public static String newCityExistErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "This name exist!";
        } else {
            return "";
        }
    }

    public static String newCityNullErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "City name can't be null";
        } else {
            return "";
        }
    }

    public static String newCityStartSpaceErrorMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "City name can't start with space!";
        } else {
            return "";
        }
    }

    public static String loadCityHelpMessage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Choose the city you want to open.";
        } else {
            return "";
        }
    }

    public static String runTimeEqual0() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "The run time is 0! \n"
                    + "This will cause unlimited run time.";
        } else {
            return "";
        }
    }

    public static String infectedNumberEqual0() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "\n The infected number is 0!\n"
                    + "The statistique won't change over time. \n";
        } else {
            return "";
        }
    }

    public static String doYouWantToContinue() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "\n Do you want to continue?";
        } else {
            return "";
        }
    }

    public static String openTimeError() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Open time could not be bigger then close time!";
        } else {
            return "";
        }
    }

    public static String closeTimeError() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Close time could not be smaller then open time!";
        } else {
            return "";
        }
    }

    public static String timeExist() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "The Time you choose is including in another row!";
        } else {
            return "";
        }
    }

    public static String TimeCantBeConsidered() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "The time can't be considered!";
        } else {
            return "";
        }
    }

    public static String SymptomExist() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Symptom exist!";
        } else {
            return "";
        }
    }

    public static String AddNewSymptom() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Add a new Symptom.";
        } else {
            return "";
        }
    }

    public static String AddNewSymptomStage() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "Add a new Symptom Stage.";
        } else {
            return "";
        }
    }

    public static String SymptomStageExist() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "The symptom stage exist!";
        } else {
            return "";
        }
    }
    
    public static String HousePopulationPercentageBad() {
        if (Messages.currantLanguage.equals(Messages.EngLang)) {
            return "The sum of the percentage is not eqaul to 100 !";
        } else {
            return "";
        }
    }

}
