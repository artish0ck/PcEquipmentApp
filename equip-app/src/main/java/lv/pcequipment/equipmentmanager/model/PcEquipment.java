package lv.pcequipment.equipmentmanager.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
public class PcEquipment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String model;
    private String type;
    private Boolean status;
    private String comment;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public PcEquipment() {
    }

    public PcEquipment(Long id, String model, String type, Boolean status, String comment) {
        this.id = id;
        this.model = model;
        this.type = type;
        this.status = status;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "PcEquipment{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                ", comment='" + comment + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
