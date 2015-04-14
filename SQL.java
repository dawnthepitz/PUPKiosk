class ListNode{//ListNode is a node of the SQL
	int data;
	ListNode next;
	ListNode prev;
	ListNode(int data){
		this.data=data;
		next=prev=null;
	}
	//next and prev are class recursions of  ListNode that serves as pointers of the linked list
}
public class SQL{//SQL=Stack-Queue-List, an overall linear data structure that has generic operations, Some methods are of same function yet of same purpose so that it would be friendly to fellow programmers to identify the data structure based on utiized operations
	private ListNode head,tail,util;
	SQL(){
		head=tail=null;
	}
	/*void destroy(){
		head = tail = null;
	}*/
	void add(int data){
		util=new ListNode(data);
		if(head==null)head=tail=util;
		else{
			tail.next=util;
			util.prev=tail;
			tail=util;
		}
	}
	void enqueue(int data){
		util=new ListNode(data);
		if(head==null)head=tail=util;
		else{
			tail.next=util;
			util.prev=tail;
			tail=util;
		}
	}
	void push(int data){
		util=new ListNode(data);
		if(head==null)head=tail=util;
		else{
			tail.next=util;
			util.prev=tail;
			tail=util;
		}
	}
	ListNode search(int data){
		for(ListNode x=head;x!=null;x=x.next)
			if(x.data==data)return x;
		return null;
	}
	ListNode head(){
		return head;
	}
	int tail(){
		return tail.data;
	}
	int front(){
		return head.data;
	}
	int rear(){
		return tail.data;
	}
	int bottom(){
		return head.data;
	}
	int top(){
		return tail.data;
	}
	boolean isEmpty(){//To determine if there is content in the SQL
		return head==null;
	}
	void delete(int data){//Removal of data in Linked Lists
		for(ListNode x=head;x!=null;x=x.next)
			if(data==x.data)
				if(x==head)dequeue();
				else if(x==tail)pop();
				else{
					x.next.prev=x.prev;
					x.prev.next=x.next;
				}
	}
	void pop(){
		if(!isEmpty()){
			tail=tail.prev;
			tail.next=null;
		}
	}
	void dequeue(){
		if(!isEmpty()){
			head=head.next;
			head.prev=null;
		}
	}
	void sort(){//Sorts data in Ascending Order
		for(ListNode x=head;x!=null;x=x.next)
			for(ListNode y=x.next;y!=null;y=y.next)
				if(x.data>y.data){
					int temp=x.data;
					x.data=y.data;
					y.data=temp;
				}
	}
	void contentout(){
		for(ListNode x=head;x!=null;x=x.next)
			System.out.print(String.valueOf(x.data)+" ");
		System.out.println("");
	}
}
