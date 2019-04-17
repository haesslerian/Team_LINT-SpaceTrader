package com.example.spacetrader.viewmodel;

import com.example.spacetrader.entity.Point;
import com.example.spacetrader.entity.SolarSystem;
import com.example.spacetrader.model.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * The type Travel screen view model.
 */
public class TravelScreenViewModel extends RepositoryLinkedViewModel {

    /**
     * Get nearby systems list.
     *
     * @return the list
     */
    public List<String> getNearbySystems(){
        Repository current = mRepository.getValue();
        List<SolarSystem> allSystems = Objects.requireNonNull(current).getSystemList();
        List<String> names = new LinkedList<>();
        Point currentLocation = current.getCurrentLocation();
        for(SolarSystem system : allSystems){
            int distance = system.distanceFrom(currentLocation);
            if((distance <= current.getCurrentShipFuel()) && (distance > 0)){
                names.add(system.getName());
            }
        }
        return names;
    }

    /**
     * Go to system.
     *
     * @param name  the name
     * @param event the event
     */
    public void goToSystem(String name, boolean event){
        Repository changes = mRepository.getValue();
        List<SolarSystem> allSystems = Objects.requireNonNull(changes).getSystemList();
        Point currentLocation = changes.getCurrentLocation();
        for(SolarSystem system : allSystems){
            if(system.getName().equals(name)){
                changes.setFuel(
                        changes.getCurrentShipFuel() - system.distanceFrom(currentLocation));
                changes.setCurrentLocation(system.getLocation());
                break;
            }
        }
        if(event){
            int currCredits = changes.getCredits();
            int RAND_CREDIT_BOOST = 200;
            changes.setCredits(currCredits + RAND_CREDIT_BOOST);
        }
        mRepository.setValue(changes);
    }

    /**
     * Calculate distance int.
     *
     * @param name the name
     * @return the int
     */
    public int calculateDistance(String name){
        Repository changes = mRepository.getValue();
        List<SolarSystem> allSystems = Objects.requireNonNull(changes).getSystemList();
        for(SolarSystem system : allSystems){
            if(system.getName().equals(name)){
                return system.distanceFrom(changes.getCurrentLocation());
            }
        }
        return 0;
    }

    /**
     * Buy fuel.
     */
    public void buyFuel(){
        Repository changes = mRepository.getValue();
        if((
                Objects.requireNonNull(changes).getCurrentShipFuel() < changes.getMaxFuel())
                && (changes.getCredits() > 9)){
            changes.setCredits(changes.getCredits() - 10);
            changes.setFuel(changes.getCurrentShipFuel() + 1);
        }
        mRepository.setValue(changes);
    }

}
