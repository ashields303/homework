package com.example.session;

import java.util.Arrays;
import java.util.Iterator;

public class Payroll {
	
	// Declare arrays for itemsSold and wages, init itemsSold
	private int[] itemsSold = {48,50,37,62,38,70,55,37,64,60};
	private double[] wages; // null

	public double computeBonusThreshold() {
		// declare and init temporary ints for divisor and numerator
		double divisor = 0.0;
		double numerator = 0.0;
		
		// declare bonusCalc array to be the same length as items sold
		int[] bonusCalc = new int[itemsSold.length];
		
		// for loop to make copy of items sold, and store values in bonusCalc for sorting
		for (int i = 0; i < bonusCalc.length; i++) {
			bonusCalc[i] = itemsSold[i];
		}
		
		// sort the bonusCalc array from lowest to highest 
		Arrays.sort(bonusCalc);
		
		// for loop to count from 2nd element in bonusCalc array until the second to last element
		for (int i = 1; i < bonusCalc.length-1; i++) {
			// for all the elements in bonusCalc add them up in the numerator
			numerator+= bonusCalc[i];
			// count the number of elements and store them in the divisor
			divisor++;
		}
		// return the bonus threshold based on calculation
		return numerator/divisor;
	}

	// computeWages method, arguments for fixedWage and perItemWage for employees
	public void computeWages(double fixedWage, double perItemWage) {
		// initialize the wages array to be the same number of elements as itemsSold
		wages = new double[itemsSold.length]; 
		
		// Make call to the computeBonusThreshold function to get the result
		double bonus = computeBonusThreshold();
		// debug print
		System.out.println("Bonus: " + bonus);
		
		// loop through all the itemsSold
		for (int i = 0; i < itemsSold.length; i++) {
			
			// debug print
			System.out.println("Employee: " + i);
			
			// Calculate the employees base wage based on the calculation provided
			double wage = (fixedWage + perItemWage * itemsSold[i]);
			
			// debug print
			System.out.println("Employee: " + i + "'s Wage: " + wage);
			
			// if the employee has met the bonus threshold
			if(itemsSold[i] > bonus) {
				
				//calculate what their bonus is (10%) based on their initial wage
				double bonusAdd = wage * 0.1;

				// debug print
				System.out.println("Employee: " + i + "'s Bonus Percentage: " + bonusAdd);
				
				// add that bonus onto their initial wage
				wage += bonusAdd;				

				// debug print
				System.out.println("Employee: " + i + "'s Total Wages: " + wage);
			}
			// set the wage array value to be the employees final wage
			wages[i] = wage;

			// debug print
			System.out.println();
		}
		// debug print of wages array
		System.out.println("--- FINAL WAGES ---");
		for (int i = 0; i < wages.length; i++) {
			System.out.println(wages[i]);
		}
	}
		
	public static void main(String[] args) {
		// used in eclipse to create the Payroll class, and then call the compute wages method from that class
		Payroll p = new Payroll();
		p.computeWages(10.0, 1.5);
	}
}
