/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.todofx;

/**
 *
 * @author dagoa
 */
public class Task {
    
    private final String description;
    private boolean done;
    
    public Task (String description){
        this.description = description;
        this.done = false;
    }
    
    public String getDescription(){
        return description;
    }
    
    public boolean isDone(){
        return done;
    }
    
    public void setDone(boolean done){
        this.done = done;
    }
    
    @Override
    public String toString(){
        return (done ? "✅ " : "⬜ ") + description;
    }
    
}
