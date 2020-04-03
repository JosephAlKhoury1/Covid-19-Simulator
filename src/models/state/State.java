/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.state;

/**
 *
 * @author Joseph
 */
public class State {

    public static final State SICK = new State("sick");
    public static final State HEALTHY = new State("healthy");
    public static final State DEATH = new State("death");
    public static final State RECOVERED = new State("recovered");
    public static final State SICK_NO_SYMPTOMES = new State("sick_no_symptomes");

    private String name;

    private State(String name) {
        this.name = name;
    }
}
