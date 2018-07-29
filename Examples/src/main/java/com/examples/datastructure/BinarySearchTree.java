package com.examples.datastructure;

public class BinarySearchTree<E extends Comparable<E>>
{
	private Node<E> head;
	
	public void add(E element)
	{
		head = addElement(element, head);
	}
	
	private Node<E> addElement(E element, Node<E> current)
	{
		if(current == null)
		{
			current = new Node<E>(element, null, null);
			return current;
		}
		
		if(element.compareTo(current.data) <= 0)
		{
			current.left = addElement(element, current.left);
			return current;
		}
		else
		{
			current.right = addElement(element, current.right);
			return current;
		}
	}
	
	public int size()
	{
		int size = 0;
		size(head, size);
		return size;
	}
	
	private void size(Node<E> current, int size)
	{
		if(current != null)
		{
			size++;
			size(current.left, size);
			size(current.right, size);
		}
	}
	
	public static void main(String[] args) 
	{
		BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
		/*bst.add(7);
		bst.add(6);
		bst.add(9);
		bst.add(2);
		bst.add(3);*/
		for (int i = 1; i <= 50000; i++) 
		{
			bst.add(i);
		}
		//System.out.println(bst);
		System.out.println(bst.size());
	}
	
	private static class Node<E>
	{
		E data;
		Node<E> left, right;
		
		public Node(E data, Node<E> left, Node<E> right) 
		{
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() 
		{
			StringBuilder builder = new StringBuilder();
			builder.append("Node [data=");
			builder.append(data);
			builder.append(", left=");
			builder.append(left);
			builder.append(", right=");
			builder.append(right);
			builder.append("]");
			return builder.toString();
		}
	}

	@Override
	public String toString() 
	{
		StringBuilder builder = new StringBuilder();
		builder.append("BinarySearchTree [head=");
		builder.append(head);
		builder.append("]");
		return builder.toString();
	}
}
