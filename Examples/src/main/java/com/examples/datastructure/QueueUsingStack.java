package com.examples.datastructure;

import java.util.Stack;

public class QueueUsingStack<E> 
{
	private Stack<E> stack = new Stack<>();
	
	public boolean offer(E element)
	{
		/*
		 * Queue - elements added at end & removed from top
		 * Stack - elements added at end & removed from end
		 * To create queue using stack, oldest element should be added at end of the stack for removal
		 * and latest element should be at the start of stack
		 * If you have added elements 1, 2 & 3 in order, then it will be stored in stack like [3, 2, 1]
		 */
		// Create temp stack
		Stack<E> temp = new Stack<>();
		/*
		 * Copy all elements from stack to queue
		 * If it already have elements 1 & added in order, then stack look like [2, 1]
		 * After moving elements from stack to temp, temp will look like [1, 2]
		 */
		E e;
		while(!stack.isEmpty() && (e = stack.pop()) != null)
		{
			temp.push(e);
		}
		/*
		 * Add element to temp
		 * If you add 3, then temp will look like [1, 2, 3] after this step
		 * Now temp will be in reverse order of final stack
		 */
		temp.push(element);
		/*
		 * Clear stack and copy all elements from temp to stack so stack will be in expected order
		 */
		stack.clear();
		while(!temp.isEmpty() && (e = temp.pop()) != null)
		{
			stack.push(e);
		}
		return true;
	}
	
	public E poll()
	{
		return stack.pop();
	}
	
	public E peek()
	{
		return stack.peek();
	}
	
	public int size()
	{
		return stack.size();
	}
	
	@Override
	public String toString() 
	{
		return stack.toString();
	}
	
	public static void main(String[] args) 
	{
		QueueUsingStack<Integer> queue = new QueueUsingStack<>();
		for(int i = 1; i <= 10; i++)
		{
			queue.offer(i);
		}
		System.out.println(queue);
		System.out.println(queue.size());
		
		System.out.println(queue.peek());
		
		for(int i = 1; i <= 10; i++)
		{
			System.out.println(queue.poll());
		}
		System.out.println(queue);
		System.out.println(queue.size());
		System.out.println(queue.poll());
	}
}
