/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.model;

import controller.controllers.SymptomStageTypeController;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Joseph
 */
public class SymptomStageType {

    private int id;
    private SymptomType symptomType;
    private SymptomStage symptomStage;
    private int day;
    private double percentage;

    private JTextField dayTxt, percentageTxt;
    private JPanel panel;

    private boolean deleted, isNew, saved;

    public SymptomStageType(SymptomType type, SymptomStage symptomStage, int day, double percentage) {
        this.symptomStage = symptomStage;
        this.symptomType = type;
        this.day = day;
        this.deleted = false;
        this.isNew = true;
        this.saved = false;
        this.percentage = percentage;
        this.percentageTxt = new JTextField(this.percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(55, 31));
        this.percentageTxt.setMaximumSize(new Dimension(55, 31));
        this.percentageTxt.setMinimumSize(new Dimension(55, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.dayTxt = new JTextField(this.day + "");
        this.dayTxt.setPreferredSize(new Dimension(55, 31));
        this.dayTxt.setMaximumSize(new Dimension(55, 31));
        this.dayTxt.setMinimumSize(new Dimension(55, 31));
        this.dayTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.dayTxt.setToolTipText("");
        this.dayTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(120, 35));
        this.panel.setMinimumSize(new Dimension(120, 35));
        this.panel.setMaximumSize(new Dimension(120, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        this.panel.add(this.dayTxt);
        this.panel.add(this.percentageTxt);
    }

    public SymptomStageType(int id, SymptomType symptom, SymptomStage stage, int day, double percentage) {
        this.symptomType = symptom;
        this.symptomStage = stage;
        this.day = day;
        this.deleted = false;
        this.isNew = false;
        this.saved = true;
        this.percentage = percentage;
        this.percentageTxt = new JTextField(this.percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(55, 31));
        this.percentageTxt.setMaximumSize(new Dimension(55, 31));
        this.percentageTxt.setMinimumSize(new Dimension(55, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.dayTxt = new JTextField(this.day + "");
        this.dayTxt.setPreferredSize(new Dimension(55, 31));
        this.dayTxt.setMaximumSize(new Dimension(55, 31));
        this.dayTxt.setMinimumSize(new Dimension(55, 31));
        this.dayTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.dayTxt.setToolTipText("");
        this.dayTxt.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.panel = new JPanel();
        this.panel.setPreferredSize(new Dimension(120, 35));
        this.panel.setMinimumSize(new Dimension(120, 35));
        this.panel.setMaximumSize(new Dimension(120, 35));
        this.panel.setBorder(BorderFactory.createEtchedBorder());
        this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.X_AXIS));

        this.panel.add(this.dayTxt);
        this.panel.add(this.percentageTxt);
    }

    public SymptomStage getSymptomStage() {
        return symptomStage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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

    public SymptomType getSymptomType() {
        return symptomType;
    }

    public void setSymptomType(SymptomType symptomType) {
        this.symptomType = symptomType;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getDayTxt() {
        return dayTxt;
    }

    public void setDayTxt(JTextField dayTxt) {
        this.dayTxt = dayTxt;
    }

    public JTextField getPercentageTxt() {
        return percentageTxt;
    }

    public void setPercentageTxt(JTextField percentageTxt) {
        this.percentageTxt = percentageTxt;
    }

    public void setSymptomStage(SymptomStage symptomStage) {
        this.symptomStage = symptomStage;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void save() {
        if (this.isDeleted()) {
            //SymptomStageTypeController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isIsNew()) {
            this.id = SymptomStageTypeController.INSTANCE.insert(this);
            this.setIsNew(false);
            this.setSaved(true);
        } else {
            if (!this.isSaved()) {
                //SymptomStageTypeController.INSTANCE.updateSymptom(this);
                this.setSaved(true);
            } else {

            }
        }
    }
}
