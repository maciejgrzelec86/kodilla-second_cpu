package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.task.dao.TaskDao;
import com.kodilla.hibernate.task.dao.TaskFinancialDetailsDao;
import com.kodilla.hibernate.tasklist.Tasklist;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;


//@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    @Autowired
    private TaskFinancialDetailsDao taskFinancialDetailsDao;

    @Autowired
    private TaskDao taskDao;
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
        String descriptionTest = taskListDao.findByListname(listName).get(0).getDescription();

        try {
            Assert.assertEquals(DESCRIPTION, descriptionTest);
        } finally {
            //Clean up
            taskListDao.deleteAll();
        }
    }

    @Test
    public void testNamedQueries() {
        //Given
        Task task1 = new Task("Test: Study Hibernate", 3);
        Task task2 = new Task("Test: Practice Named Queries", 6);
        Task task3 = new Task("Test: Study native queries", 7);
        Task task4 = new Task("Test: Makse some tests", 13);

        TaskFinancialDetails tfd1 = new TaskFinancialDetails(new BigDecimal(5), false);
        TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);
        TaskFinancialDetails tfd3 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails tfd4 = new TaskFinancialDetails(new BigDecimal(15), false);

        task1.setTaskFinancialDetails(tfd1);
        task2.setTaskFinancialDetails(tfd2);
        task3.setTaskFinancialDetails(tfd3);
        task4.setTaskFinancialDetails(tfd4);

        Tasklist taskList = new Tasklist(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);
        taskList.getTasks().add(task3);
        taskList.getTasks().add(task4);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);
        task3.setTaskList(taskList);
        task4.setTaskList(taskList);

        taskListDao.save(taskList);
        taskFinancialDetailsDao.save(tfd1);
        taskFinancialDetailsDao.save(tfd2);
        taskFinancialDetailsDao.save(tfd3);
        taskFinancialDetailsDao.save(tfd4);
        taskDao.save(task1);
        taskDao.save(task2);
        taskDao.save(task3);
        taskDao.save(task4);

        int id = taskList.getId();

        //When
        List<Task> longTasks = taskDao.retrieveLongTasks();
        List<Task> shortTasks = taskDao.retrieveShortTasks();
        List<Task> enoughTimeTasks = taskDao.retrieveTasksWithEnoughTime();
        List<Task> durationLongerThanTasks = taskDao.retrieveTasksWithDurationLongerThan(6);
        //Then
        try {
            Assert.assertEquals(1, longTasks.size());
            Assert.assertEquals(3, shortTasks.size());
            Assert.assertEquals(3, enoughTimeTasks.size());
            Assert.assertEquals(2, durationLongerThanTasks.size());
        } finally {
            //CleanUp
            taskDao.deleteAll();
            taskFinancialDetailsDao.deleteAll();
            taskListDao.deleteAll();
        }
    }
}
