package org.example.Service;


import org.bson.types.ObjectId;
import org.example.Model.Category;
import org.example.Model.Product;
import org.example.Repository.CategoryRepository;
import org.example.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    ProductRepository productRepository;
    public Category saveCategory(Category category) {

        return  categoryRepo.save(category);
    }
    public Category link(int id, List<Product> products){

        Category category= findCategoryByCatId(id);
        System.out.println(category);
     //List<Product> prodList=new ArrayList<>();
        for (Product product : products) {
            productRepository.save(product);
        }
        System.out.println(category.getItems());
        for(Product product:products) {
            category.getItems().add(product);
        }
        categoryRepo.save(category);
        return category;
    }
    public void deleteCategoryById(ObjectId id) {
        categoryRepo.deleteById(id);
    }

    public List<Category> findAllCategories() {
        return categoryRepo.findAll();
    }

    public Category findCategoryById(ObjectId id) {
//        System.out.println("hitted");
//        System.out.println(categoryRepo.findById(id));
        return categoryRepo.findById(id).get();
    }
    public Category findCategoryByCatId(int catId){
        return categoryRepo.getCategoryByCatId(catId);
    }

    public List<Category> saveall(List<Category> categories){

        return categoryRepo.saveAll(categories);
    }
    public Category findcatbyid(@PathVariable ObjectId Id) {
        return categoryRepo.findById(Id).get();
    }

}
