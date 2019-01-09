package com.future.phase2.ojekonline.serviceimpl;

import com.future.phase2.ojekonline.entity.Driver;
import com.future.phase2.ojekonline.repository.DriverRepository;
import com.future.phase2.ojekonline.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    DriverRepository driverRepository;

    @Override
    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    @Override
    public Driver getDriver(Long id){
        return driverRepository.findDriverById(id);
    }

    @Override
    public Driver createDriver(Driver driver){
        Driver existDriver = driverRepository.findOne(driver.getId());
        if (existDriver == null) {
            return driverRepository.save(driver);

        }
        else throw new RuntimeException("Driver is already exists!");
    }

    @Override
    public Driver updateDriver(Long id, Driver driver){
        Driver existDriver = driverRepository.findDriverById(id);
        if (existDriver != null){
            existDriver.setName(driver.getName());
            existDriver.setBalance(driver.getBalance());
            existDriver.setMotorNum(driver.getMotorNum());
            return driverRepository.save(existDriver);
        }
        else throw new RuntimeException("Driver is not exists!");
    }

    @Override
    public boolean deleteDriver(Long id){
        Driver existDriver = driverRepository.findDriverById(id);
        if (existDriver != null){
            driverRepository.delete(id);
            return true;
        }
        else throw new RuntimeException("Driver is not exists!");
    }
}
