package com;

public class Contact {
	 private int id;
	    private String title;
	    private String author;
	 
	    public Contact(){}
	 
	    public Contact(String title, String author) {
	        super();
	        this.title = title;
	        this.author = author;
	    }
	 
	    //getters & setters
	 
	    @Override
	    public String toString() {
	        return "Name [id=" + id + ", Phone=" + title + ", author=" + author + "]";
	    }

}
