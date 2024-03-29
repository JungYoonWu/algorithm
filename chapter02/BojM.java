package chapter02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BojM {

   public static void main(String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      Scanner sc = new Scanner(System.in);
      int count = 0;
      int n = Integer.parseInt(br.readLine());
      
      int[] Arr = new int[n];
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      for (int i = 0; i < n; i++) {
         Arr[i] = Integer.parseInt(st.nextToken());
      }
      for(int j = 0; j < n; j++) {
      for (int i = 2; i < Arr[j]; i++) {
         if (Arr[i] % i == 0) {
            count++;
         }
      } 
      System.out.print(count);
      }

   }

}