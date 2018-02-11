
public class BinaryHeap<T extends Comparable<T>> {

	private static int DEFAULT_CAPACITY = 100;

	private T[] t;

	private static int capacity = 0;

	public BinaryHeap() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public BinaryHeap(int capacity) {
		t = (T[]) new Comparable[capacity + 1];
		capacity = 0;
	}

	@SuppressWarnings("unchecked")
	public BinaryHeap(T[] objects) {
		capacity = objects.length;
		t = (T[]) new Comparable[capacity * 2 + 1];
		int i = 1;
		for (T object : objects) {
			t[i++] = object;
		}
		buildHeap();
	}

	public void buildHeap() {
		for (int i = capacity / 2; i >= 1; i--) {
			heapify(i);
		}
	}

	public void heapify(int i) { // max_heap
		int index = i;
		int left = 2 * i;
		int right = 2 * i + 1;

		if (left <= capacity && t[left].compareTo(t[i]) > 0) {
			index = left;
		} else {
			index = i;
		}

		if (right <= capacity && t[right].compareTo(t[index]) > 0) {
			index = right;
		}

		if (index != i) {
			T temp = t[index];
			t[index] = t[i];
			t[i] = temp;
			heapify(index);
		}

	}

	public void insert(T object) {
		if (capacity == t.length - 1) {
			increaseCapacity(capacity * 2 + 1);
		}
	}

	@SuppressWarnings("unchecked")
	public void increaseCapacity(int size) {
		T[] old = t;
		t = (T[]) new Comparable[size];
		for (int i = 0; i < old.length; i++) {
			t[i] = old[i];
		}
	}

	public T findMax() {
		if (capacity == 0) {
			return null;
		}
		return t[1];
	}

	public T deleteMax() {
		if (capacity == 0) {
			return null;
		}

		T max = findMax();
		t[1] = t[capacity--];
		heapify(1);
		return max;
	}

}
