package org.ulysses.ithaca.leetcode;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	int[] res=new int[2];
    	for(int i=0;i<numbers.length;i++){
    		if(numbers[i]<target){
    			for(int t=i+1;t<numbers.length;t++){
    				if(numbers[t]+numbers[i]==target){
    					res[0]=i+1;
    					res[1]=t+1;
    					break;
    				}
    					
    			}
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args){
    	
    	
    }
}
