package reHashing;

import java.util.ArrayList;

public class Map<K,V> {
	ArrayList<MapNode<K,V>> buckets;
	int count;
	int numBuckets;
	
	public Map()
	{
		buckets = new ArrayList<>();
		numBuckets = 5;
		for( int i = 0; i < numBuckets; i++)
		{
			buckets.add(null);
		}	
	}
	
	public int size()
	{
		return count;
	}
	
	private int getBucketIndex(K key)
	{
		int hc = key.hashCode();
		int index = hc % numBuckets;
		return index;
	}
	
	public void insert( K key, V value)
	{
		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		
		//element is already here, just update it's value
		while(head != null) 
		{
			if(head.key.equals(key))
			{
				head.value = value;
				return;
			}
			head = head.next;
		}
		
		//element is not there, Insert at 0th position of LinkedList
		head = buckets.get(bucketIndex);
		MapNode<K,V> newNode = new MapNode<>(key,value);
		newNode.next = head;
		buckets.set(bucketIndex, newNode);
		count++;
		
		double loadFactor = (1.0 * count)/ numBuckets;
		if(loadFactor > 0.7)
		{
			reHash();
		}
	}
	
	private void reHash()
	{
		System.out.println("Rehashing if loadFactor is greater than 0.7 :");
		ArrayList<MapNode<K,V>> temp = buckets;
		buckets = new ArrayList<>();
		for( int i = 0; i < 2*numBuckets ; i++)
		{
			buckets.add(null);
		}
		
		count = 0;  //re-inserting
		numBuckets = numBuckets * 2;
		for(int i = 0; i < temp.size(); i++)
		{
			MapNode<K,V> head = temp.get(i);
			while( head != null) {
				K key = head.key;
				V value = head.value;
				insert(key, value);
				head = head.next;
			}
		}	
	}
	
	public double loadFactor()
	{
		return (1.0 * count)/ numBuckets;
	}
	
	public V getValue(K key)
	{
		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		while( head != null)
		{
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	public V removeKey( K key)
	{
		int bucketIndex = getBucketIndex(key);
		MapNode<K,V> head = buckets.get(bucketIndex);
		MapNode<K,V> prev = null;
		while(head != null)
		{
			if(head.key.equals(key))
			{
				if(prev != null)
				{
					prev.next = head.next;
				}
				else {
					buckets.set(bucketIndex, head.next);
				}
				count--;
				return head.value;
			}
			prev = head;
			head = head.next;
		}
		return null;
	}
	
	
	
	

}
