package study;


public class Gstack<E> {
	private int max;
	private int ptr;
	private E[] stk;

	// ?‹¤?–‰?•  ?•Œ ?˜ˆ?™¸ï¼šìŠ¤?ƒ?´ ë¹„ì–´ ?ˆ?Œ
	public static class EmptyGstackException extends RuntimeException {
		public EmptyGstackException() {
		}
	}

	// ?‹¤?–‰?•  ?•Œ ?˜ˆ?™¸ï¼šìŠ¤?ƒ?´ ê°??“ ì°?
	public static class OverflowGstackException extends RuntimeException {
		public OverflowGstackException() {
		}
	}

	// ?ƒ?„±?
	public Gstack(int capacity) {
		ptr = 0;
		max = capacity;
		try {
			stk = (E[]) new Object[max];
		} catch (OutOfMemoryError e) {
			max = 0;
		}
	}

	// ?‘¸?‰¬
	public E push(E x) throws OverflowGstackException {
		if (ptr >= max)
			throw new OverflowGstackException();
		return stk[ptr++] = x;
	}

	// ?Š¤?ƒ?—?„œ ?°?´?„°ë¥? ?Œ(? •?ƒ?— ?ˆ?Š” ?°?´?„°ë¥? êº¼ëƒ„)
	public E pop() throws EmptyGstackException {
		if (ptr <= 0) // ?Š¤?ƒ?´ ë¹„ì–´ ?ˆ?Œ
			throw new EmptyGstackException();
		return stk[--ptr];
	}

	// ?Š¤?ƒ?—?„œ ?°?´?„°ë¥? ?”¼?¬(? •?ƒ?— ?ˆ?Š” ?°?´?„°ë¥? ?“¤?—¬?‹¤ë´?)
	public E peek() throws EmptyGstackException {
		if (ptr <= 0) // ?Š¤?ƒ?´ ë¹„ì–´ ?ˆ?Œ
			throw new EmptyGstackException();
		return stk[ptr - 1];
	}

	// ?Š¤?ƒ?—?„œ xë¥? ê²??ƒ‰?•˜?—¬ index(ì°¾ì? ëª»í•˜ë©? -1)ë¥? ë°˜í™˜
	public int indexOf(E x) {
		for (int i = ptr - 1; i >= 0; i--) // ê¼???ê¸°ìª½ë¶??„° ?„ ?˜• ê²??ƒ‰
			if (stk[i].equals(x))
				return i; // ê²??ƒ‰?„±ê³?
		return -1; // ê²??ƒ‰?‹¤?Œ¨
	}

	// ?Š¤?ƒ?„ ë¹„ì?
	public void clear() {
		ptr = 0;
	}

	// ?Š¤?ƒ?˜ ?š©?Ÿ‰?„ ë°˜í™˜
	public int capacity() {
		return max;
	}

	// ?Š¤?ƒ?— ?Œ“?—¬?ˆ?Š” ?°?´?„° ?ˆ˜ë¥? ë°˜í™˜
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

	// ?Š¤?ƒ ?•ˆ?˜ ?°?´?„°ë¥? ë°”ë‹¥?†’ê¼???ê¸°ì˜ ì°¨ë?ë¡? ì¶œë ¥?•¨
	public void dump() {
		if (ptr <= 0)
			System.out.println("?Š¤?ƒ?´ ë¹„ì—ˆ?Šµ?‹ˆ?‹¤.");
		else {
			for (int i = 0; i < ptr; i++)
				System.out.print(stk[i] + " ");
			System.out.println();
		}
	}
}
