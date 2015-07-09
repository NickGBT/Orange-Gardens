package com.netbuilder.entity_managers.arraylist;

import java.util.ArrayList;

import com.netbuilder.entities.WishlistLine;
import com.netbuilder.entity_managers.interfaces.WishlistLineManager;

public class WishlistLineManagerAL implements WishlistLineManager{
	
	private ArrayList <WishlistLine> wishlistLines = new ArrayList <WishlistLine>();
	
	public void persistWishlistLine(WishlistLine wishlistLine){
		
		wishlistLines.add(wishlistLine);
	}

	public void persistWishlistLines(ArrayList<WishlistLine> wishlistLines)
	{
		wishlistLines.addAll(wishlistLines);
	}
}
