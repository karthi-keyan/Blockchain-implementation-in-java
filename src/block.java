import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

//to determine block properties
public class block {
        //block informations
	    static SimpleDateFormat frmt=new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
	    public static long block_no=-1;
		private long block_number;
	    public int nonce;
		private String prev_hash;
		private String merkle_root;
	    private ArrayList<String> trans_list = new ArrayList<String>(10);
	    private String timestamp;
	    public String hash;
	    
	    SHA256 encp =new SHA256();
	    //constructor which maintains global block count
	    public block(){   
	    	this.block_no++;
	    } 
	    
	    //to get previous block hash
	    private String get_prev(long num) {
	    	if (num==0) {
	    		return null;
	    	    }
	        	else {
	        		main_class obj=new main_class();
	        		return obj.blockchain.get((int)num-1).hash;
	        	}
	    }
	    
	    //to set values to block
        public void setter() {
        	main_class obj1=new main_class();
        	merkle_tree obj2=new merkle_tree();
        	this.block_number=this.block_no;
        	this.merkle_root=obj2.computetree(this.trans_list);
        	this.timestamp=frmt.format(new Date());
        	this.prev_hash=get_prev(this.block_number);
        }
        
        public void print() {
        	if(block_no==0)
        	System.out.println("Genesis block created");
        	else
        	System.out.println("Block "+block_no+" created");
        	System.out.println("Block: "+this.block_number+"\nBlock hash: "+this.hash+"\nNonce: "+this.nonce+"\nPrevious hash: "+this.prev_hash+"\nMerkle root:"+this.merkle_root+"\nTransaction list: "+this.trans_list+"\nTime Stamp: "+this.timestamp+"\n\n");
        }
        
        //to compute entire block hash
        public String getBlkHash() {
        	this.hash=encp.converttohash(this.block_number+" "+this.nonce+" "+this.merkle_root+" "+this.prev_hash+" "+this.timestamp);
            return this.hash;
        }
        
        //to create random transactions
        public void create_transaction() {
        	String[] names= {"karthi","dhanush","tamil","rishi","mukesh","vk","joshua"};
        	for(int i=0;i<10;i++)
        	{
        		this.trans_list.add(i,names[(int)(Math.random()*6)]+"->"+names[(int)(Math.random()*6)]+" "+(int)(Math.random()*100)+"BTC");
        		
        	}
        }
        
}

