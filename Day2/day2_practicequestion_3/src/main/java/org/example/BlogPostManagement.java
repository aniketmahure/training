package org.example;

import java.util.ArrayList;
import java.util.List;
//single responsibility
//Open-Closed Principle
//Liskov Substitution Principle (LSP)
public class BlogPostManagement extends posts{
    private List<String> blog= new ArrayList<>();

    void writePost(String write){
        blog.add(write);
        System.out.println("Writer's Blog: "+write);
        articlePost();
        videoPost();
        imagePost();
    }
    void editPost(String editor){
        System.out.println("editor suggested : "+editor);
    }
}