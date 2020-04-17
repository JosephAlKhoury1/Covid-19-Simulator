/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Server;

/**
 *
 * @author Joseph
 */
public enum ReligionType {

    christianReligion("Christian Religion"),
    islamicReligion("Islamic Religion");
    private String type;

    private ReligionType(String type) {
        this.type = type;
    }
}
