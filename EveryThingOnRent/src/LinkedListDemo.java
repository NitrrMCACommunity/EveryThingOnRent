class LinkedList
	{
		node head;
		class node
		{
			int data;
			node next;
			node(int data1)
			{
				data=data1;
				next=null;
			}
		}
			public void insertStart(int x)
			{
				
				node r=new node(x);
				r.next=head;
				head=r;
			}
			public void insertend(int x)
			{
				node r=new node(x);
				if(head==null)
				{
					head=r;
					return ;
				}
				if(head!=null)
				{
					node temp=head;
					while(temp.next!=null)
						temp=temp.next;
						temp.next=r;
				}
			}
			public void insertpos(int x,int pos)
			{
				node temp=head;
				int q=1;
				node r=new node(x);
				if(head==null)
				{
					head=r;
					return;
				}
				while(q<pos-1&&temp.next!=null)
				{
					temp=temp.next;
					q++;
				}
				r.next=temp.next;
				temp.next=r;
				
				
			}
				public void display()
				{
					node temp=head;
					while(temp!=null)
					{
					System.out.println(temp.data);
					temp=temp.next;
					}
				}
						
			}

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList list=new LinkedList();
		list.insertStart(5);
		list.insertStart(6);
		list.insertStart(9);
		list.insertend(7);
		list.insertpos(4,3);
		list.display();
	}
}
