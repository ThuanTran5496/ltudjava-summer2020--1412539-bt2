package app.utils;

import app.entities.User;

public class Common {
    public boolean checkUserLogin(User user) {
        if (user != null && user.getUserName().equals("user") && user.getPassword().equals("password")) {
                return true;
        }
        return false;
    }
}
