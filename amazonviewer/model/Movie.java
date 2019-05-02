package com.playzif.amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;
import com.playzif.amazonviewer.dao.MovieDAO;

/**
 * Hereda de {@link Film}
 * Implementa de {@link IVisualizable}
 * */

public class Movie extends Film implements IVisualizable, MovieDAO {
		
	private int id;
	private int timeViewed;
	
	public Movie() {
		
	}
	public Movie(String title, String genre, String creator, int duration, short year) {
		super(title, genre, creator, duration);
		setDate(year);
	}

	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getTimeViewed() {
		return timeViewed;
	}
	public void setTimeViewed(int timeViewed) {
		this.timeViewed = timeViewed;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n|| MOVIE ||" + 
				"\nTitle: " + getTitle() +
				"\nGenero: " + getGenre() + 
				"\nYear: " + getDate() + 
				"\nCreator: " + getCreator() +
				"\nDuration: " + getDuration();
	}

	@Override
	public Date startToSee(Date dateI) {
		return dateI;
	}

	@Override
	public void stopToSee(Date dateI, Date dateF) {
		if (dateF.getTime() > dateI.getTime()) {
			setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
		}else {
			setTimeViewed(0);
		}
	}
	
	public static ArrayList<Movie> makeMoviesList() {
		Movie  movie = new Movie();
		return movie.read();
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * */
	@Override
	public void view() {

		setViewed(true);
		Movie movie = new Movie();
		movie.setMovieViewed(this);
		Date dateI = startToSee(new Date());
		
		for (int i = 0; i < 100000; i++) {
			System.out.println("..........");
		}
		
		stopToSee(dateI, new Date());
		System.out.println();
		System.out.println("Visto: " + "\n" + toString());
		System.out.println("Por: " + getTimeViewed() + " milisegundos");
	}
	
}

