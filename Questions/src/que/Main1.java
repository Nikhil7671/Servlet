package que;

import java.io.*;
import java.util.*;
public class Main1 {
    public static void main(String args[]) {
        // your code here
      Scanner sc = new Scanner(System.in);
      System.out.println("n");
      int n =sc.nextInt();
      System.out.println("k");

      int k = sc.nextInt();
      int count=0;
      int arr[] = new int[n];
      
      for(int i=0;i<n;i++){
      arr[i]=sc.nextInt();
      }
      for(int i=0;i<=k;i++){
        if(arr[i]>=arr[k-1] && arr[i]>0 ){
          count++;
        }
      }
      
      System.out.println(count);
    }
}