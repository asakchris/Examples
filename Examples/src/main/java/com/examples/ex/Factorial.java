package com.examples.ex;

import java.math.BigInteger;

public class Factorial 
{
	public static BigInteger factorial(int number)
	{
		if(number == 0)
		{
			return BigInteger.ONE;
		}
		
		return BigInteger.valueOf(number).multiply(factorial(number - 1));
	}
	
	public static BigInteger factorialTailRecursion(int number)
	{
		return factorialTailRecursion(number, BigInteger.ONE);
	}
	
	private static BigInteger factorialTailRecursion(int number, BigInteger result)
	{
		//System.out.println(number + " -> " + result);
		if(number == 0)
		{
			return result;
		}
		
		return factorialTailRecursion(number - 1, BigInteger.valueOf(number).multiply(result));
	}
	
	public static void main(String[] args) 
	{
		//System.out.println(factorial(50000));
		System.out.println(factorialTailRecursion(50000));
	}
}
