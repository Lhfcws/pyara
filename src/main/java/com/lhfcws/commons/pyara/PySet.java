package com.lhfcws.commons.pyara;

import java.util.*;

public class PySet<V> extends HashSet<V> {
	private static final long serialVersionUID = 1L;

	public void update(Set<V> set) {
		this.addAll(set);
	}

	@SuppressWarnings("unchecked")
	public Set<V> difference(Set<V> set) {
		Set<V> result = (Set<V>) this.clone();
		
		for (V val : this) {
			if (set.contains(val))
				result.remove(val);
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Set<V> symmetricDifference(Set<V> set) {
		Set<V> result = (Set<V>) this.clone();
		
		for (V val : this) {
			if (set.contains(val))
				result.remove(val);
			else
				result.add(val);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public Set<V> union(Set<V> set) {
		Set<V> result = (Set<V>) this.clone();
		result.addAll(set);
		return result;
	}

	@SuppressWarnings("unchecked")
	public Set<V> intersection(Set<V> set) {
		Set<V> result = (Set<V>) this.clone();
		
		for (V val : this) {
			if (!set.contains(val))
				result.remove(val);
		}
		return result;
	}
	
	public Set<V> differenceUpdate(Set<V> set) {
		for (V val : this) {
			if (set.contains(val))
				this.remove(val);
		}
		return this;
	}

	public Set<V> unionUpdate(Set<V> set) {
		this.addAll(set);
		return this;
	}

	public Set<V> intersectionUpdate(Set<V> set) {
		for (V val : this) {
			if (!set.contains(val))
				this.remove(val);
		}
		return this;
	}
	
	public Set<V> symmetricDifferenceUpdate(Set<V> set) {
		for (V val : this) {
			if (set.contains(val))
				this.remove(val);
			else
				this.add(val);
		} 
		return this;
	}
	
	public boolean isSubSet(Set<V> set) {
		Set<V> result = this.union(set);
		return set.equals(result);
	}
	
	public boolean isSuperSet(Set<V> set) {
		Set<V> result = this.union(set);
		return this.equals(result);
	}
	
	public boolean isDisjoint(Set<V> set) {
		Set<V> result = this.intersection(set);
		return result.size() == 0;
	}
	
	public void discard(V val) {
		if (this.contains(val))
			this.remove(val);
	}
}
