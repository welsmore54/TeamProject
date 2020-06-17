package com.example.teamproject;

class LoginScreen {
    private static String userName;

    public LoginScreen() {
        userName = "default";
    }

    public static boolean verify() throws Exception {
        return true;
    }

    public static boolean checkLength() throws Exception {
        if (userName.length() < 3) {
            // print something to screen - like "username too short"
            throw new IllegalArgumentException("Username is too short");
        }
        if (userName.length() > 20) {
            // same as above, except "username too long"
            throw new IllegalArgumentException("Username is too long");
        }
        return true;
    }
}
