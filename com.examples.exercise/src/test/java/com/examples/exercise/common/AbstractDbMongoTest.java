package com.examples.exercise.common;

import com.examples.exercise.DbMongo;
import com.examples.exercise.Student;
import com.examples.exercise.helper.MongoTestHelper;
import com.mongodb.MongoClient;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.*;

/**
 * Created by mameli on 29/11/2016.
 *
 */
public abstract class AbstractDbMongoTest {
    // SUT
    private DbMongo mongoDatabase; // helper for testing with Mongo
    private MongoTestHelper mongoTestHelper;

    @Before
    public void initDB() throws UnknownHostException {
    // in-memory java implementation of MongoDB
    // so that we don't need to install MongoDB in our computer

    MongoClient mongoClient = createMongoClient();
    mongoTestHelper = new MongoTestHelper(mongoClient);
    mongoDatabase = new DbMongo(mongoClient);
    }

    public abstract MongoClient createMongoClient() throws UnknownHostException;

    @Test
    public void testGetAllStudentsEmpty() { assertTrue(mongoDatabase.getAllStudentsList().isEmpty());
    }

    @Test
    public void testGetAllStudentsNotEmpty() { mongoTestHelper.addStudent("1", "first"); mongoTestHelper.addStudent("2", "second");
        assertEquals(2, mongoDatabase.getAllStudentsList().size());
    }

    @Test
    public void testFindStudentByIdNotFound() { mongoTestHelper.addStudent("1", "first");
        assertNull(mongoDatabase.takeStudentsById("2"));
    }

    @Test
    public void testFindStudentByIdFound(){
        mongoTestHelper.addStudent("1", "first");
        mongoTestHelper.addStudent("2","second");

        Student findStudentById = mongoDatabase.takeStudentsById("2");
        assertNotNull(findStudentById);
        assertEquals("2", findStudentById.getId());
        assertEquals("second", findStudentById.getName());
    }
}
