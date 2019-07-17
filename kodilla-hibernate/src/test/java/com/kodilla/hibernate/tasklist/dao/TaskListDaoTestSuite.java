package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.tasklist.Tasklist;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "Listname1";
    private static final String DESCRIPTION = "DESCRIPTION1";

    @Test
    public void testFindByListName() {
        //Given
        Tasklist tasklist = new Tasklist(LISTNAME, DESCRIPTION);
        //When
        taskListDao.save(tasklist);
        //Then
        //Co oznacza Optional<Task>???
        Optional<> descriptionTest = taskListDao.findByListname(LISTNAME);
        Assert.assertEquals(LISTNAME, descriptionTest);
        taskListDao.deleteByDescription(DESCRIPTION);
    }
}
