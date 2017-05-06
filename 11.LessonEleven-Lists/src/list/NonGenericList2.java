package list;

public class NonGenericList2 {
	private Object[] myArray;
	private int size;

	public NonGenericList2() {
		myArray = new Object[10];
	}

	public Object get(int index) {
		return index < size && index > -1 ? myArray[index] : null;
	}

	public Object Exists(Object obj) {
		for (int i = 0; i < myArray.length; i++)
			if (myArray[i].equals(obj))
				return true;

		return false;
	}

	public void add(Object obj) {
		if (myArray.length - size < 3)
			expandArray();

		myArray[size++] = obj;
	}

	public void add(Object obj, int index) {
		if (index > size && index < -1)
			return;

		if (myArray.length - size < 3)
			expandArray();

		for (int i = size; i >= index; i--)
			myArray[i + 1] = myArray[i];

		myArray[index] = obj;
		size++;
	}

	public Object remove(int index) {
		if (index > size && index < -1)
			return null;

		Object obj = myArray[index];
		myArray[index] = null;
		int tmp = index;
		while (tmp < size) {
			myArray[tmp] = myArray[tmp + 1];
			myArray[tmp + 1] = null;
			tmp++;
		}
		size--;
		return obj;
	}

	public Object remove(Object obj) {
		for (int i = 0; i < myArray.length; i++)
			if (myArray[i].equals(obj)) {
				size--;
				return obj;
			}

		return null;
	}

	public int size() {
		return size;
	}

	private void expandArray() {
		Object[] newArray = new Object[myArray.length * 2];
		for (int i = 0; i < myArray.length; i++)
			newArray[i] = myArray[i];
		
		myArray = newArray;
	}
}
