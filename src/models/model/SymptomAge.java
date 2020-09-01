/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.model;

import controller.controllers.HumanAgeSymptomController;
import controller.controllers.SymptomStageTypeController;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Joseph
 */
public class SymptomAge {

    private int id;
    private HumanAge humanAge;
    private SymptomType symptomType;
    private double percentage;
    private JTextField percentageTxt;
    private boolean deleted, isNew, saved;

    public SymptomAge(HumanAge humanAge, SymptomType st, double percentage) {
        this.symptomType = st;
        this.percentage = percentage;
        this.humanAge = humanAge;
        this.deleted = false;
        this.isNew = true;
        this.saved = false;
        this.percentageTxt = new JTextField(this.percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(130, 31));
        this.percentageTxt.setMaximumSize(new Dimension(130, 31));
        this.percentageTxt.setMinimumSize(new Dimension(130, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
    }
    
    public SymptomAge(int id,HumanAge humanAge, SymptomType st, double percentage) {
        this.symptomType = st;
        this.percentage = percentage;
        this.humanAge = humanAge;
        this.deleted = false;
        this.isNew = true;
        this.saved = false;
        this.percentageTxt = new JTextField(this.percentage + "");
        this.percentageTxt.setPreferredSize(new Dimension(130, 31));
        this.percentageTxt.setMaximumSize(new Dimension(130, 31));
        this.percentageTxt.setMinimumSize(new Dimension(130, 31));
        this.percentageTxt.setHorizontalAlignment(SwingConstants.CENTER);
        this.percentageTxt.setToolTipText("");
        this.percentageTxt.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    public SymptomType getSymptomType() {
        return symptomType;
    }

    public void setSymptomType(SymptomType symptomType) {
        this.symptomType = symptomType;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public JTextField getPercentageTxt() {
        return percentageTxt;
    }

    public void setPercentageTxt(JTextField percentageTxt) {
        this.percentageTxt = percentageTxt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HumanAge getHumanAge() {
        return humanAge;
    }

    public void setHumanAge(HumanAge humanAge) {
        this.humanAge = humanAge;
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

    public void save() {
        if (this.isDeleted()) {
            //SymptomStageTypeController.INSTANCE.delete(this.id);
            return;
        }
        if (this.isIsNew()) {
            this.id = HumanAgeSymptomController.INSTANCE.insert(this);
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
