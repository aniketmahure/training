package com.stackroute.smartparkingapp.dto;

import com.stackroute.smartparkingapp.model.Parking;

/**
 * This class represents the Parking data transfer object
 **/
public class ParkingDto extends Parking {

    /**
     * This class should have a field of type Integer (parkingId) ,two fields of type String
     * (vehicleType,dimensions)
     **/
    private Integer parkingId;
    private String vehicleType;
    private String dimensions;

    /**
     * No Args constructor
     */
    public ParkingDto() {

    }

    /**
     * parameterised constructor
     */
    public ParkingDto(String vehicleType, String dimensions) {
        this.vehicleType = vehicleType;
        this.dimensions = dimensions;
    }
    /**
     * Getters and setters
     */
    public Integer getParkingId() {
        return parkingId;
    }

    public void setParkingId(Integer parkingId) {
        this.parkingId = parkingId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }
}
