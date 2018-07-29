package com.examples.algorithms;

import java.util.Arrays;
import java.util.stream.Collectors;

public class QuickSort 
{
	public static void sort(int[] array)
	{
		quickSort(array, 0, array.length - 1);
	}
	
	private static void quickSort(int[] array, int start, int end)
	{
		if(start >= end)
		{
			return;
		}
		
		int partitionIndex = partition(array, start, end);
		quickSort(array, start, partitionIndex - 1);
		quickSort(array, partitionIndex + 1, end);
	}
	
	private static int partition(int[] array, int start, int end)
	{
		int pivot = array[end];
		int partitionIndex = start;
		for(int i = start; i <= end - 1; i++)
		{
			if(array[i] <= pivot)
			{
				swap(array, i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(array, partitionIndex, end);
		return partitionIndex;
	}
	
	private static void swap(int[] array, int pos1, int pos2)
	{
		int temp = array[pos1];
		array[pos1] = array[pos2];
		array[pos2] = temp;
	}
	
	private static void print(int[] array)
	{
		System.out.println(Arrays.stream(array).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining(", ")));
	}
	
	public static void main(String[] args) 
	{
		int[] input = {3, 7, 2, 8, 6, 1, 5, 4};
		/*int partitionIndex = partition(input, 0, input.length - 1);
		System.out.println(partitionIndex);*/
		sort(input);
		print(input);
	}
}
