package com.examples.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort 
{
	public static int[] mergeSort(int[] input)
	{
		int length = input.length;
		
		if(length <= 1)
		{
			return input;
		}
		
		int mid = length / 2;
		
		int[] left = createArray(input, 0, mid - 1);
		int[] right = createArray(input, mid, length - 1);
		
		return merge(mergeSort(left), mergeSort(right));
	}
	
	private static int[] merge(int[] left, int[] right)
	{
		int leftLength = left.length;
		int rightLength = right.length;
		int[] merged = new int[leftLength + rightLength];
		int leftIndex = 0, rightIndex = 0, mergedIndex = 0;
		
		while(leftIndex < leftLength && rightIndex < rightLength)
		{
			if(left[leftIndex] <= right[rightIndex])
			{
				merged[mergedIndex++] = left[leftIndex++];
			}
			else
			{
				merged[mergedIndex++] = right[rightIndex++];
			}
		}
		
		while(leftIndex < leftLength)
		{
			merged[mergedIndex++] = left[leftIndex++];
		}
		
		while(rightIndex < rightLength)
		{
			merged[mergedIndex++] = right[rightIndex++];
		}
		
		return merged;
	}
	
	private static int[] createArray(int[] input, int start, int end)
	{
		int length = end - start + 1;
		int[] result = new int[length];
		
		int j = 0;
		for(int i = start; i <= end; i++)
		{
			result[j++] = input[i];
		}
		
		return result;
	}
	
	public static void print(int[] array)
	{
		System.out.println(Arrays.stream(array).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining(", ")));
	}
	
	public static void main(String[] args) 
	{
		int[] input = {3, 7, 2, 8, 6, 1, 5, 4};
		int[] sorted = mergeSort(input);
		print(sorted);
	}
}
