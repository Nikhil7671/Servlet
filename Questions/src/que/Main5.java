package que;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main5
{
	public static void main (String[] args) throws java.lang.Exception
	{
		//your code here
		System.out.println("n");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    
    int []arr = new int[n];
    for(int i=0;i<n;i++){
    arr[i]= sc.nextInt();
    }
    int count=0;
    for(int i=0;i<n;i++){
    	count=0;
      for(int j=0;j<n;j++){
        if(arr[i]==arr[j]){
          count++;
        }
      }
    }
    if(count>=2){
      System.out.println("true");
    }
    else
      System.out.println("false");
	}
}