package com.example.spacetrader.viewmodel;

import com.example.spacetrader.entity.Player;
import com.example.spacetrader.entity.Point;
import com.example.spacetrader.entity.Ship;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.model.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @author haesslerian
 * @version 1.0
 *
 * Allows the user to travel to a different solar system/planet
 */
public class TravelScreenViewModel extends RepositoryLinkedViewModel {

    /**
     * Getter method for system the user can travel to
     * @return a list of solar systems that is within travel distance for the user
     */
    public List<String> getNearbySystems(){
        Repository current = mRepository.getValue();
        List<SolarSystem> allSystems = current.getUniverse().getSystemList();
        List<String> names = new LinkedList<>();
        Point currentLocation = current.getCurrentLocation();
        for(SolarSystem system : allSystems){
            int distance = system.getLocation().distanceFrom(currentLocation);
            if( distance <= current.getUserPlayer().getCurrentShip().getCurrentFuel() && distance > 0){
                names.add(system.getName());
            }
        }
        return names;
    }

    /**
     * Updates the repository with the solar system the user is travelling to
     *
     * @param name the name of the solar system to travel to
     */
    public void goToSystem(String name){
        Repository changes = mRepository.getValue();
        List<SolarSystem> allSystems = changes.getUniverse().getSystemList();
        Point currentLocation = changes.getCurrentLocation();
        for(SolarSystem system : allSystems){
            if(system.getName().equals(name)){
                changes.getUserPlayer().getCurrentShip().setCurrentFuel(changes.getUserPlayer().getCurrentShip().getCurrentFuel() - system.getLocation().distanceFrom(currentLocation));
                changes.setCurrentLocation(system.getLocation());
                break;
            }
        }
        mRepository.setValue(changes);
    }

    /**
     * Determines the distance to the next solar system
     *
     * @param name the name of the solar system to find the distance of
     * @return the distance to the solar system
     */
    public int calculateDistance(String name){
        Repository changes = mRepository.getValue();
        List<SolarSystem> allSystems = changes.getUniverse().getSystemList();
        for(SolarSystem system : allSystems){
            if(system.getName().equals(name)){
                return system.getLocation().distanceFrom(changes.getCurrentLocation());
            }
        }
        return 0;
    }

    /**
     * Reduces the the users credits and increases the amount of fuel
     */
    public void buyFuel(){
        Repository changes = mRepository.getValue();
        Player current = changes.getUserPlayer();
        Ship currShip = current.getCurrentShip();
        if(currShip.getCurrentFuel() < currShip.getFuelSize() && current.getCredits() > 9){
            changes.getUserPlayer().setCredits(current.getCredits() - 10);
            changes.getUserPlayer().getCurrentShip().setCurrentFuel(currShip.getCurrentFuel() + 1);
        }
        mRepository.setValue(changes);
    }

}
