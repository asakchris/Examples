package com.examples.ex;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci 
{
	public static int fibonacci(int pos)
	{
		if(pos == 1)
		{
			return 1;
		}
		if(pos == 2)
		{
			return 1;
		}
		return fibonacci(pos - 1) + fibonacci(pos - 2);
	}
	
	public static int fibonacciMemoize(int pos)
	{
		return fibonacciMemoize(pos, new Integer[pos + 1]);
	}
	
	public static int fibonacciMemoize(int pos, Integer[] values)
	{
		if(values[pos] != null)
		{
			return values[pos];
		}
		int result;
		if(pos == 1 || pos == 2)
		{
			result = 1;
		}
		else
		{
			result = fibonacciMemoize(pos - 1, values) + fibonacciMemoize(pos - 2, values);
		}
		values[pos] = result;
		return result;
	}
	
	public static int fibonacciBottomUp(int pos)
	{
		if(pos == 1 || pos == 2)
		{
			return 1;
		}
		
		int[] values = new int[pos + 1];
		values[1] = 1;
		values[2] = 1;
		for(int i = 3; i <= pos; i++)
		{
			values[i] = values[i - 1] + values[i - 2];
		}
		return values[pos];
	}
	
	public static int fibonacciLambda(int pos)
	{
		return Stream.iterate(new int[] {1, 1}, a -> new int[] {a[1], a[0] + a[1]})
					.limit(pos)
					.map(a -> a[0])
					.skip(pos - 1)
					.findFirst()
					.get();
	}
	
	public static void printFibonacci(int pos)
	{
		List<Integer> list = Stream.iterate(new int[] {1, 1}, a -> new int[] {a[1], a[0] + a[1]})
									.limit(pos)
									.map(a -> a[0])
									.collect(Collectors.toList());
		System.out.println(list);
	}
	
	private static void print(int[] array)
	{
		System.out.println(Arrays.stream(array).mapToObj(e -> String.valueOf(e)).collect(Collectors.joining(", ")));
	}
	
	public static void main(String[] args) 
	{
		printFibonacci(50);
		System.out.println(fibonacci(40));
		System.out.println(fibonacciLambda(40));
		System.out.println(fibonacciMemoize(40));
		System.out.println(fibonacciBottomUp(40));
		int a = 1134903170;
		int b = 1836311903;
		System.out.println(a + b);
	}
}
