public class Main 
{

    public static void main(String[] args) 
    {
        int [] a = {1,2,4,7,16,19};
        int [] b = {1,2,5,6,7,22};
        int [] c = {1,8,8,2,1,8,2,3,4};
        Node<Integer> p1 = buildList(a);
        Node<Integer> p2 = buildList(b);
        Node<Integer> p3 = buildList(c);
        ex_1(p1,p2);
		ex_2(p1);
		int n = ex_3(p3,8);
		System.out.println(n);
		boolean exx4 = ex_4(p2);
		System.out.println(exx4);
    }
    
	public static boolean isIn(Node <Integer> p2, int x) 
	{
		if (p2 == null)
			return false;
		if (p2.getValue() == x)
			return true;
		return isIn(p2.getNext(), x);
	}
    
    public static Node<Integer> buildList(int[] a) 
	{
		Node<Integer> head = new Node<Integer>(-1);
		Node<Integer> p = head;
		Node<Integer> x;
		for (int i=0; i<a.length;i++) 
		{
			x = new Node<Integer>(a[i]);
			p.setNext(x);
			p = p.getNext();
		}
		return head.getNext();
	}
    
    public static Node <Integer> ex_1(Node <Integer> p1, Node <Integer> p2)
    {
        Node<Integer> head = new Node<Integer>(-1);
        Node<Integer> newList = head;
        while (p1!=null && p2!=null)
        {
            if (p1.getValue()>p2.getValue())
            {
                newList.setNext(new Node <Integer>(p2.getValue()));
                p2 = p2.getNext();
                newList = newList.getNext();
            }
            if (p1.getValue()<p2.getValue())
            {
                newList.setNext(new Node <Integer>(p1.getValue()));
                p1 = p1.getNext();
                newList = newList.getNext();
            }
            else
            {
                newList.setNext(new Node <Integer>(p1.getValue()));
                p1 = p1.getNext();
                p2 = p2.getNext();
                newList = newList.getNext();
            }
        }
        while (p1!=null) 
        {
            newList.setNext(new Node<Integer>(p1.getValue()));
            newList = newList.getNext();
            p1 = p1.getNext();
        }

        while (p2!=null) 
        {
            newList.setNext(new Node<Integer>(p2.getValue()));
            newList = newList.getNext();
            p2 = p2.getNext();
        }
        System.out.println(head);
        return head.getNext();
    }

    public static Node<Integer> ex_2(Node<Integer> p1)
    {
        Node<Integer> head=new Node<Integer>(-1); 
        Node<Integer> p=head;
    
        while(p1 != null)
        {
            Node<Integer> fake = new Node<Integer>(-1,p1);
            Node<Integer> t=fake;
            Node<Integer> minPrev=fake;
            int min= p1.getValue();
            while(t.getNext()!=null)
            {
                if(t.getNext().getValue()<min)
                {
                    min=t.getNext().getValue();
                    minPrev=t;
                }
                t=t.getNext();
            }
            Node<Integer> minNode = minPrev.getNext();
            minPrev.setNext(minNode.getNext());
            p1 = fake.getNext();
            p.setNext(new Node<Integer>(min));
            p=p.getNext();
        }
        return head.getNext();
    }
    
    public static int ex_3(Node <Integer> p3,int x)
    {
        int z=0;
        int distanceSum =0;
        int distanceEnd =0;
        int distanceStart =0;
        Node<Integer> p=p3;
        while (p.getValue()!=x)
        {
            p=p.getNext();
            if (p==null)
            {
                return -1;
            }

        }
        p=p3;
        while (p.getValue()!=x)
        {
            distanceStart+=1;
            p=p.getNext();
        }
        while (p!=null)
        {
            if (p.getValue()!=x)
            {
                distanceEnd+=1;
            }
            if (p.getValue()==x)
            {
                z = distanceEnd;
                distanceEnd=0;
            }
            p=p.getNext();
        }
        distanceSum = z+distanceStart;
        return distanceSum;
    }
    
    public static boolean ex_4(Node <Integer> p2)
    {
        Node<Integer> p=p2;
        while (p!=null)
        {
            int x=p.getValue();
            p.setValue(-1);
            if (isIn(p2,x)==true)
            {
                return false;
            }
            p=p.getNext();
        }
        return true;
    }

}
