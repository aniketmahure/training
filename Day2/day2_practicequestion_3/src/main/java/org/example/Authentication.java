package org.example;
//single responsibility
public class Authentication implements roles{
    void tokenValidationAndRole(String role){
        if(roleWriter().contains("writer")){
            System.out.println("writer authorised");
        } else if (roleEditor().contains("editor")){
            System.out.println("editor authorised");
        }else
        System.out.println("Not Authorised , Check Role");
    }
    public String roleWriter(){
        return "writer";
    }
    public String roleEditor(){
        return "editor";
    }
}