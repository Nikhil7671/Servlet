package que;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) {
        // your code here
    	System.out.println("ENter size");
      Scanner sc= new Scanner(System.in);
      int size = sc.nextInt();
  	System.out.println("ENter k");

      int k= sc.nextInt();
      int count=0;
    	System.out.println("ENter elements");

      int arr [] = new int[size];
      
      for(int i=0;i<size;i++){
        arr[i]= sc.nextInt();
      }
      
      for(int i=0;i<size;i++){
        for(int j=i+1;j<size;j++){
          if((arr[i]-arr[j])==k  || arr[j]-arr[i]==k){
            count++;
          }
        }
      }
      System.out.println(count);
      
    }
}