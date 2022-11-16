package com.example.fitmeets.back;

import java.util.ArrayList;

/**
 * class WelcomeViewController
 */
public class WelcomeViewController {


    public static WelcomeViewController shared = new WelcomeViewController();

    // TODO: get majors from database
    public ArrayList<String> getMajors() {
        ArrayList<String> result = new ArrayList<>();
        return result;
    }

    // TODO: get interests from database
    public ArrayList<String> getInterests() {
        ArrayList<String> result = new ArrayList<>();

        return result;
    }

    // TODO: get account from database based on username and password, returns null if either are wrong
    public Account login(String username, String password) {

        return null;
    }

    // TODO: add recently created account to the database
    public void createAccount(Account account) {

    }

    // TODO: validate account information, returns false if any value is wrong
    public boolean validateAccountInformation(Account account) {
        /*
        returns false if any of the following is not met:
        1) email is empty or invalid
        2) student id is not valid
        3) name and last are empty
        4) does not meet password validation
        5) has not selected areas of interest
         */
        return  false;
    }
}
