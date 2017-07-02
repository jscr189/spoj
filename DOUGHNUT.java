package spoj;
import java.util.*;
import java.io.*;
import java.lang.*;

/*
 * http://www.spoj.com/problems/DOUGHNUT/
 */

public class DOUGHNUT {
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String[] s=new String[t];
        for(int i=0;i<t;i++)
        {
        	String[] st = br.readLine().split(" ");
        	if((Integer.parseInt(st[0])*Integer.parseInt(st[2]))<=Integer.parseInt(st[1]))
        		s[i]="yes";
        	else
        		s[i]="no";
        }
        for(int i=0;i<t;i++)
        	System.out.println(s[i]);
	}
}