package spoj;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
public class PRIME1 {
	public static boolean isPrime(int n)
	{
		if(n==2) return true;
		if(n<2||n%2==0) return false;
	    for(int i = 3; i*i <= n; i+=2) if(n%i==0) return false;
	    return true;
	}
	public static void primesbetweenmandn(int m,int n) {
        for(int i=m;i<=n;i++)
        {
            if(isPrime(i))
            {
                System.out.println(i);
            }
        }
    }
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] mn=new int[t][2];
        for(int i=0;i<t;i++)
        {
        	String[] st = br.readLine().split(" ");
        	mn[i][0]=Integer.parseInt(st[0]);
        	mn[i][1]=Integer.parseInt(st[1]);
        }
        for(int i=0;i<t;i++)
        {
        	primesbetweenmandn(mn[i][0],mn[i][1]);
        	System.out.println();
        }
	}
}
