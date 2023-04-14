package org.backend.kappastoneletsgo.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IdGenerator {

    @Id
    @GeneratedValue
    private int id;

    public IdGenerator() { }

    public int getId() {
        return id;
    }
}
