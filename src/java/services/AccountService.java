/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.SingleParentDB;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.SingleParent;

/**
 *
 * @author 631503
 */
public class AccountService {

    public SingleParent login(String email, String password) {
        SingleParentDB singleParentDB = new SingleParentDB();

        try {
            SingleParent singleParent = singleParentDB.getByEmail(email);
            if (password.equals(singleParent.getPassword())) {
                return singleParent;
            }
        } catch (Exception e) {
        }

        return null;
    }


    /*public SingleParent login(String email, String password, String path) throws Exception {
        SingleParentDB singleParentDB = new SingleParentDB();

        try {
            SingleParent singleParent = singleParentDB.getByEmail(email);
            if (password.equals(singleParent.getPassword())) {
                Logger.getLogger(AccountService.class.getName()).log(Level.INFO, "Successful login by {0}", email);

                String to = singleParent.getEmail();
                String subject = "SingleParentLife App Login";
                String template = path + "/emailtemplates/login.html";

                HashMap<String, String> tags = new HashMap<>();
                tags.put("firstname", singleParent.getFirstName());
                tags.put("lastname", singleParent.getLastName());
                tags.put("date", (new java.util.Date()).toString());

                GmailService.sendMail(to, subject, template, tags);
                return singleParent;
            }
        } catch (Exception e) {
        }

        return null;
    }*/
    public SingleParent get(String email) throws Exception {
        SingleParentDB singleParentDB = new SingleParentDB();
        SingleParent singleParent = singleParentDB.getByEmail(email);
        return singleParent;
    }

    public void insert(String email, String password, String firstName, String lastName, Date dateOfBirth,
            char gender, String phoneNumber, String occupation, String aboutUser, char crimeClearanceChecked, char isActive) throws Exception {
        SingleParentDB singleParentDB = new SingleParentDB();
       // SingleParent singleParent = new SingleParent(email, password, firstName, lastName, dateOfBirth, gender, phoneNumber, occupation, aboutUser, crimeClearanceChecked, isActive);
       // singleParentDB.insert(singleParent);
    }
    
    

    /*public boolean forgotPassword(String email, String path) throws Exception {
        SingleParentDB singleParentDB = new SingleParentDB();
        SingleParent singleParent = singleParentDB.getByEmail(email);

        if (singleParent != null) {
            String to = email;
            String subject = "SingleParentLife Forgot Password";
            String template = path + "/emailtemplates/forgotpassword.html";

            HashMap<String, String> tags = new HashMap<>();
            tags.put("firstname", singleParent.getFirstName());
            tags.put("lastname", singleParent.getLastName());
            tags.put("email", email);
            tags.put("password", singleParent.getPassword());

            try {
                GmailService.sendMail(to, subject, template, tags);
            } catch (Exception ex) {
                Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
            }

            return true;
        } else {
            return false;
        }
    }*/
}
