package que;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main4
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
    System.out.println("n");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int factorial=1;
    
    for(int i=n;i>=1;i--){
      factorial = factorial*i;
    }
    System.out.println(factorial);
	}
}