package com.patrick;

import java.util.HashMap;
import java.util.Map;

//class
public class Location {

    //fields or variables
    private final int locationID;
    private final String desription;
    private final Map<String, Integer> exits;

    //constructor, for location id and description
    //public Location(int locationID, String desription) {
    //step 1 add map for exits
    public Location(int locationID, String desription, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.desription = desription;
        //manually set our exits up
        //this.exits = new HashMap<String, Integer>();
        //step 2 set this.exits = to exits
        //this.exits = exits;
        //step 8 change above to....
        this.exits = new HashMap<String, Integer>(exits);
        //step 9 back to main to test run
    }

    /*//step 3, we do not need these anymore
    //method for adding exits
    public void addExit(String direction, int location){
        exits.put(direction, location);

    }*/

    //step 4 go back to main to fix errors for location and addExit

    //getters for all
    public int getLocationID() {
        return locationID;
    }

    public String getDesription() {
        return desription;
    }

    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
