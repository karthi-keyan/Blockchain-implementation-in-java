import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.File;

public class main_class{
	
	static ArrayList<block> blockchain = new ArrayList<block>();
	//to convert 64bit hash to value for Proof of work
	public static double get_int(String hexstr) {
		double value=0;
		String digits="0123456789ABCDEF";
		for(int i=0;i<hexstr.length();i++) {
			char c=hexstr.charAt(i);
			int d=digits.indexOf(c);
			value= value*16 + d;
		}
		return Math.abs(value);
	}
	
	//main class which creates block and add it to blockchain
	public static void main( String args[] ){
	   
	   main_class obj=new main_class();
	   SHA256 encpt =new SHA256();
	   //Proof of work concencus
	   while(true) {
		   System.out.println("Transaction created.....\nMining started.....\n");
		   block blk=new block();
		   blk.create_transaction();
		   blk.setter();
		   int difficulty=22;//to determine difficulty to add block
		   long max_nonce=(long)Math.pow(2,32);
		   double target_hash=Math.pow(2,256-difficulty);   
		   for(int i=0;i<max_nonce;i++){   
			   if(get_int(blk.getBlkHash())<=target_hash) {	   
			   blk.print();
			   blockchain.add(blk);//block is added to the blockchain
			   break;
			   }
			   else {
				   blk.nonce=blk.nonce+1;
			   }
		   }
		   
		         
	    }
	   
	   }
}

