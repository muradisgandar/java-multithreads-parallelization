package org.example.streams.parallelstreams;

import java.io.Serializable;

public class Person implements Serializable {

    private int personId;

    public Person(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

}
