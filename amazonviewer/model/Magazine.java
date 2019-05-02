package com.playzif.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

public class Magazine extends Libraries{
	private int id;
	
	public Magazine(String title, Date edititionDate, String editorial) {
		super(title, edititionDate, editorial);
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		
		String detailMagazine = "\n|| MAGAZINE ||" + 
								"\nTitle: " + getTitle() +
								"\nEditorial: " + getEditorial() + 
								"\nEdition Date: " + getEdititionDate() +
								"\nAuthors: ";
		
		for (int i = 0; i < getAuthors().length; i++) {
			detailMagazine += "\t" + getAuthors()[i] + " ";
		}
		return  detailMagazine;
	}
	
	public static ArrayList<Magazine> makeMagazineList() {
		
		ArrayList<Magazine> magazines = new ArrayList();
		String[] authors = new String[3];
		
		for (int i = 0; i < 3; i++) {
			authors[i] = "Author "+i;
		}
		
		for (int i = 1; i <= 5; i++) {
			magazines.add(new Magazine("Magazine " + i, new Date(), "Editorial " + i));
		}
		return magazines;
	}

}