package org.example;
//extended in BlogPostManagement class fully hence, follows Liskov Substitution Principle (LSP)
public class posts {
    String articlePost(){
        return "Article Post";
    }
    String videoPost(){
        return "Video Post";
    }
    String imagePost(){
        return "Image Post";
    }
}