package com.future.phase2.ojekonline.controller;

import com.future.phase2.ojekonline.entity.Driver;
import com.future.phase2.ojekonline.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "driver")
public class DriverController {
    @Autowired
    DriverService driverService;

    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Driver>> getAllDrivers(){
        return new ResponseEntity<>(driverService.getAllDrivers(), HttpStatus.OK);
    }

    @PostMapping("/create")
    @ResponseBody
    public ResponseEntity<Driver> createDriver(@RequestBody Driver driver){
        return new ResponseEntity<>(driverService.createDriver(driver), HttpStatus.CREATED);
    }

    @GetMapping("/{id}/view")
    @ResponseBody
    public ResponseEntity<Driver> createDriver(@PathVariable Long id){
        return new ResponseEntity<>(driverService.getDriver(id), HttpStatus.OK);
    }

    @PutMapping("/{id}/edit")
    @ResponseBody
    public ResponseEntity<Driver> editDriver(@PathVariable Long id, @RequestBody Driver driver){
        return new ResponseEntity<>(driverService.updateDriver(id, driver), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/delete")
    @ResponseBody
    public ResponseEntity<String> deleteDriver(@PathVariable Long id){
        driverService.deleteDriver(id);
        return new ResponseEntity<>("Delete driver success", HttpStatus.OK);
    }

}
