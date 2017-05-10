package dictionary;

public class Dictionary<Key, Value> {

	@SuppressWarnings("unchecked")
	private Node<Key, Value>[] myArray = new Node[10];
	private int size;

	public void add(KeyValuePair<Key, Value> newData) {
		int hash = Math.abs(newData.key.hashCode());
		int arrayIndex = hash % myArray.length;

		Node<Key, Value> newItem = new Node<Key, Value>(newData, null);
		Node<Key, Value> existingItem = myArray[arrayIndex];

		if (existingItem == null) {
			myArray[arrayIndex] = newItem;
		} else {
			Node<Key, Value> temp = null;
			do {
				if (existingItem.keyValuePair.key.equals(newData.key)) {
					// If this line is un commented, a item with a key that already exists will override the existing item
					//existingItem.keyValuePair = newData;
					return;
				}

				temp = existingItem;
				existingItem = existingItem.next;

			} while (existingItem != null);
			temp.next = newItem;
		}
		size++;
	}

	public Value get(Key key) {
		int index = Math.abs(key.hashCode() % myArray.length);
		Node<Key, Value> item = myArray[index];

		while (item != null) {
			if (item.keyValuePair.key.equals(key))
				return item.keyValuePair.value;

			item = item.next;
		}
		return null;
	}

	public boolean delete(Key key) {
		int index = Math.abs(key.hashCode() % myArray.length);
		Node<Key, Value> item = myArray[index];

		if (item == null)
			return false;

		if (item.keyValuePair.key.equals(key)) {
			myArray[index] = item.next;
			size--;
			return true;
		} else {
			while ((item = item.next) != null) {
				if (item.next.keyValuePair.key.equals(key)) {
					item.next = item.next.next;
					size--;
					return true;
				}
			}
		}
		return false;
	}

	public KeyValuePair<Key, Value>[] getAllPairs() {
		@SuppressWarnings("unchecked")
		KeyValuePair<Key, Value>[] retVal = new KeyValuePair[size];
		Node<Key, Value>[] array = myArray.clone();

		int counter = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == null)
				continue;

			while (array[i] != null) {
				retVal[counter++] = array[i].keyValuePair;
				array[i] = array[i].next;
			}
		}

		return retVal;
	}

	@SuppressWarnings("hiding")
	private class Node<Key, Value> {
		private Node<Key, Value> next;
		private KeyValuePair<Key, Value> keyValuePair;

		public Node(KeyValuePair<Key, Value> keyValuePair, Node<Key, Value> next) {
			this.keyValuePair = keyValuePair;
			this.next = next;
		}
	}
}
