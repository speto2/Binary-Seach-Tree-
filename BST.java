import java.util.*;

/*Binary Search Tree
 * Author: Tyler Ramey
 * Class that creates a binary search tree*/
public class BST <T> {
    BSTNode root;
    public static int treeSize;
    List<T> treeb = new ArrayList<T>();
    public static int arraySize = 0;
    public static int printHeight = 1;
    public static int numofnodes;
    
    /*inserts a value into the list and automatically organizes it in order*/
    public void insert(T insertMe) {
        BSTNode insertNode = new BSTNode(insertMe);
        if (root == null) {
            root = insertNode;
            return;
        }
        
        BSTNode current = root;
        boolean run = true;
        while(run) {
            if (insertNode.compareTo(current) > 0){
                // if right node is empty, then insert
                if (current.getRight() == null) {
                	current.setRight(insertNode);
                    run = false;
                } else {
                	current = current.getRight();
                }
            } else {
                if (current.getLeft() == null) {
                	current.setLeft(insertNode);
                    run = false;
                } else {
                	current = current.getLeft();
                }
            }
        }
    }
    
    /*check to see if a number or value exists within the tree.*/
    public boolean exists(T checkMe) {
        BSTNode checkNode = new BSTNode(checkMe);
        if (root == null) {
            return false;
        }
        
        BSTNode curr = root;
        
        boolean run2 = true;
        while(run2) {
            if (checkNode.compareTo(curr) == 0) {
                return true;
            }else if (checkNode.compareTo(curr) > 0){
                // if right node is empty, then false
                if (curr.getRight() == null) {
                    return false;
                } else {
                    curr = curr.getRight();
                }
            } else {
                if (curr.getLeft() == null) {
                    return false;
                } else {
                    curr = curr.getLeft();
                }
            }
        }
        return false;
    }
    
    /*Print the tree in order, this is a recursive method.*/
    public void inOrderPrint() {
        if (root == null) {
            System.out.println("Tree is empty!");
        } else {
            inOrderPrint(root);
        }
    }
    
    /*Print the tree in order*/
    public void inOrderPrint(BSTNode node) {
        if (node == null) {
        	return; 
        }
        inOrderPrint(node.getLeft());
        //System.out.println(node.get());
        treeb.add(node.get());
        arraySize++;
        inOrderPrint(node.getRight());
    }
    
    /*calls the method where the tree is actually balanced.*/
    public BSTNode balancedBSTcall(List<Integer> treeList) {
	    return balanceBST(treeList, 0, treeList.size()-1);
	}
	
    /*this is where the tree is balanced out evenly.*/
	public BSTNode balanceBST(List<Integer> treeList, int start, int end) {
		int middle = (start + end)/2;
		BSTNode root2 = new BSTNode((T) treeList.get(middle));
		
	    if (start > end) {
	    	return null;
	    }
	    
	    if(treeList.size() != 1) {    
		    root2.left = balanceBST(treeList, start, middle-1);
		    root2.right = balanceBST(treeList, middle+1, end);
	    }
	    
	    return root2;
	}
    
    /*UNUSED (but its still here)*/
    public int bstHeight(BSTNode root) {
    	if(root == null) {
    		return 0;
    	}else {
    		int lh = bstHeight(root.left);
    		int rh = bstHeight(root.right);
    		
    		if(lh > rh) {
    			return lh+1;
    		}else {
    			return rh+1;
    		}
    	}
    }
    
    /*Method to print the tree structure, level by level*/
    boolean run = true;
    public void structurePrint(BSTNode root) { 
        if(root == null) {
        	return; 
        }
        Queue<BSTNode> theQueue = new LinkedList<BSTNode>();
        theQueue.add(root); 
         
        while(run) { 
        	numofnodes = theQueue.size(); 
            if(numofnodes == 0) {
            	return; 
            }

            while(numofnodes > 0) { 
            	BSTNode root3 = theQueue.peek(); 
                System.out.print(root3.get() + " "); 
                theQueue.remove(); 
                if(root3.left != null) {
                	theQueue.add(root3.left); 
                }
                if(root3.right != null) 
                	theQueue.add(root3.right); 
                numofnodes--; 
            } 
            System.out.println(); 
        } 
    } 
 		
    public class BSTNode implements Comparable {
        T value;
        BSTNode left;
        BSTNode right;
        
        public BSTNode(T val) {
            value = val;
        }

        public T get() {
            return value;
        }

        public void set(T val) {
            value = val;
        }

        public BSTNode getLeft() {
            return left;
        }

        public void setLeft(BSTNode n) {
            left = n;
        }

        public BSTNode getRight() {
            return right;
        }

        public void setRight(BSTNode n) {
            right = n;
        }
        
        public int compareTo(Object o) {
            BSTNode n = (BSTNode) o;
            return ((Comparable)value).compareTo((Comparable) n.get());
        }
    }
}