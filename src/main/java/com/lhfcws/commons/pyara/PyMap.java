package com.lhfcws.commons.pyara;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Pythonize Map.
 *
 */
public class PyMap<K extends Comparable<K>, V> extends ConcurrentHashMap<K, V>
{
	/**
	 * If key is not existed then put(key, value), else do nothing.
	 * @param key
	 * @param value
	 */
    public void setDefault(K key, V value) {
    	if (!this.containsKey(key))
    		this.put(key, value);
    }
    
    /**
     * If key is not existed, return defaultValue, else return get(key). 
     * @param key
     * @param defaultValue
     * @return
     */
    public V get(K key, V defaultValue){
    	if (!this.containsKey(key))
    		return defaultValue;
    	return this.get(key);
    } 
    
    /**
     * Safe put. It'll not modify the value if the key is existed.
     * @param key
     * @param value
     */
    public void sput(K key, V value){
    	if (this.containsKey(key))
    		return;
    	this.put(key, value);
    } 
    
    /**
     * An alias of containsKey(key).
     * @param key
     * @return
     */
    public boolean hasKey(K key){
    	return this.containsKey(key);
    } 
    
    /**
     * An alias of entrySet().
     * @return
     */
    public Set<Map.Entry<K, V>> items() {
    	return this.entrySet();
    }
    
    /**
     * A value set.
     */
    public Set<V> values() {
    	Set<V> set = new PySet<V>();
    	for (K key : this.keySet()) {
    		set.add(this.get(key));
    	}
    	return set;
    } 
    
    /**
     * An alias of remove(key).
     * @param key
     * @return
     */
    public V pop(K key) {
    	return this.remove(key);
    }
    
    public void update(Map<K, V> map) {
    	for (Map.Entry<K, V> entry : map.entrySet()) {
    		this.put(entry.getKey(), entry.getValue());
    	}
    }
    
    public static <K extends Comparable<K>, V> PyMap<K, V> fromKeys(List<K> keys, V value) {
    	PyMap<K, V> pyMap = new PyMap<K, V>();
    	for (K key : keys) {
    		pyMap.put(key, value);
    	}
    	return pyMap;
    }
    
    public Map.Entry<K, V> popitem() {
    	for (Map.Entry<K, V> entry : this.items()) {
    		this.pop(entry.getKey());
    		return entry;
    	}
    	return null;
    }
}
