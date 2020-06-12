package models.model;

import controller.controllers.HumanStateController;
import java.awt.Color;

public class HumanStat {

    private int id;
    private String name;
    private Color color;
    private String colorName;
    private SymptomStage symptomeStage;

    private boolean isNew, saved, deleted;

    public HumanStat(String name, String colorName, SymptomStage stage) {
        this.name = name;
        this.symptomeStage = stage;
        this.isNew = true;
        this.saved = false;
        this.deleted = false;
        this.colorName = colorName;
        switch (colorName) {
            case ("Red"): {
                this.color = Color.RED;
                break;
            }
            case ("Green"): {
                this.color = Color.GREEN;
                break;
            }
            case ("Black"): {
                this.color = Color.BLACK;
                break;
            }
            case ("Blue"): {
                this.color = Color.BLUE;
                break;
            }
            case ("Yellow"): {
                this.color = Color.YELLOW;
                break;
            }
            case ("Orange"): {
                this.color = Color.ORANGE;
                break;
            }
            case ("Pink"): {
                this.color = Color.PINK;
                break;
            }
            case ("Gray"): {
                this.color = Color.GRAY;
                break;
            }
            case ("Cyan"): {
                this.color = Color.CYAN;
                break;
            }
            case ("Magenta"): {
                this.color = Color.MAGENTA;
                break;
            }
        }
    }

    public HumanStat(int id, String name, String colorName) {
        this.id = id;
        this.name = name;
        this.isNew = false;
        this.saved = true;
        this.deleted = false;
        this.colorName = colorName;
        switch (colorName) {
            case ("Red"): {
                this.color = Color.RED;
                break;
            }
            case ("Green"): {
                this.color = Color.GREEN;
                break;
            }
            case ("Black"): {
                this.color = Color.BLACK;
                break;
            }
            case ("Blue"): {
                this.color = Color.BLUE;
                break;
            }
            case ("Yellow"): {
                this.color = Color.YELLOW;
                break;
            }
            case ("Orange"): {
                this.color = Color.ORANGE;
                break;
            }
            case ("Pink"): {
                this.color = Color.PINK;
                break;
            }
            case ("Gray"): {
                this.color = Color.GRAY;
                break;
            }
            case ("Cyan"): {
                this.color = Color.CYAN;
                break;
            }
            case ("Magenta"): {
                this.color = Color.MAGENTA;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public SymptomStage getSymptomeStage() {
        return symptomeStage;
    }

    public void setSymptomeStage(SymptomStage symptomeStage) {
        this.symptomeStage = symptomeStage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsNew() {
        return isNew;
    }

    public void setIsNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void save() {
        if (this.isDeleted()) {
            HumanStateController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isIsNew()) {
            HumanStateController.INSTANCE.insert(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                HumanStateController.INSTANCE.update(this);
                this.setSaved(true);
            }
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
