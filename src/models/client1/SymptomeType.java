package models.client1;

import models.client.*;

/**
 *
 * @author Joseph
 */
public enum SymptomeType {
    NO_SYMPTOMS("NoSymptoms"),
    MILD_SYMPTOMS("MildSymptoms"),
    SEVERE_SYMPTOMS("SevereSymptoms"),
    CRITICAL_SYMPTOMS("CriticalSymptoms"),
    HOSPITALIZATION("Hospitalization"),
    ICU("Icu"),
    IMMUNE("Immune"),
    DEAD("Dead"),
    IMMUNEORDEAD("ImmuneOrDead");
    private String type;

    private SymptomeType(String type) {
        this.type = type;
    }
}
