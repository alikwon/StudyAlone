package study;

public class IntStack_4_3 {
	private int max; // ?ä§?Éù?ùò ?ö©?üâ (A?ÉªB?ùò ?ï©Í≥?)
	private int ptrA; // ?ä§?Éù ?è¨?ù∏?Ñ∞ A
	private int ptrB; // ?ä§?Éù ?è¨?ù∏?Ñ∞ B
	private int[] stk; // ?ä§?Éù Î≥∏Ï≤¥

	public enum AorB {
		StackA, StackB
	};

	// ?ã§?ñâ?ï† ?ïå ?òà?ô∏ÔºöÏä§?Éù?ù¥ ÎπÑÏñ¥ ?ûà?ùå
	public class EmptyIntStackX2Exception extends RuntimeException {
		public EmptyIntStackX2Exception() {
		}
	}

	// ?ã§?ñâ?ï† ?ïå ?òà?ô∏ÔºöÏä§?Éù?ù¥ Í∞??ìù Ï∞?
	public class OverflowIntStackX2Exception extends RuntimeException {
		public OverflowIntStackX2Exception() {
		}
	}

	// ?Éù?Ñ±?ûê
	public IntStack_4_3(int capacity) {
		ptrA = 0;
		ptrB = capacity - 1;
		max = capacity;
		try {
			stk = new int[max]; // ?ä§?Éù Î≥∏Ï≤¥?ö© Î∞∞Ïó¥?ùÑ ?Éù?Ñ±
		} catch (OutOfMemoryError e) { // ?Éù?Ñ±?ï† ?àò ?óÜ?äµ?ãà?ã§.
			max = 0;
		}
	}

	// ?ä§?Éù?óê xÎ•? ?ë∏?ãú
	public int push(AorB sw, int x) throws OverflowIntStackX2Exception {
		if (ptrA >= ptrB + 1) // ?ä§?Éù?ù¥ Í∞??ìù Ï∞?
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

	// ?ä§?Éù?óê?Ñú ?ç∞?ù¥?Ñ∞Î•? ?åù(Íº???Í∏∞Ïùò ?ç∞?ù¥?Ñ∞Î•? Í∫ºÎÉÑ)
	public int pop(AorB sw) throws EmptyIntStackX2Exception {
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) // ?ä§?Éù AÍ∞? ÎπÑÏñ¥ ?ûà?ùå
				throw new EmptyIntStackX2Exception();
			x = stk[--ptrA];
			break;
		case StackB:
			if (ptrB >= max - 1) // ?ä§?Éù BÍ∞? ÎπÑÏñ¥ ?ûà?ùå
				throw new EmptyIntStackX2Exception();
			x = stk[++ptrB];
			break;
		}
		return x;
	}

	// ?ä§?Éù?óê?Ñú ?ç∞?ù¥?Ñ∞Î•? ?îº?Å¨(Íº???Í∏∞Ïùò ?ç∞?ù¥?Ñ∞Î•? ?Ç¥?é¥ Î¥?)
	public int peek(AorB sw) throws EmptyIntStackX2Exception {
		int x = 0;
		switch (sw) {
		case StackA:
			if (ptrA <= 0) // ?ä§?Éù AÍ∞? ÎπÑÏñ¥ ?ûà?ùå
				throw new EmptyIntStackX2Exception();
			x = stk[ptrA - 1];
			break;
		case StackB:
			if (ptrB >= max - 1) // ?ä§?Éù BÍ∞? ÎπÑÏñ¥ ?ûà?ùå
				throw new EmptyIntStackX2Exception();
			x = stk[ptrB + 1];
			break;
		}
		return x;
	}

	// ?ä§?Éù?óê?Ñú xÎ•? Í≤??Éâ?ïò?ó¨ index(Ï∞æÏ? Î™ªÌïòÎ©? -1)Î•? Î∞òÌôò
	public int indexOf(AorB sw, int x) {
		switch (sw) {
		case StackA:
			for (int i = ptrA - 1; i >= 0; i--) // Íº???Í∏∞Ï™ΩÎ∂??Ñ∞ ?Ñ†?òï Í≤??Éâ
				if (stk[i] == x)
					return i; // Í≤??Éâ?Ñ±Í≥?
			break;
		case StackB:
			for (int i = ptrB + 1; i < max; i++) // Íº???Í∏∞Ï™ΩÎ∂??Ñ∞ ?Ñ†?òï Í≤??Éâ
				if (stk[i] == x)
					return i; // Í≤??Éâ?Ñ±Í≥?
			break;
		}
		return -1; // Í≤??Éâ?ã§?å®
	}

	// ?ä§?Éù?ùÑ ÎπÑÏ?
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

	// ?ä§?Éù?ùò ?ö©?üâ?ùÑ Î∞òÌôò (A?? B?ùò ?ï©Í≥?)
	public int capacity() {
		return max;
	}

	// ?ä§?Éù?óê ?åì?ó¨?ûà?äî ?ç∞?ù¥?Ñ∞ ?àòÎ•? Î∞òÌôò
	public int size(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA;
		case StackB:
			return max - ptrB - 1;
		}
		return 0;
	}

	// ?ä§?Éù?ù¥ ÎπÑÏñ¥ ?ûà?äîÍ∞??
	public boolean isEmpty(AorB sw) {
		switch (sw) {
		case StackA:
			return ptrA <= 0;
		case StackB:
			return ptrB >= max - 1;
		}
		return true;
	}

	// ?ä§?Éù?ù¥ Í∞??ìù Ï∞ºÎäîÍ∞??
	public boolean isFull() {
		return ptrA >= ptrB + 1;
	}

	// ?ä§?Éù ?ïà?ùò ?Ñ∞?ù¥?Ñ∞Î•? Î∞îÎã• ?Üí Íº???Í∏∞Ïùò Ï∞®Î?Î°? ?Çò???ÉÑ
	public void dump(AorB sw) {
		switch (sw) {
		case StackA:
			if (ptrA <= 0)
				System.out.println("?ä§?Éù?ù¥ ÎπÑÏóà?äµ?ãà?ã§.");
			else {
				for (int i = 0; i < ptrA; i++)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		case StackB:
			if (ptrB >= max - 1)
				System.out.println("?ä§?Éù?ù¥ ÎπÑÏóà?äµ?ãà?ã§.");
			else {
				for (int i = max - 1; i > ptrB; i--)
					System.out.print(stk[i] + " ");
				System.out.println();
			}
			break;
		}
	}
}