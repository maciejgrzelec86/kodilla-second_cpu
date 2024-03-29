package com.kodilla.hibernate.tasklist;

import com.kodilla.hibernate.task.Task;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TASKLISTS")
public class Tasklist {
    private int id;
    private String listname;
    private String description;
    private List<Task> tasks = new ArrayList<>();
    public Tasklist(String listname, String description) {
        this.listname = listname;
        this.description = description;
    }

    public Tasklist() {
    }

    @Id
    @GeneratedValue
    @Column(name="ID", nullable = false, unique = true)
    public int getId() {
        return id;
    }
    @Column(name="LISTNAME")
    public String getListname() {
        return listname;
    }
    @Column(name="DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListname(String listname) {
        this.listname = listname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(
        targetEntity = Task.class,
        mappedBy = "taskList",
        //cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
