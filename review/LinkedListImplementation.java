package review;

public class LinkedListImplementation {
	int[] data;
	int size;
	int[] next;
	int head;
	int n;
	
	public LinkedListImplementation(int n) {
		this.n = n;
		data = new int[n];
		next = new int[n];
		for(int i =0;i<n; i++) {
            next[i] = -1;
		}
		size = 0;
		head = -1;
	}
	
	void addFirst(int x) {
	    if(size == n) {
	        System.out.println("List Full");
	        return;
	    }
	    data[size] = x;
	    next[size] = head; 
	    head = size;
	    size++;
	}
	
	void addLast(int x) {
		if(size==n) {
			System.out.println("exit");
			return;
		}
		if(head== -1) {
            addFirst(x);
            return;
        }
        int temp = head;
        while (next[temp] != -1) {
            temp = next[temp];
        }
        data[size] = x;
        next[size] = -1;
		next[temp] = size;
		size++;
	}
	
	void removeFirst() {
		if(head== -1) {
			 System.out.println("empty");
			 return;
		}
		head = next[head];
	}
	
	void removeLast() {
		if(head == -1) {
			System.out.println("empty");
			return;
		}
		int temp = head;
		while(next[next[temp]] != -1) {
			temp = next[temp];
		}
		next[temp] = -1;
	}
	
	void display() {
		if(head == -1) {
			System.out.println("exit");
			return;
		}
		int temp = head;
		while(temp != -1) {
			System.out.println(data[temp]);
			temp = next[temp];
		}
		System.out.println("null");
	}
	
	public static void main(String[] args) {
		LinkedListImplementation list = new LinkedListImplementation(10);
		list.addFirst(2);
		list.addLast(10);
		list.addFirst(3);
		list.addLast(20);
		list.removeFirst();
		list.removeLast();
		list.display();
	}
}
