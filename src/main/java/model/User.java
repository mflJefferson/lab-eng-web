/*
 ** This file contains the persistence class.
 ** Each class attribute is known as persistence attribute
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "user")
public class User { //persistence class

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;           //persistence attribute

    @Column(name = "name")
    private String name;       //persistence attribute

    public User() {
    }          //zero parameter constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
