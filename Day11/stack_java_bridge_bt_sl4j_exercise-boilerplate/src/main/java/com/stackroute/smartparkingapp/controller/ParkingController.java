package com.stackroute.smartparkingapp.controller;


import com.stackroute.smartparkingapp.dto.ParkingDto;
import com.stackroute.smartparkingapp.model.Parking;
import com.stackroute.smartparkingapp.repo.ParkingRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * As in this assignment, we are working with demonstrating the  use of sl4j for logging in microservices
 * annotate the class with @RestController annotation,@CrossOrigin and @RequestMapping
 * Please note that the default path to use this controller should be "/api/v1"
 */


@CrossOrigin("*")
@RequestMapping("api/v1")
@RestController
public class ParkingController {


    private static Logger logger = LoggerFactory.getLogger(ParkingController.class);

    private ParkingRepo parkingRepo;
    private ModelMapper modelMapper;

    public ParkingController() {
    }

    /**
     * Constructor autowiring should be implemented for the ParkingRepo, ModelMapper
     * without using the new keyword
     **/
    @Autowired
    public ParkingController(ParkingRepo parkingRepo) {
        this.parkingRepo = parkingRepo;
    }
    public ParkingController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    /**
     * API Version: 1.0
     * Define a handler method which will add new parking details by reading the Serialized
     * ParkingDto object from request body and save the Parking in database.The logger should log the required info
     * This handler method should return the status messages basis on
     * different situations:
     * 1. 201(CREATED - In case of successful creation of the task
     * 2. 400(Bad Request - In case the request is not readable
     * This handler method should map to the URL "/api/v1/parking" using HTTP POST
     * method".
     */
    @PostMapping("/parking")
    public ResponseEntity<?> addNewParking(@RequestBody Parking parkingDto){
        try{
            Parking parkingDetails = parkingRepo.save(parkingDto);
            logger.info(parkingDetails.toString());
            return new ResponseEntity<>(parkingDetails,HttpStatus.CREATED);
        }
        catch (Exception e){
            logger.error("cannot add details");
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }


    /**
     * API Version: 1.0
     * Define a handler method which will update new parking details by reading the Serialized
     * ParkingDto object from request body and update the Parking in database.The logger should log the required info
     * This handler method should return the status messages basis on
     * different situations:
     * 1. 201(CREATED - In case of successful creation of the task
     * 2. 400(Bad Request - In case the request is not readable
     * This handler method should map to the URL "/api/v1/parking" using HTTP PUT
     * method".
     */
    @PutMapping("/parking")
    public ResponseEntity<?> updateParkingDetails(@RequestBody ParkingDto parkingDto){
        try{
            Parking parking = new Parking();
            parking.setVehicleType(parkingDto.getVehicleType());
            parking.setDimensions(parkingDto.getDimensions());
            Parking parkingDetails = parkingRepo.save(parking);
            logger.info(parkingDetails.toString());
            return new ResponseEntity<>(parkingDetails,HttpStatus.CREATED);
        }
        catch (Exception e){
            logger.error("cannot update details");
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }
    /**
     * API Version: 1.0
     * Define a handler method which will retrieve all parking details
     * The logger should log the required info
     * This handler method should return the status messages basis on
     * different situations:
     * 1. 200(OK) - If the tasks found successfully
     * This handler method should map to the URL "/api/v1/parkings" using HTTP POST
     * method".
     */
    @GetMapping("/parkings")
    public ResponseEntity<?> allParkingDetails(){
            List<Parking> parkingDetails = parkingRepo.findAll();
            logger.info("List of the parking Details");
            return new ResponseEntity<>(parkingDetails,HttpStatus.OK);
    }

    /**
     * API Version: 1.0
     * Define a handler method which will Delete a parking by reading the Serialized
     * TaskDto object from request body ;
     * This handler method should return any one of the status messages basis on
     * different situations:
     * 1.200(OK) - If the parking deleted successfully.
     * 2.400(BAD REQUEST) - If the request is not readable.
     * This handler method should map to the URL "/api/v1/task" using HTTP DELETE
     * method".
     */
    @DeleteMapping("/parking")
    public ResponseEntity<?> deleteParkingDetails(@RequestBody Parking taskDto){
        try{
            parkingRepo.deleteById(taskDto.getParkingId());
            logger.info("deleted successfully");
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        }
        catch (Exception e){
            logger.error("cannot delete");
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Define the private methods as required
     **/


}
