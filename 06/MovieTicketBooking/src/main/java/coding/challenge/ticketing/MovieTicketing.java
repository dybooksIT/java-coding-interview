package coding.challenge.ticketing;

import coding.challenge.cinema.Movie;
import coding.challenge.cinema.MovieTicket;

public interface MovieTicketing {
    // 이것은 템플릿 디자인 패턴과 같습니다.
    public boolean selectMovieBtn(Movie movie);   // 1단계
    public boolean selectStartTimeBtn();          // 2단계
    public boolean selectCinemaRoom();            // 3단계
    public boolean selectSeats();                 // 4단계

    public MovieTicket buyTicketBtn();            // 5단계
}