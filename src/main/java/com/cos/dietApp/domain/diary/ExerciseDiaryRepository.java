package com.cos.dietApp.domain.diary;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExerciseDiaryRepository extends MongoRepository<ExerciseDiary, String> {

}
