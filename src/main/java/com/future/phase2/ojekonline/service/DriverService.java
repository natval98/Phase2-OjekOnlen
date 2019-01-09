package com.future.phase2.ojekonline.service;

import com.future.phase2.ojekonline.entity.Driver;

import java.util.List;

public interface DriverService {
    List<Driver> getAllDrivers();
    Driver getDriver(Long id);
    Driver createDriver(Driver driver);
    Driver updateDriver(Long id, Driver driver);
    boolean deleteDriver(Long id);
}
