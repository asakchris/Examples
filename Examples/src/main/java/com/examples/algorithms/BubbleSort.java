package com.examples.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class BubbleSort 
{
	public static int[] bubbleSort(int[] array)
	{
		for (int i = 0; i < array.length; i++) 
		{
			for (int j = 1; j < array.length - i; j++) 
			{
				System.out.println(i + " -> " + j);
				if(array[j - 1] > array[j])
				{
					int temp = array[j - 1];
					array[j - 1] = array[j];
					array[j] = temp;
				}
			}
		}
		
		return array;
	}
	
	public static void print(int[] array)
	{
		System.out.println(Arrays.stream(array).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining(", ")));
	}
	
	public static void main(String[] args) 
	{
		int[] input = {9, 4, 1, 5, 7, 8};
		int[] sorted = bubbleSort(input);
		print(sorted);
	}
}
