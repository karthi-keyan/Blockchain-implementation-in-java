import java.util.ArrayList;

//to create merkle tree and compute merkle root hash
public class merkle_tree {
	SHA256 encp =new SHA256();
    public String computetree(ArrayList<String> arr) {
   	 int i=arr.size();
   	 if(i==1){
   		 return arr.get(0);
   	 }
   	 ArrayList<String> tree =new ArrayList<String>();
   	 int k=0;
   	 do {
   		 if(i==1) {
   		 tree.add(encp.converttohash(arr.get(k)));
   		 break;}
   		 else
   		 tree.add(encp.converttohash(arr.get(k)+arr.get(k+1)));
   		 i-=2;
   		 k+=2;
   		     		 
   	 }while(i>0);
   	 
   	 return computetree(tree);
    
    }
}
