package coding.challenge.cinema;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CinemaRoom {
    private String name;
    private boolean open = true;

    private final List<Seat> seats;
    private final Map<Entry<LocalTime, LocalTime>, Movie> schedule = new HashMap<>() {{
        put(Map.entry(LocalTime.of(9, 0), LocalTime.of(11, 0)), null);
        put(Map.entry(LocalTime.of(11, 0), LocalTime.of(13, 0)), null);
        put(Map.entry(LocalTime.of(13, 0), LocalTime.of(15, 0)), null);
        put(Map.entry(LocalTime.of(15, 0), LocalTime.of(17, 0)), null);
        put(Map.entry(LocalTime.of(17, 0), LocalTime.of(19, 0)), null);
        put(Map.entry(LocalTime.of(19, 0), LocalTime.of(21, 0)), null);
    }};

    protected CinemaRoom(String name) {
        this.name = name;
        seats = new ArrayList<>();
    }

    protected CinemaRoom(String name, List<Seat> seats) {
        this.name = name;
        this.seats = seats;
    }

    protected Cartridge addMovie(Movie movie, int replayNr) { // replayNr: 하루에 몇 번 재생해야 하는지
        // findFreeSlotInSchedule()을 통해 남는 슬롯 찾기
        // 새로운 Cartridge 객체 생성(하나만)
        // (addNewStartTime()을 통해) Cartridge에 영화를 추가하고 schedule 설정

        return null; // 생성된 cartridge 반환
    }

    protected boolean addMovie(Movie movie, Cartridge cartridge, int replayNr) { // replayNr: 하루에 몇 번 재생해야 하는지
        // findFreeSlotInSchedule()을 통해 남는 슬롯 찾기
        // (addNewStartTime()을 통해) Cartridge에 영화를 추가하고 schedule 설정

        return false;
    }

    protected boolean removeMovieStartTimes(Movie movie, Cartridge cartridge, List<LocalTime> startTime) {
        // (removeStartTime()을 통해) Cartridge에 영화를 제거하고 schedule 설정

        return false;
    }

    protected boolean removeMovie(Movie movie, Cartridge cartridge) {
        // (removeStartTime()을 통해) Cartridge에 영화를 제거하고 schedule 설정

        return false;
    }

    protected Map<String, String> printSchedule() {
        return null;
    } // 예: Map<9:00-11:00, 인크레더블 헐크>

    protected boolean close() {
        open = false; return open;
    }

    protected boolean open() {
        open = true; return open;
    }

    protected int addSeat(Seat seat) {
        return 0;
    }

    protected int removeSeat(Seat seat) {
        return 0;
    }

    protected int countAllSeats() {
        return 0;
    }

    protected int countFreeSeats(SeatType seat, Movie movie) {
        return 0;
    }

    protected List<Seat> getFreeSeats(Movie movie) {
        return null;
    }

    protected List<Seat> getFreeSeatsOfType(SeatType seat, Movie movie) {
        return null;
    }

    protected MovieTicket buyTicket(Movie movie, LocalTime startTime, List<Seat> seats) {
        return null;
    }

    protected List<Seat> getSeats() {
        return seats;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }   

    private Map.Entry<LocalTime, LocalTime> findFreeSlotInSchedule() {
        return null;
    }

    public final class Cartridge {
        private final Movie movie;
        private final Map<CinemaRoom, List<LocalTime>> playingIn;

        private Cartridge(Movie movie) {
            this.movie = movie;
            this.playingIn = new HashMap<>();
        }

        public Movie getMovie() {
            return movie;
        }

        public List<LocalTime> fetchUniqueStartTimes() {
            return null;
        }

        public List<CinemaRoom> fetchRooms() {
            return null;
        }

        protected boolean isFor(Movie movie) {
            return false;
        }

        private boolean addNewStartTime(CinemaRoom room, LocalTime startTime) {
            return false;
        }

        private boolean removeStartTime(CinemaRoom room, LocalTime startTime) {
            return false;
        }

        private boolean removeMovie(CinemaRoom room) {
            return false;
        }
    }
}