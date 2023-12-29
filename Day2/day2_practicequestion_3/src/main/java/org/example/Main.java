package org.example;

public class Main {
    public static void main(String[] args) {
        Authentication authentication= new Authentication();
        authentication.tokenValidationAndRole("writer");

        BlogPostManagement blogPostManagement= new BlogPostManagement();
        blogPostManagement.writePost("this is my blog");

        blogPostManagement.editPost("this is edited blog");
        Notification notification= new Notification();
        notification.sentPushNotification();
    }
}