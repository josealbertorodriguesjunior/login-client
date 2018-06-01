/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juniorlima.simplelogin.controller;

import com.google.gson.Gson;
import com.juniorlima.simplelogin.model.UserModel;
import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author junior
 */
public class UserController {

    public void signUp(UserModel userModel) throws IOException {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClientBuilder.create().build();
        StringEntity entity = new StringEntity(gson.toJson(userModel),
                ContentType.APPLICATION_JSON);
        HttpPost request = new HttpPost("http://localhost:8080/api/sign-up");
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);
        if (response.getStatusLine().getStatusCode() != 200) {
            System.err.println("Error, username or email already in use!");
        }
        System.out.println(response.getStatusLine().getStatusCode());
        System.err.println(gson.toJson(userModel));
    }

    public void login(UserModel userModel) throws IOException {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClientBuilder.create().build();
        StringEntity entity = new StringEntity(gson.toJson(userModel),
                ContentType.APPLICATION_JSON);
        HttpPost request = new HttpPost("http://localhost:8080/api/login");
        request.setEntity(entity);
        HttpResponse response = httpClient.execute(request);
        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println("\nWelcome to the Dashboard "+ userModel.getUsername());
        } else {
            System.out.println("\nAccess Denied");
        }
    }
}
