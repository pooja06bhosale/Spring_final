package com.example.spring_final.Repository;

import com.example.spring_final.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
   // select * from Category where title like "Poo"--> this will handle by spring
    // JPA methods--> findByTitle();-->Declared queries
    // will return Category object--> finding object by title
    // just telling spring ple provide me
    // object who's title is equal to  this String title


    Category findByTitle(String title);




}
