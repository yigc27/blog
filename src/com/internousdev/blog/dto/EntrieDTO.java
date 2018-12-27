package com.internousdev.blog.dto;
import java.util.Date;

public class EntrieDTO {
	private int id;
	private String title;
	private String text;
	private String author;
	private int author_id;
	private String category;
	private int category_id;
	private boolean publish;
	private Date post_date;
	private Date update_date;

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getText(){
		return text;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getAuthor(){
		return author;
	}

	public void setAuthor(String author){
		this.author= author;
	}

	public int getAuthor_id(){
		return author_id;
	}

	public void setAuthor_id(int author_id){
		this.author_id = author_id;
	}

	public String getCategory(){
		return category;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public int getCategory_id(){
		return category_id;
	}

	public void setCategory_id(int category_id){
		this.category_id = category_id;
	}

	public boolean getPublish(){
		return publish;
	}

	public void setPublish(boolean publish){
		this.publish = publish;
	}

	public Date getPost_date(){
		return post_date;
	}

	public void setPost_date(Date post_date){
		this.post_date = post_date;
	}

	public Date getUpdate_date(){
		return update_date;
	}

	public void setUpdate_date(Date update_date){
		this.update_date = update_date;
	}
}
