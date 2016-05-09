package com.example.repos;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.models.nosql.CommentDocument;

public interface CommentDocumentRepo extends MongoRepository<CommentDocument, String> {
 CommentDocument findById(String id);
}
