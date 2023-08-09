package com.comprehensive.practice.datastructure.bst.ps2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {

	private Node<T> root;

	public Node<T> getRoot() {
		return root;
	}

	public void printInOrderTraversal(Node<T> node) {
		if (node.leftChild != null)
			printInOrderTraversal(node.leftChild);
		System.out.print(node);
		if (node.rightChild != null)
			printInOrderTraversal(node.rightChild);
	}

	public T kLargestElement(int k) {
		if(root==null) return null;
		int count=0;
		Node<T> tmp =root;
		while (tmp!=null){
			if(tmp.rightChild==null){
				count++;
				if(count==k) return tmp.data;
				tmp=tmp.leftChild;
			}else {
				Node<T> ptr = tmp.rightChild;
				while (ptr.leftChild!=null && ptr.leftChild!=tmp)
					ptr=ptr.leftChild;
				if(ptr.leftChild==null){
					ptr.leftChild=tmp;
					tmp=tmp.rightChild;
				}else{
					ptr.leftChild=null;
					count++;
					if(count==k) return tmp.data;
					tmp=tmp.leftChild;
				}
			}
		}
		return tmp.data;
	}

	public Node<T> kthLargestElement(Node<T> node, int k) {
		if(node==null) return null;
		Node<T> kthLargestNode= kthLargestElement(node.rightChild ,k);
		if(kthLargestNode!=null) return kthLargestNode;
		count++;
		if(count==k) return node;
		return kthLargestElement(node.leftChild ,k);
	}

	public void printLeafNode(Node<T> node) {
		if(node.leftChild==null && node.rightChild==null)
			System.out.print(node);
		if(node.leftChild!=null)  printLeafNode(node.leftChild);
		if(node.rightChild!=null) printLeafNode(node.rightChild);
	}

	public void printLeafNodeIterator(Node<T> node) {
		if(node==null) return;
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()){
		Node<T> newNode= queue.remove();
		if(newNode.leftChild==null && newNode.rightChild==null)
			System.out.print(newNode);
		if(newNode.leftChild!=null) queue.add(newNode.leftChild);
		if(newNode.rightChild!=null) queue.add(newNode.rightChild);
		}
	}

	public void printLeafNodeIteratorUsingStack(Node<T> node) {
		if(node==null) return;
		Stack<Node<T>> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()){
			Node<T> ptr=stack.pop();
			if(ptr.leftChild==null && ptr.rightChild==null)
				System.out.print(ptr);
			if(ptr.leftChild!=null) stack.push(ptr.leftChild);
			if(ptr.rightChild!=null) stack.push(ptr.rightChild);
		}
	}

	public int countElement(Node<T> node) {
		if(node==null) return 0;
		return 1 + countElement( node.leftChild) +countElement( node.rightChild);
	}

	public int countElementIterator(Node<T> node) {
		if(node==null) return  0;
		count =0;
		Stack<Node<T>> stack = new Stack<>();
		stack.push(node);
		while (!stack.isEmpty()){
			Node<T> ptr= stack.pop();
			count++;
			if(ptr.leftChild!=null) stack.push(ptr.leftChild);
			if(ptr.rightChild!=null) stack.push(ptr.rightChild);
		}
		return count;
	}

	public int heightOfTree(Node<T> node) {
		if(node==null) return 0;
		return 1 +Math.max(heightOfTree(node.leftChild) ,heightOfTree(node.rightChild));
	}

	public void levelOrderTraversal(Node<T> node) {
		if(node==null) return;
		Queue<Node<T>> queue =new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()){
			Node<T> ptr = queue.remove();
			System.out.print(ptr);
			if(ptr.leftChild!=null) queue.add(ptr.leftChild);
			if(ptr.rightChild!=null)queue.add(ptr.rightChild);
		}
	}

	public void postOrderTraverse(Node<T> node) {
		if (node.leftChild != null) postOrderTraverse(node.leftChild);
		if (node.rightChild != null) postOrderTraverse(node.rightChild);
		System.out.print(node);
	}

	//eft right root


	private static final class Node<T extends Comparable<T>> {
		T data;
		Node<T> leftChild, rightChild, parentNode;

		Node(T data, Node<T> parentNode) {
			this.data = data;
			this.parentNode = parentNode;
		}

		@Override
		public String toString() {
			return " " + data;
		}

	}

	public void addElement(T data) {
		if (root == null) {
			root = new Node<>(data, null);
		} else {
			addElement(data, root);
		}
	}

	private void addElement(T data, Node<T> node) {
		if (node.data.compareTo(data) > 0) {
			if (node.leftChild == null) {
				node.leftChild = new Node(data, node);
			} else {
				addElement(data, node.leftChild);
			}
		} else {
			if (node.rightChild == null) {
				node.rightChild = new Node<>(data, node);
			} else {
				addElement(data, node.rightChild);
			}
		}
	}

	public T kSmallestElement(int k) {
		if (root == null)
			return null;
		Node<T> tmp = root;
		int count = 0;
		while (tmp != null) {
			if (tmp.leftChild == null) {
				count++;
				if (count == k)
					return tmp.data;
				tmp = tmp.rightChild;
			} else {
				Node<T> ptr = tmp.leftChild;
				while (ptr.rightChild != null && ptr.rightChild != tmp)
					ptr = ptr.rightChild;
				if (ptr.rightChild == null) {
					ptr.rightChild = tmp;
					tmp = tmp.leftChild;
				} else {
					ptr.rightChild = null;
					count++;
					if (count == k)
						return tmp.data;
					tmp = tmp.rightChild;
				}
			}
		}
		return tmp.data;
	}

	int count=0;
	
	public Node<T> kSmallestElementNode(int k ){
		return kSmallestElementNode(root ,k);
	}

	private Node<T> kSmallestElementNode(Node<T> node, int k) {
		if(node==null) return null;
		Node<T> kthSmallest= kSmallestElementNode( node.leftChild, k);
		if(kthSmallest!=null) return kthSmallest;
		count++;
		if(count==k) return node;
		return kSmallestElementNode(node.rightChild,  k);
		
	}



	public int heightOfTreeIterator(Node<T> node){
		int height=0;
		if(node==null) return 0;
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(node);
		while(true){
			int nodeCount = queue.size();
			if (nodeCount == 0)
				return height;
			height++;
			while (nodeCount > 0) {
				Node newnode = queue.peek();
				queue.remove();
				if (newnode.leftChild != null)
					queue.add(newnode.leftChild);
				if (newnode.rightChild != null)
					queue.add(newnode.rightChild);
				nodeCount--;
			}
			queue.remove();
		}
	}


	public void delete(T data) {
		if (root == null) return;
		delete(data, root);
	}

	public void delete(T deleteData, Node<T> node) {
		if (node == null) return;
		else if (node.data.compareTo(deleteData) > 0) {
			delete(deleteData, node.leftChild);
		} else if (node.data.compareTo(deleteData) < 0) {
			delete(deleteData, node.rightChild);
		} else {
			System.out.println("data is present in the BST");
			//Node<T> parent= node.parentNode;
			if (node.leftChild == null && node.rightChild == null) {
				System.out.println("case 1 when left child and right Child both are null");
				Node<T> parent = node.parentNode;
				if (parent != null && parent.leftChild == node) {
					parent.leftChild = null;
				} else if (parent != null && parent.rightChild == node) {
					parent.rightChild = null;
				} else if (parent == null) {
					root = null;
				} else {
				}
				//Node must be gc
				node = null;
			} else if (node.leftChild != null && node.rightChild == null) {
				System.out.println("case 2 when left child not null and right Child both are null");
				Node<T> parent = node.parentNode;
				if (parent != null && parent.leftChild == node) {
					parent.leftChild = node.leftChild;
				} else if (parent != null && parent.rightChild == node) {
					parent.rightChild = node.leftChild;
				} else if (parent == null) {
					root =parent.leftChild;
				} else {
				}
				node.leftChild.parentNode=parent;
				//node must be GC
				node=null;
			} else if (node.leftChild == null && node.rightChild != null) {
				System.out.println("case 2 when left child  null and right Child both are not null");
				Node<T> parent = node.parentNode;
				if (parent != null && parent.leftChild == node) {
					parent.leftChild = node.rightChild;
				} else if (parent != null && parent.rightChild == node) {
					parent.rightChild = node.rightChild;
				} else if (parent == null) {
					root =parent.rightChild;
				} else {
				}
				node.rightChild.parentNode=parent;
				//node must be GC
				node=null;

			} else {
				System.out.println("case 4 when left child and right Child both are not null");
				Node<T> predecessor = getPredecessor(node.rightChild);
				T temp = predecessor.data;
				predecessor.data = node.data;
				node.data = temp;
				delete(deleteData, predecessor);

			}
		}
	}
	private Node<T> getPredecessor(Node<T> node) {
		if(node.leftChild!=null) return getPredecessor(node.leftChild);
		return node;
	}

	public void inorderTraverseWithoutRecursive(Node<T> node) {
		if (node == null) return;
		Stack<Node<T>> stack = new Stack<>();
		while (!stack.isEmpty() || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.leftChild;
			} else {
				Node<T> ptr = stack.pop();
				System.out.print( node);
				node = ptr.rightChild;
			}
		}
	}
   ////left-right-root
	public void postOrderTraversalnotRequesive(Node<T> node) {
		if (node==null) return;
		Stack<Node<T>> stack = new Stack<>();
		Stack<T> out = new Stack();
		stack.push(node);
		while(!stack.isEmpty()){
			Node<T> ptr= stack.pop();
			out.push(ptr.data);
			if(ptr.leftChild!=null) stack.push(ptr.leftChild);
			if(ptr.rightChild!=null) stack.push(ptr.rightChild);
		}
		while (!out.empty()) {
			System.out.print(out.pop() + " ");
		}
	}


}

class Testing {
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.addElement(25);
		bst.addElement(20);
		bst.addElement(15);
		bst.addElement(10);
		bst.addElement(5);
		bst.addElement(30);
		bst.addElement(35);
		bst.addElement(40);
		bst.addElement(24);
		bst.addElement(22);
		bst.addElement(23);
		bst.addElement(33);
		bst.addElement(31);
		bst.addElement(32);
		bst.addElement(43);
		bst.addElement(38);
		bst.addElement(34);
		bst.addElement(45);
		bst.addElement(8);
		bst.addElement(29);
		bst.addElement(2);
		bst.addElement(12);
		bst.addElement(17);

		bst.printInOrderTraversal(bst.getRoot());
		System.out.println("\n*************");
		//System.out.println(bst.kSmallestElement(4));
		///System.out.println("\n"+bst.kSmallestElementNode(4));
		//System.out.println(bst.kLargestElement(10));
		//System.out.println("\n "+bst.kthLargestElement(bst.getRoot(),10));

		// bst.printInorderTraversal(bst.getRoot());
		/// System.out.println();
	//	bst.printLeafNode(bst.getRoot());
	///	System.out.println();
	///	bst.printLeafNodeIterator(bst.getRoot());
	///	System.out.println();
	//	bst.printLeafNodeIteratorUsingStack(bst.getRoot());
		// System.out.println();
		// bst.printLeaf(bst.getRoot());
		// System.out.println("\n"+ bst.countElement(bst.getRoot()));
		///System.out.println("\n countElementIterator ::"+ bst.countElementIterator(bst.getRoot()));
		// System.out.println("\n  heightOfTree :: "+bst.heightOfTree(bst.getRoot()));
		///System.out.println("\n  heightOfTree using iterator :: "+bst.heightOfTreeIterator(bst.getRoot()));
		//// System.out.println(bst.findMin(bst.getRoot()));
		/// System.out.println(bst.findMax(bst.getRoot()));
		//System.out.println();
		/// bst.levelOrderTraversal(bst.getRoot());
		// System.out.println();
		// bst.printLeafNode(bst.getRoot());
		// bst.printLeafNode12(bst.getRoot());
		// System.out.println(bst.kSmallestElement(4));
		// System.out.println(bst.kLargestElement(4));
		System.out.println("left-right-root");
		bst.postOrderTraversalnotRequesive(bst.getRoot());
		System.out.println("\n 0000000");
		bst.postOrderTraverse(bst.getRoot());

	}
}
