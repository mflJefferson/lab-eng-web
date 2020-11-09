package model;
import javax.persistence.*;
import javax.persistence.Entity;
import java.sql.Date;
import java.util.Set;

@Entity(name = "disease")
public class Disease {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;           //persistence attribute

    @Column(name = "name")
    private String name;       //persistence attribute

    @Column(name = "symptoms")
    private String symptoms;

    @OneToMany(mappedBy="disease")
    private Set<Epidemic> epidemic;

    public Disease() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
}
