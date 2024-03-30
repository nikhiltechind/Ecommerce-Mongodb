package org.example.Controller;

import org.bson.types.ObjectId;
import org.example.Model.Category;
import org.example.Model.Product;
import org.example.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/link/{id}")
    public Category link(@PathVariable int id, @RequestBody List<Product> products) {

        Category savedcategory = categoryService.link(id, products);
        return savedcategory;
    }

    @PostMapping("/add-category")
    public Category save(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @GetMapping("/findbyid/{id}")
    public Category findbyid(@PathVariable ObjectId id) {
        return categoryService.findCategoryById(id);
    }

    @PostMapping("/saveall")
    public List<Category> saveall(@RequestBody List<Category> categories) {
        // System.out.println(categories);

        return categoryService.saveall(categories);
    }

    @GetMapping("/findall")
    public List<Category> findAll() {
        return categoryService.findAllCategories();
    }

    @GetMapping("/findcategorybycatid/{catId}")
    public Category findcatbycatid(@PathVariable int catId) {
        return categoryService.findCategoryByCatId(catId);
    }
    @GetMapping("/findcategorybyid/{Id}")
    public Category findcatbyid(@PathVariable ObjectId Id) {
        System.out.println("inside findcatbyid");
        return categoryService.findCategoryById(Id);
    }

}
