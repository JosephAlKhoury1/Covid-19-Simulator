package models.model;

import java.awt.Color;

public class HumanStatName {

    private int id;
    private String name;
    private Color color;
    private String colorName;

    public HumanStatName(int id, String name, String colorName) {
        this.id = id;
        this.name = name;
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

    public HumanStatName(String name, String colorName) {
        this.name = name;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}
