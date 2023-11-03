package hashmap;

import java.util.Arrays;

public class HashMap<K, V> {

	Node<K, V> node[];

	public HashMap() {

		node = new Node[10];
	}

	public void put(K key,V value) {
		
		int hashCode = key.hashCode();
		int index=hashCode % 10;
		Node<K,V> e=node[index];
		if(e==null) {
			
			node[index]=new Node<K,V>(key,value);
			
			
		}else {
			while(e!=null) {
				if(e.getKey()==key) {
					
					e.setValue(value);
					return;
				}
				e=e.next;
				
			}
			e.next=new Node<K,V>(key,value);
			
		}
		
	}
	
	public V get(K key) {
		
		int index = key.hashCode()%10;
		Node<K,V> findkey=node[index];
		while(findkey!=null) {
			
			if(key==findkey.key) {
				
				return findkey.getValue();
			}
			findkey=findkey.next;
		}
		
		return null;
	}

	

	public class Node<K, V> {

		private K key;
		private V value;
		private Node<K, V> next;

		Node(K key, V value) {

			this.key = key;
			this.value = value;
		}

		public V getValue() {

			return this.value;
		}

		public K getKey() {

			return this.key;
		}
		public void setValue(V value) {
			
			this.value=value;
		}
	}

}
