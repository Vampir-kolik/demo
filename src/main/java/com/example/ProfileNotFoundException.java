package com.example;

import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class ProfileNotFoundException {
    final int vId;

    public ProfileNotFoundException(int id) {
        this.vId = id;
    }

    public Supplier<? extends NoSuchElementException> fEx () {
        String vEx = "Error! Person Id = " + Integer.toString(vId);
        return () -> new NoSuchElementException(vEx);
    }
    
}
