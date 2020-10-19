package study;


public class Gstack<E> {
	private int max;
	private int ptr;
	private E[] stk;

	// ?��?��?�� ?�� ?��?��：스?��?�� 비어 ?��?��
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {
		}
	}

	// ?��?��?�� ?�� ?��?��：스?��?�� �??�� �?
	public static class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() {
		}
	}

	// ?��?��?��
	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = (E[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// ?��?��
	public E push(E x) throws OverflowGstackException {
		if (ptr >= max)
			throw new OverflowGstackException();
		return stk[ptr++] = x;
	}

	// ?��?��?��?�� ?��?��?���? ?��(?��?��?�� ?��?�� ?��?��?���? 꺼냄)
	public E pop() throws EmptyGstackException {
		if (ptr <= 0) // ?��?��?�� 비어 ?��?��
			throw new EmptyGstackException();
		return stk[--ptr];
	}

	// ?��?��?��?�� ?��?��?���? ?��?��(?��?��?�� ?��?�� ?��?��?���? ?��?��?���?)
	public E peek() throws EmptyGstackException {
		if (ptr <= 0) // ?��?��?�� 비어 ?��?��
			throw new EmptyGstackException();
		return stk[ptr - 1];
	}

	// ?��?��?��?�� x�? �??��?��?�� index(찾�? 못하�? -1)�? 반환
	public int indexOf(E x) {
		for (int i = ptr - 1; i >= 0; i--) // �???기쪽�??�� ?��?�� �??��
			if (stk[i].equals(x))
				return i; // �??��?���?
		return -1; // �??��?��?��
	}

	// ?��?��?�� 비�?
	public void clear() {
		ptr = 0;
	}

	// ?��?��?�� ?��?��?�� 반환
	public int capacity() {
		return max;
	}

	// ?��?��?�� ?��?��?��?�� ?��?��?�� ?���? 반환
	public int size() {
		return ptr;
	}

	// ?��?��?�� 비어 ?��?���??
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// ?��?��?�� �??�� 찼는�??
	public boolean isFull() {
		return ptr >= max;
	}

	// ?��?�� ?��?�� ?��?��?���? 바닥?���???기의 차�?�? 출력?��
	public void dump() {
		if (ptr <= 0)
			System.out.println("?��?��?�� 비었?��?��?��.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
