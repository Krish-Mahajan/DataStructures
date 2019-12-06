package datastructure.linkedlist;

public class AddTwoNumber {
	
	
	
	public static class ListNode {
	      int val;
	     ListNode next;
	      ListNode(int x) { val = x; }
	 }
	 
	   
	  private static class NewNode{
	        int carryOn;
	        ListNode node;
	        
	        public NewNode(int carryOn,ListNode node) {
	            this.carryOn = carryOn;
	            this.node = node;
	        }
	        
	    }
	    
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        
	        ListNode sumNode = new ListNode(-10);
	        ListNode firstNode = sumNode;    
	        
	        int carryOn = 0;
	        while(l1 !=null || l2!=null){
	            NewNode nn = addNode(l1,l2,carryOn,sumNode);
	            
	            if(l1!=null) l1 = l1.next;
	            if(l2!=null) l2 = l2.next;
	            carryOn = nn.carryOn;
	            sumNode = nn.node;
	            if(l1 ==null && l2==null & carryOn!=0) {
	                sumNode.next = new ListNode(carryOn);
	                break;}
	        } 
	        
	   
	        return firstNode.next;
	        
	    }
	    
	    private NewNode addNode(ListNode l1,ListNode l2,int carryOn,ListNode node){
	            int sum=0;
	            if(l1!=null && l2!=null){
	                sum = l1.val + l2.val + carryOn;
	                carryOn = 0;}
	            if(l1==null && l2!=null) {
	            	sum = l2.val + carryOn;
	            	carryOn = 0;
	            }
	            if(l2==null && l1!=null) {
	            	sum = l1.val + carryOn;
	            	carryOn = 0;
	            }
	            if(sum >= 10) carryOn = sum/10;
	            node.next = new ListNode(sum%10);
	            node = node.next; 
	            return new NewNode(carryOn,node); 
	    }
    
    public static void main(String[] args) {
    	AddTwoNumber ad = new AddTwoNumber();
    	ListNode l1 = new AddTwoNumber.ListNode(9);
    	l1.next = new AddTwoNumber.ListNode(8);
    	ListNode l2 = new AddTwoNumber.ListNode(1);
    	ad.addTwoNumbers(l1,l2);
    }
}
