package com.example.demo.prototype;

import org.springframework.beans.factory.annotation.Value;


public class Sex {

    private boolean isBoy;

    public Sex(boolean isBoy) {
        this.isBoy = isBoy;
    }

    public boolean isBoy() {
        return isBoy;
    }

    public void setIsBoy(boolean boy) {
        isBoy = boy;
    }
}
