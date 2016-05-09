package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.stream.IntStream;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.models.nosql.CommentDocument;
import com.example.repos.CommentDocumentRepo;
import com.example.repos.ProjectRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsCriteria;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TaskTrackerApplication.class)
@WebAppConfiguration
public class TaskTrackerApplicationTests {

	@Autowired
	ProjectRepo repo;

	@Autowired
	CommentDocumentRepo commentDocRepo;

	@Autowired
	MongoOperations operations;
	@Autowired
	GridFsTemplate gridFsTemplate;

	@Test
	public void testAllProjects() {

		// System.out.println(repo.findAll());
		// IntStream.range(1, 5).forEach((i)->{
		// CommentDocument doc = new CommentDocument();
		// doc.setCreatedBy("EABCHOU");
		// doc.setCreated_at(new Date());
		// doc.setDescription("Some task "+i);
		// System.out.println(commentDocRepo.save(doc));
		// });

//		operations
//				.find(Query.query(Criteria.where("created_at").exists(true))
//						.with(new Sort(Sort.Direction.DESC, "created_at")), CommentDocument.class)
//				.forEach((s) -> System.out.format("{id:%s, desc:%s, createdat:%s}", s.getId(), s.getDescription(),
//						s.getCreated_at())
//						);
//		;
		
		operations.updateMulti(Query.query(Criteria.where("created_at").exists(true)), new Update().set("taskId", 1001), CommentDocument.class);
		
		/*
		 * try { FileInputStream inStream = new FileInputStream(
		 * "C:/Work/OpenShift_repos/opens_task/src/main/resources/Photo1.jpg");
		 * System.out.println(gridFsTemplate.store(inStream,"Photo").getId()); }
		 * catch (FileNotFoundException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		// System.out.println(gridFsTemplate.findOne(Query.query(GridFsCriteria.where("_id").is(new
		// ObjectId("572b37e4ae1a33cf7df015dc")))));
	}

}
