import java.util.ArrayDeque;
import java.util.Queue;

public class IntQueue {
	private final Queue<Integer> q = new ArrayDeque<>();

	/** Fuegt die Zahl x am Ende der Warteschlange ein */
	public void enqueue(int x) {
		q.add(x);
	}

	/** Liefert die erste Zahl in der Warteschlange ohne sie zu entfernen */
	public int peek() {
		return q.element();
	}

	/** Entfernt die erste Zahl aus der Warteschlange und gibt sie zurueck */
	public int dequeue() {
		return q.remove();
	}

	/** Prueft, ob die Warteschlange leer ist */
	public boolean isEmpty() {
		return q.isEmpty();
	}

}