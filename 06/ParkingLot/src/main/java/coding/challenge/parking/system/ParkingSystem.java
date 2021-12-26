package coding.challenge.parking.system;

import coding.challenge.parking.ParkingLot;
import coding.challenge.parking.ParkingTicket;
import coding.challenge.parking.Vehicle;
import coding.challenge.parking.VehicleType;

public class ParkingSystem implements Parking {
    private final String id;
    private final ParkingLot parkingLot;

    public ParkingSystem(String id, ParkingLot parkingLot) {
        this.id = id;
        this.parkingLot = parkingLot;
    }

    @Override
    public ParkingTicket parkVehicleBtn(String licensePlate, VehicleType type) {
        if (isFull()) {
            throw new RuntimeException("The parking is full! This is why the red light is on!");
        }

        Vehicle vehicle = new Vehicle(licensePlate, type.getSpotsNeeded(), type);

        return parkingLot.parkVehicle(vehicle);
    }

    @Override
    public boolean unparkVehicleBtn(String licensePlate, VehicleType type) {
        Vehicle vehicle = new Vehicle(licensePlate, type.getSpotsNeeded(), type);

        return parkingLot.unparkVehicle(vehicle);
    }

    @Override
    public boolean unparkVehicleBtn(ParkingTicket parkingTicket) {
        return parkingLot.unparkVehicle(parkingTicket);
    }

    public String getId() {
        return id;
    }

    // 이 플래그가 true면 주차 시스템이 빨간색 전구를 켜서 표시합니다.
    private boolean isFull() {
        return parkingLot.isFull();
    }
}