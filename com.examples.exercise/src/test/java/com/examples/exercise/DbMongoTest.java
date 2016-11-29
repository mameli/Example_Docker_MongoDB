package com.examples.exercise;

import com.examples.exercise.common.AbstractDbMongoTest;
import com.github.fakemongo.Fongo;
import com.mongodb.MongoClient;

public class DbMongoTest extends AbstractDbMongoTest {

    @Override
    public MongoClient createMongoClient() {
        Fongo fongo = new Fongo("mongo server 1");
        MongoClient mongoClient = fongo.getMongo();
        return mongoClient;
    }

}
