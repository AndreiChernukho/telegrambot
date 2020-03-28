package com.company.telegrambot.city.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Город.
 */
@Entity
@Table(name = "city")
public class City implements Serializable {

    /**
     * Идентификатор.
     */
    @Id
    @Column(name = "id", columnDefinition = "char(36)", length = 36)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    /**
     * Название.
     */
    @Column(name = "name")
    private String name;

    /**
     * Описание.
     */
    @Column(name = "description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
