package org.donald.duck.algorithms.chapter4;

public interface DIYHashMap<K, V> {

	
	public V put(K k, V v);

	public V get(K k);

	//定义一个内部接口
	public interface Entry<K, V> {

		public K getKey();

		public V getValue();

	}
}
