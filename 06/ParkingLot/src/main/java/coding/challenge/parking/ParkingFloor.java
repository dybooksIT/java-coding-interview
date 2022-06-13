package coding.challenge.parking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static java.util.stream.Collectors.toList;

public class ParkingFloor {
    private final String name;
    private final int totalSpots;
    private final Map<String, ParkingSpot> parkingSpots = new LinkedHashMap<>();

    // 여기서는 Set를 활용했지만 검색을 최적화하기 위해
    // 주차권을 특정 순서대로 관리해도 좋습니다.
    private final Set<ParkingTicket> parkingTickets = new HashSet<>();

    private int totalFreeSpots;

    public ParkingFloor(String name, int totalSpots) {
        this.name = name;
        this.totalSpots = totalSpots;

        initialize(); // 주차 자리를 생성합니다.
    }

    protected ParkingTicket parkVehicle(Vehicle vehicle) { 
        List<ParkingSpot> spots = findSpotsToFitVehicle(vehicle);
        if(spots.isEmpty()) {
            return null;
        } // null을 반환하는 것은 좋은 습관이 아닙니다.

        assignVehicleToParkingSpots(spots, vehicle);

        ParkingTicket parkingTicket = releaseParkingTicket(vehicle, spots);
        registerParkingTicket(parkingTicket);

        return parkingTicket;
    }

    // 주차 자리를 돌며 출차할 차량을 탐색해야 합니다.
    protected boolean unparkVehicle(Vehicle vehicle) { 
        ParkingTicket parkingTicket = findParkingTicket(vehicle);

        if(!parkingTickets.contains(parkingTicket)) {
            return false;
        }

        int countSpots = 0;
        for(ParkingSpot pl: parkingSpots.values()) {
            if(pl.getVehicle()!= null && pl.getVehicle().equals(vehicle)) {
                boolean success = pl.removeVehicle();
                if(!success) {
                    return false;
                }

                if(++countSpots == vehicle.getSpotsNeeded()) {
                    break;
                }
            }
        }

        unregisterParkingTicket(parkingTicket);

        return true;
    }

    // 주차증이 있으면 출차에 필요한 정보를 모두 갖춘 상태입니다.
    protected boolean unparkVehicle(ParkingTicket parkingTicket) {
        if(!parkingTickets.contains(parkingTicket)) {
            throw new RuntimeException("This ticket is not in our system!");
        }

        List<String> spots = parkingTicket.getParkingSpotsLabels();
        for(String spot: spots) {
            boolean success = parkingSpots.get(spot).removeVehicle();
            if(!success) {
                return false;
            }
        }

        unregisterParkingTicket(parkingTicket);

        return true;
    } 

    protected boolean isFull(VehicleType type) {
        return false;
    }

    protected int countFreeSpots(VehicleType vehicleType) {
        return 0;
    }

    protected int getTotalSpots() {
        return totalSpots;
    }

    protected int getTotalFreeSpots() {
        return totalFreeSpots;
    }

    protected String getName() {
        return name;
    }

    // 예를 들어 밴(Van)의 경우 주차 자리(ParkingSpot) 두 개를 반환하고,
    // 트럭(truck)의 경우 주차 자리 다섯 개를 반환하기 때문에 List가 필요합니다.
    private List<ParkingSpot> findSpotsToFitVehicle(Vehicle vehicle) {
        int count = 0;
        List<ParkingSpot> freeSpots = new ArrayList<>();
        int neededSpots = vehicle.getSpotsNeeded();

        for(int i = 1; i <= totalSpots; i++){
            if(parkingSpots.get("#" + i).isFree()) {
                count ++;
                freeSpots.add(parkingSpots.get("#" + i));
            } else {
                count = 0;
                freeSpots.clear();
            }

            if(count == neededSpots) {
                return freeSpots;
            }
        }

        freeSpots.clear();
        return freeSpots;
    }

    private void assignVehicleToParkingSpots(List<ParkingSpot> spots, Vehicle vehicle) {
        for(ParkingSpot spot: spots) {
            spot.assignVehicle(vehicle);
        }
    }

    private ParkingTicket releaseParkingTicket(Vehicle vehicle, List<ParkingSpot> spots) {
        List<String> spotsLabels = spots.stream()
                .map(ParkingSpot::getLabel)
                .collect(toList());

        return new ParkingTicket(vehicle, spotsLabels, name);
    }

    private ParkingTicket findParkingTicket(Vehicle vehicle) {
        for(ParkingTicket pt: parkingTickets) {
            if(pt.getVehicle().equals(vehicle)) {
                return pt;
            }
        }

        return null;
    }

    private void registerParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTickets.add(parkingTicket);
    }

    private boolean unregisterParkingTicket(ParkingTicket parkingTicket) {
        return this.parkingTickets.remove(parkingTicket);
    }

    private void initialize() {
        for(int i = 1; i <= totalSpots; i++) {
            parkingSpots.put("#" + i, new ParkingSpot(this, "#" + i));
        }
    }
}