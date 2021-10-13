package com.cos.dietApp.domain.diary;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodDiaryRepository extends MongoRepository<FoodDiary, String>{

}
