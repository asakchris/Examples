package com.examples.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue<E>
{
	private Queue<E> queue = new LinkedList<>();
	
	public boolean push(E element)
	{
		Queue<E> temp = new LinkedList<>();
		temp.offer(element); 
		E e;
		while((e = queue.poll()) != null)
		{
			temp.offer(e);
		}
		queue = temp;
		return true;
	}
	
	public E pop()
	{
		return queue.poll();
	}
	
	public E peek()
	{
		return queue.peek();
	}
	
	public int size()
	{
		return queue.size();
	}

	@Override
	public String toString() 
	{
		return queue.toString();
	}
	
	public static void main(String[] args) 
	{
		StackUsingQueue<Integer> stack = new StackUsingQueue<>();
		for(int i = 1; i <= 10; i++)
		{
			stack.push(i);
		}
		System.out.println(stack);
		System.out.println(stack.size());
		
		System.out.println(stack.peek());
		
		for(int i = 1; i <= 10; i++)
		{
			System.out.println(stack.pop());
		}
		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println(stack.pop());
	}
}
