import org.junit.Test;
import static org.junit.Assert.*;

public class AufzugTests {
    static final int DO_NOTHING = 0;
    static final int MOVE_UP    = 1;
    static final int MOVE_DOWN  = 2;
    static final int OPEN_DOOR  = 3;
    static final int CLOSE_DOOR = 4;

    @Test
    public void move1up() {
        Aufzugsteuerung a = new Aufzugsteuerung(1, 1, 3);
        a.request(2);
        assertEquals(CLOSE_DOOR, a.action());
        assertEquals(MOVE_UP, a.action());
        assertEquals(OPEN_DOOR, a.action());
    }

    @Test
    public void move3up() {
        Aufzugsteuerung a = new Aufzugsteuerung(1, 1, 4);
        a.request(4);
        assertEquals(CLOSE_DOOR, a.action());
        assertEquals(MOVE_UP, a.action());
        assertEquals(MOVE_UP, a.action());
        assertEquals(MOVE_UP, a.action());
        assertEquals(OPEN_DOOR, a.action());
    }

    @Test
    public void move1down() {
        Aufzugsteuerung a = new Aufzugsteuerung(2, 1, 2);
        a.request(1);
        assertEquals(CLOSE_DOOR, a.action());
        assertEquals(MOVE_DOWN, a.action());
        assertEquals(OPEN_DOOR, a.action());
    }

    @Test
    public void queueWork() {
        Aufzugsteuerung a = new Aufzugsteuerung(1, 1, 4);
        a.request(2);
        a.request(4);
        a.request(3);
        assertEquals(CLOSE_DOOR, a.action());
        assertEquals(MOVE_UP, a.action());
        assertEquals(OPEN_DOOR, a.action());
        assertEquals(CLOSE_DOOR, a.action());
        assertEquals(MOVE_UP, a.action());
        assertEquals(MOVE_UP, a.action());
        assertEquals(OPEN_DOOR, a.action());
        assertEquals(CLOSE_DOOR, a.action());
        assertEquals(MOVE_DOWN, a.action());
        assertEquals(OPEN_DOOR, a.action());
    }

    @Test
    public void queueLaterRequests() {
        Aufzugsteuerung a = new Aufzugsteuerung(1, 1, 3);
        a.request(2);
        a.request(3);
        assertEquals(CLOSE_DOOR, a.action());
        assertEquals(MOVE_UP, a.action());
        a.request(1);
        assertEquals(OPEN_DOOR, a.action());
        assertEquals(CLOSE_DOOR, a.action());
        assertEquals(MOVE_UP, a.action());
        assertEquals(OPEN_DOOR, a.action());
        assertEquals(CLOSE_DOOR, a.action());
        assertEquals(MOVE_DOWN, a.action());
        assertEquals(MOVE_DOWN, a.action());
        assertEquals(OPEN_DOOR, a.action());
    }


}