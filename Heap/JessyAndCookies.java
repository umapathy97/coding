import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {
public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int A[]=new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<A.length;i++){
            pq.add(A[i]);
        }
        int i=0,j=0;
        while(j<A.length && pq.peek()<k && pq.size()>1){
            
            i++;
       pq.add(pq.poll()+pq.poll()*2);
       j++;
        }
        if(pq.peek()<k)
            System.out.println("-1");
        else
            System.out.println(i);
    }
}
/*
time complexity:O(n*logn)
space complexity:O(n)
reference:https://www.hackerrank.com/challenges/jesse-and-cookies/problem
