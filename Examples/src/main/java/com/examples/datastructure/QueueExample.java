package com.examples.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample 
{
	public static void main(String[] args) 
	{
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= 10; i++)
		{
			queue.offer(i);
		}
		System.out.println(queue);
		
		System.out.println(queue.poll());
		System.out.println(queue);
	}
}
