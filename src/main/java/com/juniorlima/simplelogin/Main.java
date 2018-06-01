/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.juniorlima.simplelogin;

import com.juniorlima.simplelogin.controller.UserController;
import com.juniorlima.simplelogin.model.UserModel;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author junior
 */
public class Main {

    public static void main(String[] args) throws IOException {
        UserModel userModel = new UserModel();
        UserController userController = new UserController();
        Scanner input = new Scanner(System.in);
        System.out.println("Choose an option: (type the option number eg: [1-2])\n");
        System.out.println("1 - Create New User:\n");
        System.out.println("2 - Login with credentials:\n");
        int option = input.nextInt();
        String name = null;
        String username = null;
        String email = null;
        String password = null;

        switch (option) {
            case 1:
                System.out.println("Insert your full name: \n");
                name = input.nextLine();
                System.out.println("\nInsert your username: \n");
                username = input.nextLine();
                System.out.println("\nInsert your email: \n");
                email = input.nextLine();
                System.out.println("\nInsert your password: \n");
                password = input.nextLine();
                userModel.setName(name);
                userModel.setUsername(username);
                userModel.setEmail(email);
                userModel.setPassword(password);

                userController.signUp(userModel);
                break;
            case 2:
                System.out.println("Insert your credentials: \n");
                input.nextLine();
                System.out.println("Username: \n");
                username = input.nextLine();
                System.out.println("\nPassword: \n");
                password = input.nextLine();
                userModel.setUsername(username);
                userModel.setPassword(password);
                userController.login(userModel);
                break;
            default:
                System.out.println("Option not allowed");

        }

    }
}
