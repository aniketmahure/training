package org.designPatterns.singleton;

public class Logger {
    //create an object of Logger
    private static Logger obj=new Logger();

    //make the constructor private so that this class cannot be instantiated
    private Logger(){};

    //It returns the single instance of Class
    public static synchronized Logger getInstance(){
        return obj;
    }

    public void log(String message){
        System.out.println("message :"+message);
    }

}
