package br.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Dewes on 16/07/2016.
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String selfLink;

    @JsonIgnore
    private Boolean isActive;

    @JsonIgnore
    private Date createdDate;

    @JsonIgnore
    private Date modifiedDate;

    @PrePersist
    public void prePersist(){
        this.createdDate  = new Date();
        this.modifiedDate = this.createdDate;
        this.isActive     = true;
    }

    @PreUpdate
    public void preUpdate(){
        this.modifiedDate	= new Date();
    }

    public Boolean getActive() {
        return isActive;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

}
