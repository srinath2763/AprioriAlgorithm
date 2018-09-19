/*
 * @author Srinath
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;
import java.util.Scanner;

public class AprioriAlgorithm {
	/**
	 * @param minSupp is the minimum support as provided by the user during the runtime
	 * 
	 */
	int minSupp, minConf, mincount;

	
	/**
	 * Returns an ArrayList which contains the transactions.Divides the transactions based on new line 
	 * character.
	 * @return An array list containing transactions 
	 */	
	private ArrayList<String> getTransactions(String path) {

		ArrayList<String> a = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String s;
			while ((s = br.readLine()) != null) {
				a.add(s);
			}

		} catch (IOException f) {
			f.printStackTrace();
		}

		return a;
	}

	
	
	
	
	public static void main(String args[]) {
		AprioriAlgorithm al = new AprioriAlgorithm();
		try {
			// System.out.println(args[0]);
			al.getTransactions(args[0]);
		}

		catch (Exception e) {
			e.printStackTrace();

		}
	}

}
