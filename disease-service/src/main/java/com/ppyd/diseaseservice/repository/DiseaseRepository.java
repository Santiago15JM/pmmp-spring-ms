package com.ppyd.diseaseservice.repository;

import com.ppyd.diseaseservice.models.Disease;
import com.ppyd.diseaseservice.models.Recommendation;
import com.ppyd.diseaseservice.models.dto.DiseaseName;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DiseaseRepository extends MongoRepository<Disease, String> {
    @Aggregation({"{$match: {_id: ?0}}",
            "{$lookup:{from:'recommendation',localField:'recommendations',foreignField:'_id',as:'recommendations'}}",
            "{$unwind: '$recommendations'}",
            "{$replaceRoot: {newRoot: '$recommendations'}}"
    })
    Recommendation[] getRecommendationsForDisease(ObjectId disease);

    @Query(value = "{animaltypes: ?0}", fields = "{_id: 1, name:1 }")
    DiseaseName[] getAllDiseases(String type);
}
