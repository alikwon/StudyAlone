package study;

public class IntStack_4_3 {
	private int max; // ?��?��?�� ?��?�� (A?��B?�� ?���?)
	private int ptrA; // ?��?�� ?��?��?�� A
	private int ptrB; // ?��?�� ?��?��?�� B
	private int[] stk; // ?��?�� 본체

	public enum AorB {
		StackA, StackB
	};

	// ?��?��?�� ?�� ?��?��：스?��?�� 비어 ?��?��
	public class EmptyIntStackX2Exception extends RuntimeException {
		public EmptyIntStackX2Exception() {
		}
	}

	// ?��?��?�� ?�� ?��?��：스?��?�� �??�� �?
	public class OverflowIntStackX2Exception extends RuntimeException {
		public OverflowIntStackX2Exception() {
		}
	}

	// ?��?��?��
	public IntStack_4_3(int capacity) {
		ptrA = 0;
		ptrB = capacity - 1;
		max = capacity;
		try {
			stk = new int[max]; // ?��?�� 본체?�� 배열?�� ?��?��
		} catch (OutOfMemoryError e) { // ?��?��?�� ?�� ?��?��?��?��.
			max = 0;
		}
	}

	// ?��?��?�� x�? ?��?��
	public int push(AorB sw, int x) throws OverflowIntStackX2Exception {
		if (ptrA >= ptrB + 1) // ?��?��?�� �??�� �?
			throw new OverflowIntStackX2Exception();
		switch (sw) {
		case StackA:
			stk[ptrA++] = x;
			break;
		case StackB:
			stk[ptrB--] = x;
			break;
		}
		return x;
	}

	// ?��?��?��?�� ?��?��?���? ?��(�???기의 ?��?��?���? 꺼냄)
	public int pop(AorB sw) throws EmptyIntStackX2Exception {
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) // ?��?�� A�? 비어 ?��?��
				throw new EmptyIntStackX2Exception();
			x = stk[--ptrA];
			break;
		case StackB:
			if (ptrB >= max - 1) // ?��?�� B�? 비어 ?��?��
				throw new EmptyIntStackX2Exception();
			x = stk[++ptrB];
			break;
		}
		return x;
	}

	// ?��?��?��?�� ?��?��?���? ?��?��(�???기의 ?��?��?���? ?��?�� �?)
	public int peek(AorB sw) throws EmptyIntStackX2Exception {
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) // ?��?�� A�? 비어 ?��?��
				throw new EmptyIntStackX2Exception();
			x = stk[ptrA - 1];
			break;
		case StackB:
			if (ptrB >= max - 1) // ?��?�� B�? 비어 ?��?��
				throw new EmptyIntStackX2Exception();
			x = stk[ptrB + 1];
			break;
		}
		return x;
	}

	// ?��?��?��?�� x�? �??��?��?�� index(찾�? 못하�? -1)�? 반환
	public int indexOf(AorB sw, int x) {
		switch (sw) {
		case StackA:
			for (int i = ptrA - 1; i >= 0; i--) // �???기쪽�??�� ?��?�� �??��
				if (stk[i] == x)
					return i; // �??��?���?
			break;
		case StackB:
			for (int i = ptrB + 1; i < max; i++) // �???기쪽�??�� ?��?�� �??��
				if (stk[i] == x)
					return i; // �??��?���?
			break;
		}
		return -1; // �??��?��?��
	}

	// ?��?��?�� 비�?
	public void clear(AorB sw) {
		switch (sw) {
		case StackA:
			ptrA = 0;
			break;
		case StackB:
			ptrB = max - 1;
			break;
		}
	}

	// ?��?��?�� ?��?��?�� 반환 (A?? B?�� ?���?)
	public int capacity() {
		return max;
	}

	// ?��?��?�� ?��?��?��?�� ?��?��?�� ?���? 반환
	public int size(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA;
		case StackB:
			return max - ptrB - 1;
		}
		return 0;
	}

	// ?��?��?�� 비어 ?��?���??
	public boolean isEmpty(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA <= 0;
		case StackB:
			return ptrB >= max - 1;
		}
		return true;
	}

	// ?��?��?�� �??�� 찼는�??
	public boolean isFull() {
		return ptrA >= ptrB + 1;
	}

	// ?��?�� ?��?�� ?��?��?���? 바닥 ?�� �???기의 차�?�? ?��???��
	public void dump(AorB sw) {
		switch (sw) {
		case StackA:
			if (ptrA <= 0)
				System.out.println("?��?��?�� 비었?��?��?��.");
			else {
				for (int i = 0; i < ptrA; i++)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		case StackB:
			if (ptrB >= max - 1)
				System.out.println("?��?��?�� 비었?��?��?��.");
			else {
				for (int i = max - 1; i > ptrB; i--)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		}
	}
}