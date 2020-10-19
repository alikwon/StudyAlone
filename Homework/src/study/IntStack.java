package study;

public class IntStack {
	private int max; // ?Š¤?ƒ ?š©?Ÿ‰
	private int ptr; // ?Š¤?ƒ ?¬?¸?„°
	private int[] stk; // ?Š¤?ƒ ë³¸ì²´

	// ?‹¤?–‰ ?‹œ ?˜ˆ?™¸ : ?Š¤?ƒ?´ ë¹„ì–´ ?ˆ?Œ
	public class EmptyIntStackException extends RuntimeException {
		public EmptyIntStackException() {
		}
	}

	// ?‹¤?–‰ ?‹œ ?˜ˆ?™¸ : ?Š¤?ƒ?´ ê°??“ ì°?
	public class OverflowIntStackException extends RuntimeException {
		public OverflowIntStackException() {
		}
	}

	// ?ƒ?„±?
	public IntStack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = new int[max]; // ?Š¤?ƒ ë³¸ì²´?š© ë°°ì—´?„ ?ƒ?„±
		} catch (OutOfMemoryError e) { // ?ƒ?„±?•  ?ˆ˜ ?—†?Œ
			max = 0;
		}
	}

	// ?Š¤?ƒ?— xë¥? ?‘¸?‹œ
	public int push(int x) throws OverflowIntStackException {
		if (ptr >= max) // ?Š¤?ƒ?´ ê°??“ ì°?
			throw new OverflowIntStackException();
		return stk[ptr++] = x;
	}

	// ?Š¤?ƒ?—?„œ ?°?´?„°ë¥? ?Œ(? •?ƒ?— ?ˆ?Š” ?°?´?„°ë¥? êº¼ëƒ„)
	public int pop() throws EmptyIntStackException {
		if (ptr <= 0) // ?Š¤?ƒ?´ ë¹„ì–´ ?ˆ?Œ
			throw new EmptyIntStackException();
		return stk[--ptr];
	}

	// ?Š¤?ƒ?—?„œ ?°?´?„°ë¥? ?”¼?¬(? •?ƒ?— ?ˆ?Š” ?°?´?„°ë¥? ?“¤?—¬?‹¤ë´?)
	public int peek() throws EmptyIntStackException {
		if (ptr <= 0) // ?Š¤?ƒ?´ ë¹„ì–´ ?ˆ?Œ
			throw new EmptyIntStackException();
		return stk[ptr - 1];
	}

	// ?Š¤?ƒ?—?„œ xë¥? ì°¾ì•„ ?¸?±?Š¤(?—†?œ¼ë©? ??1)ë¥? ë°˜í™˜
	public int indexOf(int x) {
		for (int i = ptr - 1; i >= 0; i--) // ? •?ƒ ìª½ì—?„œ ?„ ?˜• ê²??ƒ‰
			if (stk[i] == x)
				return i; // ê²??ƒ‰ ?„±ê³?
		return -1; // ê²??ƒ‰ ?‹¤?Œ¨
	}

	// ?Š¤?ƒ?„ ë¹„ì?
	public void clear() {
		ptr = 0;
	}

	// ?Š¤?ƒ?˜ ?š©?Ÿ‰?„ ë°˜í™˜
	public int capacity() {
		return max;
	}

	// ?Š¤?ƒ?— ?Œ“?—¬ ?ˆ?Š” ?°?´?„° ?ˆ˜ë¥? ë°˜í™˜
	public int size() {
		return ptr;
	}

	// ?Š¤?ƒ?´ ë¹„ì–´ ?ˆ?Š”ê°??
	public boolean isEmpty() {
		return ptr <= 0;
	}

	// ?Š¤?ƒ?´ ê°??“ ì°¼ëŠ”ê°??
	public boolean isFull() {
		return ptr >= max;
	}

	// ?Š¤?ƒ ?•ˆ?˜ ëª¨ë“  ?°?´?„°ë¥? ë°”ë‹¥ ?†’ ê¼???ê¸? ?ˆœ?„œë¡? ì¶œë ¥
	public void dump() {
		if (ptr <= 0)
			System.out.println("?Š¤?ƒ?´ ë¹„ì–´ ?ˆ?Šµ?‹ˆ?‹¤.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
