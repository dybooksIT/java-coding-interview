package coding.challenge.bad;

public class FreeMember extends Member {
    public FreeMember(String name) {
        super(name);
    }

    @Override
    public void joinTournament() {
        System.out.println("Classic member joins tournament ...");
    }

    // 이 메서드는 무료 회원이 토너먼트를 개최할 수 없으므로
    // 리스코프 치환 원칙에 맞지 않습니다. 기본 클래스를 대체할 수 없습니다.
    @Override
    public void organizeTournament() {
        System.out.println("A free member cannot organize tournaments");
    }
}
