package org.example.Repository;

import org.bson.types.ObjectId;
import org.example.Model.Category;
import org.example.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, ObjectId> {

    @Query("{catId:?0}")
    Category getCategoryByCatId(int catId);
}
