
/*
 * @author Srinath HemantKumar Shah
 * Course : CS634
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
import java.util.List;

//MinSupport must catch exceptions
public class AprioriAlgorithm {		
	/**
	 * @param minSupp
	 *The minimum support as provided by the user during the runtime, must catch exception for negative numbers 
	 */
	static double minSupp, minConf, mincount;
	static HashMap<String, Integer> temp;
	static List<String> transactions;

	/**
	 * Returns an ArrayList which contains the transactions.Divides the transactions
	 * based on new line character. Format of the returned transactions: [T0 apple
	 * banana]
	 * 
	 * @return An array list containing transactions
	 */
	private ArrayList<String> getTransactions(String path) {

		ArrayList<String> a = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String s;int i = 0;			
			while ((s = br.readLine()) != null) {
				a.add(s);
				i++;
			}
			
			
		} catch (IOException f) {
			f.printStackTrace();
		}

		return a;
	}

	/*
	 * Returns a hash-map of the form HashMap<String, Integer> with the items count.
	 * 
	 * @throws FileNotFoundException
	 */
	public HashMap<String, Integer> countItems(String path) {
		HashMap<String, Integer> countedItems = new HashMap<String, Integer>();
		try (Scanner sc = new Scanner(new File(path))) {			
			while (sc.hasNext()) {				
				String s = sc.next();
				
				if (countedItems.containsKey(s)) {
					Integer v = (countedItems.get(s));
					v++;
					countedItems.put(s, v);
				} else
					countedItems.put(s, 1);				
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}

		return countedItems;
	}
	
	protected static String[] generateNItemset(HashMap<String,Integer> map,int c) {
			int x = map.size();
			ArrayList<String> ax = new ArrayList<>();
			Set s = map.keySet();		
			String[] stemp = map.keySet().toArray(new String[map.size()]);
			for(int a=0;a<x-1;a++) {									
				for(int b =1;b<x;b=b+c-1) {
					if(ss.contains(stemp[a]) && ss.contains(stemp[a+1]) ) {
						ax.add(stemp[a]+" "+stemp[a+1]);
						}		
				}
			}			
		
		System.out.println(ax);
		return null;
	}

	public static HashMap<String, Integer> getFreqItems(HashMap<String, Integer> maps) {
		int c = (int) Math.ceil((minSupp * transactions.size()) / 100);
		
		HashMap<String, Integer> hmtemp = new HashMap<String, Integer>(maps);				
		Iterator it =  (Iterator) hmtemp.entrySet().iterator();
		
		while(it.hasNext()) {	
			Entry i = (Entry) it.next();			
				if((Integer)(i.getValue())<c) {
					it.remove();				
			}
		}	
		return hmtemp;		
	}
	
	public static void main(String args[]) {
    		
		minSupp = Double.parseDouble(args[1]);        	

		AprioriAlgorithm al = new AprioriAlgorithm();

		try (BufferedReader br = new BufferedReader(new FileReader(args[0]))){			
			String s="";
			List<String> stemp = new ArrayList<>();
			while ((s = br.readLine()) != null) {
				stemp.add(s);
			}
			transactions= stemp; 
		}
		
		catch(Exception e) {
			e.printStackTrace();			
		}
		
		try {

			// System.out.println(al.getTransactions(args[0]));
			temp = al.countItems(args[0]);
			HashMap<String, Integer> e = AprioriAlgorithm.getFreqItems(temp);
			AprioriAlgorithm.generateNItemset(e);
				System.out.println(e);
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		}
	}