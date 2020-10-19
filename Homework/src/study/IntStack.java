package study;

public class IntStack {
	private int max; // ?��?�� ?��?��
	private int ptr; // ?��?�� ?��?��?��
	private int[] stk; // ?��?�� 본체

	// ?��?�� ?�� ?��?�� : ?��?��?�� 비어 ?��?��
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// ?��?�� ?�� ?��?�� : ?��?��?�� �??�� �?
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// ?��?��?��
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max]; // ?��?�� 본체?�� 배열?�� ?��?��
		} catch (OutOfMemoryError e) { // ?��?��?�� ?�� ?��?��
			max = 0;
		}
	}

	// ?��?��?�� x�? ?��?��
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= max) // ?��?��?�� �??�� �?
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	// ?��?��?��?�� ?��?��?���? ?��(?��?��?�� ?��?�� ?��?��?���? 꺼냄)
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) // ?��?��?�� 비어 ?��?��
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// ?��?��?��?�� ?��?��?���? ?��?��(?��?��?�� ?��?�� ?��?��?���? ?��?��?���?)
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0) // ?��?��?�� 비어 ?��?��
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// ?��?��?��?�� x�? 찾아 ?��?��?��(?��?���? ??1)�? 반환
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) // ?��?�� 쪽에?�� ?��?�� �??��
			if (stk[i] == x)
				return i; // �??�� ?���?
		return -1; // �??�� ?��?��
	}

	// ?��?��?�� 비�?
	public void clear() {
		ptr = 0;
	}

	// ?��?��?�� ?��?��?�� 반환
	public int capacity() {
		return max;
	}

	// ?��?��?�� ?��?�� ?��?�� ?��?��?�� ?���? 반환
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

	// ?��?�� ?��?�� 모든 ?��?��?���? 바닥 ?�� �???�? ?��?���? 출력
	public void dump() {
		if (ptr <= 0)
			System.out.println("?��?��?�� 비어 ?��?��?��?��.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
