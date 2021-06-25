package com.example.coursescatalogservice.models;

import javax.persistence.*;

@Entity
@Table(name = "Courses")
public class CoursesCatalog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    private String name;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    private String description;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "limit")
    private Integer limit;
    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Column(name = "professor")
    private String professor;
    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public CoursesCatalog() {
    }

    public CoursesCatalog(String name, String description, Integer limit, String professor) {
        this.name = name;
        this.description = description;
        this.limit = limit;
        this.professor = professor;
    }
}
