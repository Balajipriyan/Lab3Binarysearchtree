package com.greatlearning.lab3;

class Node {

	int data;
	Node left, right;

	Node(int val)
	{
		data = val;
		left = right = null;
	}
}
public class Binarysearchsum {
	Node root;
	Binarysearchsum()
	{ 
		root = null;
	}
	void insert(int key)
	{
		root = insertbinvalue(root, key); 
	}
	Node insertbinvalue(Node root, int data)
	{
		if (root == null) 
		{
			root = new Node(data);
			return root;
		}
		if (data < root.data)
		{
			root.left = insertbinvalue(root.left, data);
		}
		else if (data > root.data)
		{
			root.right = insertbinvalue(root.right, data);
		}

		return root;
	}

	boolean isadditionPresent(Node root, Node temp, int targetvalue)
	{
		if (temp == null)
			return false;

		return search(root, temp, targetvalue - temp.data)
				|| isadditionPresent(root, temp.left, targetvalue)
				|| isadditionPresent(root, temp.right, targetvalue);
	}

	boolean search(Node root, Node temp, int e)
	{

		if (root == null)
			return false;

		Node c = root;
		boolean flag = false;
		while (c != null && flag != true) {
			if (c.data == e && temp != c) {
				flag = true;
				System.out.println("Pair is: (" + temp.data+","
						+ c.data+")");
				return true;
			}
			else if (e < c.data)
				c = c.left;
			else
				c = c.right;
		}

		return false;
	}

	public static void main(String[] args)
	{
		Binarysearchsum bintree = new Binarysearchsum();
		bintree.insert(40);
		bintree.insert(20);
		bintree.insert(60);
		bintree.insert(10);
		bintree.insert(30);
		bintree.insert(50);
		bintree.insert(70);

		boolean test
		= bintree.isadditionPresent(bintree.root, bintree.root, 130);
		if (!test)
			System.out.println("print nodes are not found.");
	}
}

