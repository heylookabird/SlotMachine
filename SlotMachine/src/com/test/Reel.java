package com.test;

import java.util.ArrayList;
import java.util.List;


public class Reel {
	ArrayList<Symbol> symbols;
	int size;//using size to make the use of array a little more flexible
	
	public Reel(){
		symbols = new ArrayList<Symbol>();
		size = 0;
	}
	
	public void addToReel(Symbol symbol){
		symbols.add(symbol);
		size++;
	}
	
	public Symbol spin(){
		double random = Math.random();
		int index = (int)(random * symbols.size());
		return symbols.get(index);
	}
	
	public void addMultipleToReel(Symbol symbol, int num){
		while(num > 0){
			addToReel(symbol);
			num--;
		}
	}
	
	public void addCherries(int num){
		while(num > 0){
			addToReel(new Symbol(1));
			num--;
		}
	}
	
	public void addGrapes(int num){
		while(num > 0){
			addToReel(new Symbol(2));
			num--;
		}
	}
	
	public void addOranges(int num){
		while(num > 0){
			addToReel(new Symbol(3));
			num--;
		}
	}
	
	public void addWild(int num){
		while(num > 0){
			addToReel(new Symbol(4));
			num--;
		}
	}
	
	public void fillReel(int cherries, int grapes, int oranges, int wild){
		this.addCherries(cherries);
		addGrapes(grapes);
		addOranges(oranges);
		addWild(wild);
	}
}
