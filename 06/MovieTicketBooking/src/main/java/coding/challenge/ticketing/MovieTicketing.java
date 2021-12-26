package coding.challenge.ticketing;

import coding.challenge.cinema.Movie;
import coding.challenge.cinema.MovieTicket;

public interface MovieTicketing {
    // 이것은 템플릿 디자인 패턴과 같습니다.
    public boolean selectMovieBtn(Movie movie);   // step 1
    public boolean selectStartTimeBtn();          // step 2
    public boolean selectCinemaRoom();            // step 3
    public boolean selectSeats();                 // step 4

    public MovieTicket buyTicketBtn();            // step 5
}