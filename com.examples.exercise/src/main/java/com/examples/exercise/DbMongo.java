package com.examples.exercise;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class DbMongo implements Database {

	private MongoCollection students;

	public DbMongo(MongoClient mongoClient) {
		DB db = mongoClient.getDB("school");
		Jongo jongo = new Jongo(db);
		students = jongo.getCollection("student");

	}

	public List<Student> getAllStudentsList() {
		Iterable<Student> iterable = students.find().as(Student.class);

		return StreamSupport
				.stream(iterable.spliterator(),false)
				.collect(Collectors.toList());

		//v2
//		DBCursor cursor = students.find();
//		return StreamSupport.stream(cursor.spliterator(),false).
//							map(e-> new Student((String)e.get("id"),(String)e.get("name"))).
//							collect(Collectors.toList());
		//v1
//		List<Student> resultList = new ArrayList<Student>();
//		if (cursor.hasNext()) {
//			DBObject toAdd = cursor.next();
//			resultList.add(new Student((String) toAdd.get("id"), (String) toAdd.get("name")));
//		}
//		return resultList;
	}

	public void updateDB(String id, String name) {
	}

	public boolean exists(String id) {
		return false;
	}

	public Student takeStudentsById(String id) {
		return students.findOne("{id: #}", id).as(Student.class);
//		BasicDBObject searchQuery = new BasicDBObject();
//		searchQuery.put("id",id);
//		DBObject findOne = students.findOne(searchQuery);
//		return findOne != null ?
//				  new Student((String)findOne.get("id"),(String)findOne.get("name"))
//				: null;
	}

}
