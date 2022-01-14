package com.pracownia.rest.Models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Ceos")
public class Ceo extends Person{
    private int salary;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Ceo{" +
                "salary=" + salary +
                '}';
    }
}
