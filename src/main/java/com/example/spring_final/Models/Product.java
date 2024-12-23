package com.example.spring_final.Models;


import jakarta.persistence.*;

@Entity
    public class Product extends BaseModel {


        /* BOTH ENTITY CLASSES PRODUCT AND CATEGORY, RELATION= CARDINALITY
        Product Category
        1        1
        M        1
        CARDINALITY BETWEEN PRODUCT TO CATEGORY IS MANYTOONE
        M:1 --> relation --> category_id = acts like fk in the product table
        somebody delete the Product from product table persist the category don't delete
        // many-->for Product class-->many products have one category
        @JoinColumn(name = "category_id") // category_id acts like fk
        private Category category; // every product have category

        CascadeType.PERSIST is called FK Constraints -->
         PERSIST--> if u delete product from table --> for don't delete category
         inside product table category_id present if u remove product
         by row category_it will be remove for this avoid we use PERSIST
        * */

    // if someone tried to insert product which category does not exist
   // by using cascade  persist we can do that --> present in Product class

        @ManyToOne(cascade = {CascadeType.PERSIST})
        private Category category;

       private String title;
       private String description;
       private double price;
       private String imageUrl;

        public Product(String title, String description, double price, Category category, String imageUrl) {
            this.title = title;
            this.description = description;
            this.price = price;
            this.category = category;
            this.imageUrl = imageUrl;
        }

        public Product() {
        }

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }

        public double getPrice() {
            return this.price;
        }

        public Category getCategory() {
            return this.category;
        }

        public String getImageUrl() {
            return this.imageUrl;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setCategory(Category category) {
            this.category = category;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }



        /*
        *soft delete concept:
        * product table:-
        * id |createdAt | lastModified | isDeleted  | price title
        *  1 |14-12-2024| 14-12-2024   |   false    | 1500
        *  2 | -------  |  _____-      |   true     | 600
        *
        * if row two u want to delete then make isDeleted = true -->
        * defaults it's false --> just adding isDeleted column is called soft delete
        * and if u wand again product than male it false
        *
        * */
    }




