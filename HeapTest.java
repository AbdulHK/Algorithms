import java.util.*;

class Heap
{
    private int[] a;
    private int N;
	private int[] hPos;
	//int v;
	int j = 0;

    private static int hmax = 100;
    
    public Heap()
    {
        this(hmax);
    }

    public Heap(int _hmax)
    {
        a = new int[_hmax + 1];
        N = 0;
		hPos = new int[a.length];
    }


    public void insert(int x)
    {
        a[++N] = x;
        siftUp(N);
    }
	/*public int remove()
	{
		v = a[1];
		a[1] = a[N--];
		siftDown(1);
		return v;
	}*/
  

    public void siftUp(int k)
    {
	  int v = a[k];
		a[0] = Integer.MAX_VALUE;
		while( v > a[k /2])
		{
			a[k] = a[k/2];
			hPos[a[k]] = k;
			k = k/2;
		}
		a[k] = v;
		hPos[v] = k;
		
    }
    public void siftDown(int k)
	{
		N = a[k];
		while(k<= N/2)
		{
			j = 2 * k;
			if(j < N || a[j] < a[j+1] )
			{
				j++;
			}
			if(N >= a[j])
			{
				a[k] = a[j];
				k = j;
			}
		}
		a[k] = N;
	}

    
    public void display() 
    {
        System.out.print(  a[1]);

        for(int i = 1; i <= N/2; i = i * 2) {
            for(int j = 2*i; j < 4*i && j <= N; ++j)
            System.out.print( " "+a[j]+" ");
        }
    }

}

class HeapTest
{
    public static void main(String[] args)
    {
        Heap h = new Heap();

        Random r = new Random();

        int i, x;
        for (i = 0; i < 10; ++i)
        {
            x = (int)(r.nextFloat() * 99);
			//x = i;
            System.out.println("\nInserting  " +  x);
            h.insert(x);
            h.display();
        }

        //x = h.remove();
        //System.out.println("\nRemoving " + x);
        //h.display();

       
    }
}