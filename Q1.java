// Program for credit and risk calculator


import java.util.*;
import java.text.*;
import java.math.RoundingMode;

class Q1{

	//Find minimum
	public static double min(double v1, double v2){
		if(v1 < v2)
			return v1;
		else
			return v2;
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long n = 0;
		double sv = 10001.0, csv = 2001.0, r = 0.0, cr = 11.0;

		boolean isError = false;
		String errorMessage = "";


		//Input and validation :-
		System.out.println(" 1. No of shares\n 2. Share values\n 3. Change in share values"
			+"\n 4. Current rating\n 5. Change in rating\n");

		// 1. No of shares
		try{
			n = sc.nextInt();
			if(n < 20000 || n > 10000000){
				errorMessage = errorMessage + "No of shares : Invalid input\n";
				isError = true;
			}
		}
		catch(Exception e){
			errorMessage = errorMessage + "\nNo of shares : Invalid input\n";
		}

		//2. Share values
		try{
			sv = sc.nextDouble();
			if(sv < 20.00 || sv > 10000.00){
				errorMessage = errorMessage + "Share values : Invalid input\n";
				isError = true;		
			}
		}
		catch(Exception e){
			errorMessage = errorMessage + "Share values : Invalid input (Enter float value)\n";
		}

		// 3. Change in share values
		try{
			csv = sc.nextDouble();
			if(csv < -2000.00 || csv > 2000.00){
				errorMessage = errorMessage + "Change in share values : Invalid input\n";
				isError = true;	
			}
		}
		catch(Exception e){
			errorMessage = errorMessage + "Change in share values : Invalid input (Enter float value)\n";
		}

		// 4. Current rating
		try{
			r = sc.nextDouble();
			if(r < 0.01 || r > 99.99){
				errorMessage = errorMessage + "Current rating : Invalid input\n";
				isError = true;	
			}
		}
		catch(Exception e){
			errorMessage = errorMessage + "Current rating : Invalid input (Enter float value)\n";
		} 

		//5. Change in rating
		try{
			cr = sc.nextDouble();
			if(cr < -10.00 || cr > 10.00){
				errorMessage = errorMessage + "Change in rating : Invalid input\n";
				isError = true;
			}else if(csv < 0){
				if(cr >= 0){
					errorMessage = errorMessage + "Change in ratingInvalid input. CR should be negative in case of CSV";
					isError = true;
				}
			}		
		}
		catch(Exception e){
			errorMessage = errorMessage + "Change in rating : Invalid input (Enter float value)\n";
		}
			

		//In case of Invalid input, Program will terminate.
		if(isError){
			System.out.println("\n"+errorMessage);
			return;
		}


		//Calculation
		DecimalFormat df = new DecimalFormat("#.00");
		df.setRoundingMode(RoundingMode.CEILING);

		Double psv, cv, pr, ce, ca;

		psv = sv - csv;
		cv = (double) n * min(sv, psv);
		pr = r - cr;
		ce = cv * 0.5;
		ca = ce * (min(pr, r)/100);

		//Print output
		System.out.println("\nPrevious share value : "+ df.format(psv)+"\nPrevious rating : "+df.format(pr)+
			"\nCompany value : "+df.format(cv)+"\nMaximum credit : "+ce+"\nCredit alloted : "+ca);

	}

}