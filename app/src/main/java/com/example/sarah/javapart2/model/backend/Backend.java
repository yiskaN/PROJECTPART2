package com.example.sarah.javapart2.model.backend;

import android.location.Address;

import com.example.sarah.javapart2.model.datasource.Action;
import com.example.sarah.javapart2.model.entities.Driver;
import com.example.sarah.javapart2.model.entities.Trip;


import java.util.ArrayList;
import java.util.Date;

public interface Backend {
    void addDriver(final Driver driver , final Action<String> action) throws Exception;
    ArrayList<Driver> getDrivers();
    ArrayList<Trip> getTrips();
    ArrayList<Trip> getAvailableTrips();
    ArrayList<String> getDriversNames();
    ArrayList<Trip> getUnhandledTrips();
    ArrayList<Trip> getFinishedTrips();
    ArrayList<Trip> getTripsByDriver(String driverName);
    ArrayList<Trip> getTripsByCity(String city);
    ArrayList<Trip> getTripsByDistance(float distance);
    ArrayList<Trip> getTripsByDate(Date date);
    ArrayList<Trip> getTripsByPayment(float payment);
    void updateTrips(String id, String key, String value);
    boolean isComplete();//check if done geting data from FB
}
