package coding.challenge.cinema;

import coding.challenge.cinema.CinemaRoom.Cartridge;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Cinema {
    private final String name;

    private Map<String, CinemaRoom> rooms;

    // cartridge에는 단일 영화에 대한 정보가 있으며 상영할 영화관과 시작 시간을 알고 있습니다.
    private final List<Cartridge> cartridges = new ArrayList<>();

    protected Cinema(String name) {
        this.name = name;
    }

    protected Cinema(String name, Map<String, CinemaRoom> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public List<Seat> getFreeSeatsOfRoom(CinemaRoom room, Movie movie) {
        return null;
    }

    public MovieTicket buyTicket(CinemaRoom room, Movie movie, LocalTime startTime, List<Seat> seats) {
        return null;
    }

    protected boolean addNewMovie(CinemaRoom room, Movie movie) {
        // 이 영화에 cartridge가 있는지 확인
            // yes면 room.addMovie(movie, cartridge) 호출
            // yes가 아니면(else)
               // 1. Cartridge cartridge = room.addMovie(movie); 호출
               // 2. this.cartridges.add(cartridge); 호출

        return false; 
    }

    protected boolean addNewMovie(Movie movie) {
        return false;
    } // 모든 영화관 추가

    protected boolean addNewMovie(List<CinemaRoom> room, Movie movie) {
        return false;
    }

    protected boolean removeMovie(Movie movie) {
        // 이 영화에 cartridge가 있는지 확인
            // 그렇지 않으면(else) false를 반환합니다.
                // 1. List<CinemaRoom> rooms = cartridge.fetchRooms();
                // 2. 'rooms' 반복과 room.removeMovie(movie, cartridge); 호출
                // 3. cartridge.fetchRooms()는 비어 있어야 함.
                      // 지금 cartridge 자체를 삭제할 수 있습니다.
                             // cartridges.remove(cartridge);
                             // cartridge = null;
                      // 또는 나중에 같은 영화를 볼 때 사용하기 위해 보관하세요.

        return false;
    }
    
    protected boolean removeMovieFromRooms(Movie movie, List<CinemaRoom> rooms) {
        // 이 영화에 cartridge가 있는지 확인
            // 그렇지 않으면(else) false를 반환합니다.
                // 'rooms' 반복과 room.removeMovie(movie, cartridge); 호출

        return false;
    }

    protected boolean removeMovieStartTimes(Movie movie, List<LocalTime> startTimes) {
        // 이 영화에 cartridge가 있는지 확인
            // 그렇지 않으면(else) false를 반환합니다.
                // 1. List<CinemaRoom> rooms = cartridge.fetchRooms();
                // 2. 'rooms' 반복과 room.removeMovieStartTimes(movie, cartridge, startTimes); 호출

        return false;
    }
    
    protected boolean removeMovieFromRoomsStartTimes(Movie movie, List<CinemaRoom> rooms, List<LocalTime> startTimes) {
        // 이 영화에 cartridge가 있는지 확인
            // 그렇지 않으면(else) false를 반환합니다.
                // 1. 'rooms' 반복과 room.removeMovie(movie, cartridge); 호출
                // 2. 각 영화관을 위한 room.removeMovieStartTimes(movie, cartridge, startTimes); 호출

        return false;
    }

    public String getName() {
        return name;
    } 

    public List<Cartridge> getCartridges() {
        return List.copyOf(cartridges);        
    }        

    protected Map<String, CinemaRoom> getRooms() {        
        return rooms;
    }

    protected void setRooms(Map<String, CinemaRoom> rooms) {
        this.rooms = rooms;
    }

    protected CinemaRoom getRoom(String name) {
        return null;
    }

    protected boolean addRoom(CinemaRoom room) {
        return false;
    }

    protected boolean removeRoom(CinemaRoom room) {
        return false;
    }
}