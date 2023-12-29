package com.stackroute.swaggerautoconfbean.config;


import jakarta.activation.DataSource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//implement DataSource interface in CustomDataSource Class to override the methods
public class CustomDataSource implements DataSource {
    //Override the DataSource interface methods
    @Override
    public InputStream getInputStream() throws IOException {
        return null;
    }
    @Override
    public OutputStream getOutputStream() throws IOException {
        return null;
    }
    @Override
    public String getContentType() {
        return null;
    }
    @Override
    public String getName() {
        return null;
    }
}
