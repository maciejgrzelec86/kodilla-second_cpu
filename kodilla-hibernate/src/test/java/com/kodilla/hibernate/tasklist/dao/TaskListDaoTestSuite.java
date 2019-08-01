package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.Tasklist;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "LISTNAME1";
    private static final String DESCRIPTION = "DESCRIPTION1";

    @Test
    public void testFindByListName() {
        //Given
        Tasklist tasklist = new Tasklist(LISTNAME, DESCRIPTION);
        //When
        taskListDao.save(tasklist);
        String listName = tasklist.getListname();
        //Then
        //Co oznacza Optional<Task>???
        String descriptionTest = taskListDao.findByListname(listName).getDescription();
        Assert.assertEquals(DESCRIPTION, descriptionTest);
        //Clean up
        taskListDao.deleteAll();
    }
}
