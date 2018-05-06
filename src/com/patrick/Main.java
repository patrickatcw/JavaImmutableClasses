package com.patrick;
//start with adventuregamechallenge code
/*
Immutable means that once the constructor for an object has completed
execution that instance can't be altered. This is useful as it means you can
pass references to the object around, without worrying that someone else
is going to change its contents. Especially when dealing with concurrency,
there are no locking issues with objects that never change
 */
//https://docs.oracle.com/javase/tutorial/essential/concurrency/imstrat.html
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //initializing hashmap
    private static Map<Integer, Location> locations = new HashMap<Integer, Location>();

    public static void main(String[] args) {

        //instance for scanner
        Scanner scanner = new Scanner(System.in);

        //locations
        //step 6 move these down to each location
        //       locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
//        locations.put(1, new Location(1, "You are standing by a small building"));
//        locations.put(2, new Location(2, "You are on a hill"));
//        locations.put(3, new Location(3, "You are inside a building"));
//        locations.put(4, new Location(4, "You are by a stream"));
//        locations.put(5, new Location(5, "You are in a scary forest"));

        //step 4 create a temporary map that are going be our exits, fixes errors
        Map<String, Integer> tempExit = new HashMap<String, Integer>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java",tempExit));
        tempExit.put("W", 2); //changed through edit find replace
        //exits for each location
        //step 5 put tempExit = new HashMap<String, Integer>(); in above each
        //below
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing by a small building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are on a hill",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are by a stream",tempExit));

        tempExit = new HashMap<String, Integer>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in a scary forest",tempExit));

        //step 6 run to make sure working....yes

        //create a map for vocabulary
        Map<String, String> vocabulary = new HashMap<String, String>();
        vocabulary.put("QUIT", "Q");
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");

        //while loop
        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDesription());
            //step 7 a potential problem here....someone could remove
            //step 8 to location class
            if (loc==0) {
                break;
            }

            //directions
            Map<String, Integer> exits = locations.get(loc).getExits(); //returning actual location object
            System.out.print("Available exits are; ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            //scanner instance
            String direction = scanner.nextLine().toUpperCase();

            //put a check in here,
            if (direction.length() > 1) { //if you put in more than one letter
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word); //get retrieves value from the map
                        break;
                        //run to test
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                System.out.println("You cannot go in that direction");

            }

        }

    }

}



