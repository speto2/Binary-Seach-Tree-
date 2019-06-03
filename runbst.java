
public class runbst {
	public static void main(String args[]) {
    	BST b = new BST();
    	b.insert("india");
    	b.insert("ryan");
    	b.insert("pranav");
    	b.insert("charter");
    	b.insert("josh");
    	b.insert("kramer");
    	b.insert("minecraft");
    	b.insert("snyder");
    	b.insert("data");
    	b.insert("pakistan");
    	b.insert("elon");
    	b.insert("fort");
    	b.insert("play");
    	b.insert("epic");
    	b.insert("omm");
    	
//    	b.insert(1);
//    	b.insert(10);
//    	b.insert(1234);
//    	b.insert(8);
    	
    	b.inOrderPrint();
    	
    	b.balancedBSTcall(b.treeb);
    	
    	b.structurePrint(b.balancedBSTcall(b.treeb));
    }
}
