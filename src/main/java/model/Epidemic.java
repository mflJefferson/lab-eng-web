package model;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "epidemic")
public class Epidemic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "collection_date")
    private java.sql.Date collectionDate;

    @ManyToOne
    @JoinColumn(name="disease_id", nullable=false)
    private Disease disease;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(Date collectionDate) {
        this.collectionDate = collectionDate;
    }

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
}
