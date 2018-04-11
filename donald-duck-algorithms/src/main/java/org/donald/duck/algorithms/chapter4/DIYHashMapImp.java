package org.donald.duck.algorithms.chapter4;

public class DIYHashMapImp<K, V> implements DIYHashMap<K, V> {
	// 链表
	class Entry<K, V> implements DIYHashMap.Entry<K, V> {
		public K k;
		public V v;

		public Entry next;

		public Entry(K k, V v, Entry next) {
			this.k = k;
			this.v = v;
			this.next = next;
		}

		@Override
		public K getKey() {
			return null;
		}

		@Override
		public V getValue() {
			return null;
		}
	}

	public DIYHashMapImp(int capaticy, double defaultLoadFactor) {
		this.capaticy = capaticy;
		this.defaultLoadFactor = defaultLoadFactor;
	}

	public DIYHashMapImp(int capaticy) {
		this(capaticy, 0.75);
	}

	public DIYHashMapImp() {
		this(16, 0.75);
	}

	// 默认容量
	private int capaticy;
	// 加载因子
	private double defaultLoadFactor;
	// 数组使用长度
	private int useSize;
	// 数组
	private Entry<K, V>[] table;

	@Override
	public V put(K k, V v) {
		if (useSize > defaultLoadFactor * capaticy) {
			// 扩容
			up2Size();
		}

		int hash = hash(k);
		int index = hash % table.length;

		Entry<K, V> entry = table[index];
		Entry<K, V> newEntry = new Entry<K, V>(k, v, null);
		if (entry == null) {
			table[index] = newEntry;
		} else {
			while (entry.next != null) {
				entry = entry.next;
			}
			entry.next = newEntry;

		}
		return newEntry.getValue();
	}

	private int hash(K k) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void up2Size() {

	}

	@Override
	public V get(K k) {
		return null;
	}
}
