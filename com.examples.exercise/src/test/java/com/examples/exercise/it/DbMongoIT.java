package com.examples.exercise.it;

import com.examples.exercise.common.AbstractDbMongoTest;
import com.mongodb.MongoClient;

import java.net.UnknownHostException;

/**
 * Created by mameli on 29/11/2016.
 *
 */
public class DbMongoIT extends AbstractDbMongoTest {


    public MongoClient createMongoClient() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient();
        return mongoClient;
    }
}
