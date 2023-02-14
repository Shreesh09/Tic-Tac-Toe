import java.util.*;

public class J
{
	public static void main(String args[])
	{
		Scanner Sc = new Scanner(System.in);
		Ttt obj = new Ttt();
		int p = 0, x, y;
		while(obj.check() == 0)
		{
			obj.print();
			p = ((p + 1) == 3)?1:p+1;
				
			System.out.println("\n\nPlayer "+ p + " Enter your Move: ");
			System.out.print("\n(X, Y) = ");
			x = Sc.nextInt();
			y = Sc.nextInt();
			obj.move(x,y,p);
			System.out.println("\n");
		}
		obj.print();
		if(obj.check() == 1)
			System.out.println("\nPlayer " + p + "Won");
		else
			System.out.println("\n\nDraw");
	}
}

class Ttt
{
	int a[][];
	public Ttt()
	{
		a = new int[][]{new int [] {0, 0, 0}, new int [] {0, 0, 0}, new int [] {0, 0, 0}};
	}	
	
	void print()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				switch(a[i][j])
				{
					case 0: System.out.print("(" + i + "," + j + ")");
							break;
							
					case 1: System.out.print("  O  ");
							break;
					
					case 2: System.out.print("  X  ");
							break;
				}
				if(j != 2)
					System.out.print("|");
			}
			if(i != 2)
				System.out.println("\n__________________");
		}
	}
	
	int check()
	{
		if(a[0][0] == a[1][1] && a[1][1] == a[2][2] && a[0][0] != 0)
			return 1;
		if(a[0][2] == a[1][1] && a[1][1] == a[2][0] && a[2][0] != 0)
			return 1;
		for(int i = 0; i < 3; i++)
		{
			if(a[i][0] == a[i][1] && a[i][1] == a[i][2] && a[i][0] != 0)
				return 1;
			else if(a[0][i] == a[1][i] && a[1][i] == a[2][i] && a[0][i] != 0)
				return 1;
		}
		
		int c = 0;
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(a[i][j] == 0)
					c = 1;
			}
		}
		if(c == 1)
			return 0;
		else
			return 2;
	}
	
	void move(int x, int y, int p)
	{
		try
		{
			if(a[x][y] != 0)
			{
				System.out.println("Invalid move");
				return;
			}
			a[x][y] = p;
		}
		catch(Exception e)
		{
			System.out.println("\n\nInvalid move");;
		}
	}
} 
