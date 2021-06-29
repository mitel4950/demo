package com.example.demo.pets;

import com.example.demo.Config;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class Lion implements Config.Animal {
    @Autowired
    private Pat pat;

    public Optional optional;

    public Lion(String name)
    {
        pat = new Pat(name);
    }

    public Pat getPat() {
        return pat;
    }

    public void setPat(Pat pat) {
        this.pat = pat;
    }
}
