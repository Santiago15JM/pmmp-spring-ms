package com.ppyd.statisticsservice.repository;

import com.ppyd.statisticsservice.models.Disease;
import com.ppyd.statisticsservice.models.Recommendation;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiseaseRepository extends MongoRepository<Disease, String> {
    @Aggregation({"{$match: {_id: ?0}}",
            "{$lookup:{from:'recommendation',localField:'recommendations',foreignField:'_id',as:'recommendations'}}",
            "{$unwind: '$recommendations'}",
            "{$replaceRoot: {newRoot: '$recommendations'}}"
    })
    Recommendation[] getRecommendationsForDisease(ObjectId disease);

}
