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
            return "<html><p>Create new city. Specify the name<br/>"
                    + "name can't be null or begin with space.";
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
    
}
