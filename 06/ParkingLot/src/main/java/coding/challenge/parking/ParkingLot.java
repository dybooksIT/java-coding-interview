package coding.challenge.parking;

import java.util.Map;

public class ParkingLot {
    private String name;
    private Map<String, ParkingFloor> floors;

    public ParkingLot(String name) {
        this.name = name;
    }

    public ParkingLot(String name, Map<String, ParkingFloor> floors) {
        this.name = name;
        this.floors = floors;
    }

    // 적절한 주차 층(ParkingFloor)으로 안내합니다.
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        for (ParkingFloor pf : floors.values()) {
            if (!pf.isFull(vehicle.getType())) {
                ParkingTicket parkingTicket = pf.parkVehicle(vehicle);
                if(parkingTicket != null) {
                    return parkingTicket;
                }
            }
        }

        return null; // null을 반환하는 것은 좋은 습관이 아닙니다.
    }

    // 층을 돌며 출차할 차량을 탐색해야 합니다.
    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingFloor pf : floors.values()) {
            boolean success = pf.unparkVehicle(vehicle);
            if(success) {
                return true;
            }
        }

        return false;
    }

    // 주차증이 있으면 출차를 위해 필요한 정보를 모두 갖춘 상태입니다.
    public boolean unparkVehicle(ParkingTicket parkingTicket) {
        return floors.get(parkingTicket.getFloorName()).unparkVehicle(parkingTicket);
    }

    public boolean isFull() {
        return false;
    }

    protected boolean isFull(VehicleType type) {
        return false;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setFloors(Map<String, ParkingFloor> floors) {
        this.floors = floors;
    }

    protected boolean addFloor(ParkingFloor floor) {
        return false;
    }

    protected boolean removeFloor(ParkingFloor floor) {
        return false;
    }
}