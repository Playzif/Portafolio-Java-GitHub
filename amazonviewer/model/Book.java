package com.playzif.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;
import com.playzif.util.*;

public class Book extends Libraries implements IVisualizable {
	
	private int id;
	private String isbn;
	private boolean readed;
	private int timeReaded;
	private ArrayList<Page> pages;
	
	
	
	public Book(String title, Date edititionDate, String editorial, String[] authors, ArrayList<Page> pages) {
		super(title, edititionDate, editorial);
		setAuthors(authors);
		this.pages = pages;
	}


	public int getId() {
		return id;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public String isReaded() {
		String leido = "";
		if(readed == true) {
			leido = "Sí";
		}else {
			leido = "No";
		}
		
		return leido;
	}


	public void setReaded(boolean readed) {
		this.readed = readed;
	}
	
	public boolean getIsReaded() {
		return readed;
	}


	public int getTimeReaded() {
		return timeReaded;
	}


	public void setTimeReaded(int timeReaded) {
		this.timeReaded = timeReaded;
	}
	
	@Override
	public String toString() {
		
		String detailBook = ""
				+ "|| BOOK ||" + 
				 			"\n" +
							"\nTitle: " + getTitle() +
							"\nEditorial: " + getEditorial() + 
							"\nEdition Date: " + getEdititionDate() +
							"\nAuthors: ";
		
		for (int i = 0; i < getAuthors().length; i++) {
			detailBook += "\t" + getAuthors()[i] + " ";
		}
		return  detailBook;
	}


	@Override
	public Date startToSee(Date dateI) {

		return dateI;
	}


	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if (dateF.getTime() > dateI.getTime()) {
			setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
		}
		
		else {
			setTimeReaded(0);
		}
	}
	
	public void view() {
		setReaded(true);
		Date dateI = startToSee(new Date());
		
		int i = 0;
		do {
			System.out.println("..........");
			System.out.println("Page " + getPages().get(i).getNumber());
			System.out.println(getPages().get(i).getContent());
			System.out.println("..........");
			
			if (i != 0) {
				System.out.println("1. Regresar Página");
			}
			
			System.out.println("2. Siguiente Página");
			System.out.println("0. Cerrar Libro");
			System.out.println();
			
			int response  = AmazonUtil.validateUserResponseMenu(0, 2);
			
			if (response == 2) {
				i++;	
			}
			
			else if(response == 1) {
				i--;
			}
			
			else if(response == 0) {
				break;
			}
			
		}
		
		while(i < getPages().size());
		
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Leíste: " + toString());
		System.out.println("Por: " + getTimeReaded() + " milisegundos");
	}
	
	public static ArrayList<Book> makeBookList() {
		ArrayList<Book> books = new ArrayList();
		String[] authors = new String[3];
		for (int i = 0; i < 3; i++) {
			authors[i] ="Author "+i;
		}
		
		ArrayList<Page> pages = new ArrayList();
		int pagina = 0;
		for (int i = 0; i < 3; i++) {
			pagina = i + 1;
			pages.add(new Book.Page(pagina, "El contenido de la página " + pagina));
		}
		
		for (int i = 1; i <= 5; i++) {
			books.add(new Book("Book " + i, new Date(), "editorial " + i, authors, pages));
		}
		
		return books;
	}
	
	
	public ArrayList<Page> getPages() {
		return pages;
	}


	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}


	public static class Page {
		private int id;
		private int number;
		private String content;
	
		public Page(int number, String content) {
			super();
			this.number = number;
			this.content = content;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public int getNumber() {
			return number;
		}
		
		public void setNumber(int number) {
			this.number = number;
		}
		
		public String getContent() {
			return content;
		}
		
		public void setContent(String content) {
			this.content = content;
		}
	}
}