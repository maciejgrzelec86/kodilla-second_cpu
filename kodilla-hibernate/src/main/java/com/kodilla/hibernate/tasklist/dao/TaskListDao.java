package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.Tasklist;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Transactional
@Repository
public interface TaskListDao extends CrudRepository<Tasklist, Integer> {
    String findByListname(String listname);
    void deleteByDescription(String description);
}