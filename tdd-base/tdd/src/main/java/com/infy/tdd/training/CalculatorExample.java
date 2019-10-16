package com.infy.tdd.training;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculatorExample {
	

	public int additionOfNumbers(int firstNumber, int secondNumber){
		return firstNumber+secondNumber;
	}

	public int multiplicationOfNumbers(int firstNumber, int secondNumber){
		return firstNumber*secondNumber;
	}

	public int subtractNumbers(int firstNumber, int secondNumber){
		return firstNumber-secondNumber;
	}

	public int divisionOfNumbers(int firstNumber, int secondNumber){
		return firstNumber/secondNumber;
	}

	public ArrayList<String> getArrayList(String... names){
		if(names == null){
			//ArrayList<String> arrayList = new ArrayList<String>();
			//arrayList.add("Rishi");
			//return arrayList;
			return new ArrayList<>();
		}
		ArrayList<String> listWithMultipleNames = new ArrayList<String>();
		Collections.addAll(listWithMultipleNames, names);
		return listWithMultipleNames;
	}

}
