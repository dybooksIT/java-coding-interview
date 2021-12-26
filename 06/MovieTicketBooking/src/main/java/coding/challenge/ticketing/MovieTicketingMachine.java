package coding.challenge.ticketing;

import coding.challenge.cinema.Cinema;
import coding.challenge.cinema.CinemaRoom;
import coding.challenge.cinema.CinemaRoom.Cartridge;
import coding.challenge.cinema.Movie;
import coding.challenge.cinema.MovieTicket;
import coding.challenge.cinema.Seat;
import java.time.LocalTime;
import java.util.List;

public class MovieTicketingMachine implements MovieTicketing {
    private final Cinema cinema;

    private Cartridge cartridge;
    private Movie movie;
    private LocalTime startTime;
    private CinemaRoom room;
    private List<Seat> seats;

    public MovieTicketingMachine(Cinema cinema) {
        this.cinema = cinema;

        // cinema.getCartridges(); cartridge.getMovie();의 영화 목록 표시
    }

    // step 1
    @Override
    public boolean selectMovieBtn(Movie movie) { 
        // this.cartridge = cartridge
        // this.movie = movie; 

        return true; 
    }

    // Step 2
    @Override
    public boolean selectStartTimeBtn() { 
        // this.cartridge.fetchUniqueStartTimes();
        // 라디오 버튼 목록에서 시작 시간 선택
        // this.startTime = 선택한 시작 시간

        return true; 
    }

    // Step 3
    @Override
    public boolean selectCinemaRoom() {
        // this.cartridge.fetchRooms();
        // 라디오 버튼 목록에서 영화관 선택
        // this.room = 선택한 영화관

        return true;
    }

    // Step 4
    @Override
    public boolean selectSeats() {
        // this.cinema.getFreeSeatsOfRoom(room, movie);
        // 좌석 선택
        // this.seats = 선택한 좌석

        return true;
    }

    // Step 5
    @Override
    public MovieTicket buyTicketBtn() { 
        // 영화, 시작 시간, 영화관, 좌석 정보가 담긴 티켓을 구입할 시간입니다.
        // this.cinema.buyTicket(room, movie, startTime, seats);

        return null; 
    }
}