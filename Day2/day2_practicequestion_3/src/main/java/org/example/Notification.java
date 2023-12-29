package org.example;
//single responsibility
public class Notification implements feed{
    void sentPushNotification(){
        System.out.println(feedUpdatedPost());
    }
    @Override
    public String feedUpdatedPost() {
        return "Notification -> new post added";
    }
}