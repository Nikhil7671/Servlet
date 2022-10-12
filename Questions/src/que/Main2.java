package que;

import java.io.*;
import java.util.*;
public class Main2 {
    public static void main(String args[]) {
        // your code here
    	System.out.println("n");
      Scanner sc = new Scanner(System.in);
      int n =sc.nextInt();
      System.out.println("k");
      int k = sc.nextInt();
      int arr[] = new int[n];
      for(int i=0;i<n;i++){
          arr[i]=sc.nextInt();
        }
      int count=0;
      for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
          if((arr[i]+arr[j])%k==0 ){
            count++;
          }
        }
      }
      System.out.println(count);
    }
}