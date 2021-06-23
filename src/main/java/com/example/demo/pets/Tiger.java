package com.example.demo.pets;

import com.example.demo.Config;
import org.springframework.beans.factory.annotation.Autowired;

public class Tiger implements Config.Animal {
    public Pat pat;

    public Tiger(Pat pat)
    {
        this.pat = pat;
    }

    public Pat getPat() {
        return pat;
    }

    public void setPat(Pat pat) {
        this.pat = pat;
    }
}



