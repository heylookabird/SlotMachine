package com.test;

//to keep track of symbols
//just going to use an int since theres not that many..not worth it to make an enum or children
//1 = cherry, 2 = grape, 3 = orange, 4 = wild
public class Symbol {
	private int symbol, tripleReward;
	private String name;

	public Symbol(int sym) {
		symbol = sym;

		switch (sym) {
		case 1:
			name = "Cherry";
			tripleReward = 5;
			break;

		case 2:
			name = "Grape";
			tripleReward = 10;
			break;

		case 3:
			name = "Orange";
			tripleReward = 15;
			break;

		case 4:
			name = "Wild";
			tripleReward = 100;
			break;
		}
	}
	
	public int getSym(){
		return this.symbol;
	}
	
	public String getName(){
		return name;
	}
	
	public int getReward(){
		return tripleReward;
	}

}
