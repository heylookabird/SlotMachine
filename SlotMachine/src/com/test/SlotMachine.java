package com.test;

import java.util.ArrayList;
import java.util.Scanner;

public class SlotMachine {
	ArrayList<Reel> reels;
	int purse;
	//ArrayList<Combination> winningCombos;
	
	public SlotMachine(){
		reels = new ArrayList<Reel>();
		purse = 50;
		
		Reel reel1 = new Reel();
		reel1.fillReel(5, 4, 6, 2);
		
		
		Reel reel2 = new Reel();
		reel2.fillReel(7, 2, 3, 1);
		
		Reel reel3 = new Reel();
		reel3.fillReel(7, 3, 4, 1);
		
		reels.add(reel1);
		reels.add(reel2);
		reels.add(reel3);

	}
	
	public void spin(){
		Symbol symbol1 = reels.get(0).spin();
		Symbol symbol2 = reels.get(1).spin();
		Symbol symbol3 = reels.get(2).spin();
		
		purse -= 5;
		
		System.out.println("Your spin: " + symbol1.getName() + ", " + symbol2.getName() + ", " + symbol3.getName());
		
		evaluateSpin(symbol1, symbol2, symbol3);
	}
	
	private void evaluateSpin(Symbol symbol1, Symbol symbol2, Symbol symbol3) {
		int sym1 = symbol1.getSym(), sym2 = symbol2.getSym(), sym3 = symbol3.getSym(); 
		
		if(sym1 == sym2 && sym2 == sym3){
			win(symbol1);
		}
		
		if(sym1 == 4){//sym1 is wild
			//both sym1 and sym3 are wild or sym2 and sym3 match
			if(sym2 == sym3 || sym3 == 4){
				win(symbol2);
			}else if(sym2 == 4)
				win(symbol3);
		}
		else if(sym2 == 4){
			//both sym2 and sym3 are wild or sym1 and sym3 match
			if(sym1 == sym3 || sym3 == 4){
				win(symbol1);
			}else if(sym1 == 4)
				win(symbol3);
		}
		else if(sym3 == 4){
			if(sym1 == sym2 || sym1 == 4){
				win(symbol2);
			}else if(sym2 == 4)
				win(symbol1);
		}
		
		replay();
	}
	
	//for the extra credit..dont want to mess with regular stuff in case I run out of time
	//going to figure out how to make a new repo on github on linux quickly
	public void evaluateSpin(String line1, String line2, String line3){
		
	}


	private void replay() {
		askSpin();
	}

	private void win(Symbol symbol1) {
		System.out.println("You won by matching 3 symbols or Wilds helped you a bit");
		int reward = symbol1.getReward();
		System.out.println("You win " + reward);
		purse += reward;
	}
	
	public void askSpin(){
		System.out.println("Would you like to spin? Costs 5 Y/N");
		System.out.println("You have " + purse + " money");
			
			Scanner scanner = new Scanner(System.in);
			
			String input = scanner.nextLine();
			
			
			if(input.contains("y") || input.contains("Y")){
				if(purse >= 5)
					spin();
			}else{
				System.out.println("Later");
			}
			
			scanner.close();
	}

	public static void main(String[] args){
		SlotMachine machine = new SlotMachine();
		
		machine.askSpin();
		
	}
}
