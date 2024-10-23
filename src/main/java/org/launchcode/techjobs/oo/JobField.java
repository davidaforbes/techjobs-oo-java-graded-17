package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    public int id;
    public static int nextId = 1;
    public String value;

    public JobField() {
        id=nextId;
        nextId++;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Employer employer)) return false;
        return getId() == employer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
