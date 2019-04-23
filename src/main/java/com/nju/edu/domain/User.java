package com.nju.edu.domain;

/*仅供测试，可以覆盖*/
public class User {
    private int userId;

    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
