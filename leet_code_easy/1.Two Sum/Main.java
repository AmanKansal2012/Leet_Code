package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int target;
        int[] indices;
        Scanner s=new Scanner(System.in);
        System.out.println("Please enter no. of elements you want in the array.");
        int n=s.nextInt();
        int nums[]=new int[n];
        System.out.println("Enter the elements");
        for(int i=0;i<n;i++)
        {
            nums[i]=s.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            System.out.println(nums[i]);
        }
        System.out.println("Enter the target");
       target=s.nextInt();
         indices=solution1(nums,target);
        System.out.println("For method 1 :"+indices[0]+","+indices[1]);
       indices=solution2(nums,target);
        System.out.println("For method 2 :"+indices[0]+","+indices[1]);


  }
    static int[] solution1(int[] nums, int target) {

            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target - nums[i]) {
                        return new int[] { i, j };
                    }
                }
            }
            throw new IllegalArgumentException("No two sum solution");
        }



  static int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
