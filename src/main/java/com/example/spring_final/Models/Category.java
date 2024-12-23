package com.example.spring_final.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
    // TELL SPRING CREATE TABLE FOR THESE
    @Entity
    public class Category extends BaseModel {


        /* every category have list of products
         * CARDINALITY BETWEEN  CATEGORY TO PRODUCT: 1:m-- IS ONETOMANY
         * @OneToMany --> is created duplication here if we mentioned in
         * category as @manytoone here we no need to mention or define like
         * @OneToMany(mappedBy = "category") --> category
         * from private Category category; in product table
         * cascade = {CascadeType.REMOVE} --> if u delete category from the table
         * need to delete all products related to that category
         * one category have multiple products
         *
         * CascadeType.Remove is called FK Constraints -->
           REMOVE--> if u delete category from table
           * -->also delete product related to that id
         * */

        @OneToMany(mappedBy = "category", cascade = {CascadeType.REMOVE})
        @JsonIgnore
        private List<Product> products;
        private String title;

        public Category(String title, List<Product> products) {
            this.title = title;
            this.products = products;
        }

        public Category() {
        }

        public String getTitle() {

            return this.title;
        }

        public List<Product> getProducts() {

            return this.products;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }


    }



