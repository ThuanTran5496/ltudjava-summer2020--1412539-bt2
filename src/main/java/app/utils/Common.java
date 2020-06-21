package app.utils;

import app.entities.User;

public class Common {
    public boolean checkUserLogin(User user) {
        if (user != null && user.getUserName().equals("admin") && user.getPassword().equals("admin")) {
                return true;
        }
        return false;
    }
}
