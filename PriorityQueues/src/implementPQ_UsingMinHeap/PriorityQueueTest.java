package implementPQ_UsingMinHeap;

public class PriorityQueueTest {
	public static void main(String[] args) throws PriorityQueueException {
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.insert("abc", 15);
		pq.insert("def", 13);
		pq.insert("xyz", 90);
		pq.insert("ghi", 150);
		pq.insert("pqr", 120);
		
		while(!pq.isEmpty())
		{
			System.out.println(pq.getMin());
			pq.removeMin();
		}
	}
}
