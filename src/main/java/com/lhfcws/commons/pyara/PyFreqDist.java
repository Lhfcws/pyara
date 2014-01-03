package com.lhfcws.commons.pyara;

public class PyFreqDist<K extends Comparable<K>> extends PyMap<K, Integer> {
	public void incr(K key) {
		this.incr(key, 1);
	}
	
	public void incr(K key, int v) {
		this.setDefault(key, 0);
		int val = this.get(key);
		this.put(key, val + v);
	}
	
	public double freq(K key) {
		if (!this.containsKey(key))
			return 0;
		int sum = 0;
		for (int val : this.values()) {
			sum += val;
		}
		return 1.0 * this.get(key) / sum;
	}
}
