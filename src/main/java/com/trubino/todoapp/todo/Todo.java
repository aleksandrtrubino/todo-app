package com.trubino.todoapp.todo;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity(name = "todos")
public class Todo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	private String description;
	private boolean isDone;
	private LocalDateTime lastChangeTime;
	
	public Todo() {}

	public Todo(String title, String description, boolean isDone) {
		this.title = title;
		this.description = description;
		this.isDone = isDone;
	}

	public long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String text) {
		this.title = text;
	}
	public String getDescription(){return  description;}
	public void setDescription(String description){this.description = description;}
	public boolean getIsDone() {
		return isDone;
	}
	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}
	public LocalDateTime getLastChangeTime() {
		return lastChangeTime;
	}
	public void setLastChangeTime(LocalDateTime lastChangeTime) {
		this.lastChangeTime = lastChangeTime;
	}
}
