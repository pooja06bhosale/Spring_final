package com.example.spring_final.DTODS;

import com.example.spring_final.Models.Category;
import com.example.spring_final.Models.Product;

public class Fake_Store_Dto {

        // object is  looking exactly like fake store object third party object)
        // used for sending and receiving from outside the system -->
        //DTO -- Data Transfer Object

        private long id;
        private String title;
        private String description;
        private double price;
        private String image;
        private String category;

        public Fake_Store_Dto(long id, String title, String description, double price, String image, String category) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.price = price;
            this.image = image;
            this.category = category;
        }

        public Fake_Store_Dto() {
        }


        public Product toProduct() {
        /* in ProductServiceFakeStore class we
           fetch data from third party and save here in DTOs
           --> in class Product --> have private variables
            we initialise only --> no values stored in variables
            to stores the values in there use set
            -->  we want access that variables so create objects of that class
            -->  and set values
            -->
            in product class --  private Category category;
            and in DTOS --  private String category; make confusion

            -->  product.setCategory(category1);-->

         */

       /*

        1st we return this into Fake service class but this work to need complete dto

        Product product = new Product();

        product.setId(fakeStoreDtoResponse.getId());
        product.setDescription(fakeStoreDtoResponse.getDescription());
        product.setTitle(fakeStoreDtoResponse.getTitle());
        product.setPrice(fakeStoreDtoResponse.getPrice());
        product.setImageUrl(fakeStoreDtoResponse.getImage());

        Category category = new Category();
        category.setTitle(fakeStoreDtoResponse.getCategory());
        product.setCategory(category);
        */


            Product product = new Product();


            product.setDescription(description);
            product.setTitle(title);
            product.setPrice(price);
            product.setImageUrl(image);

            Category category1 = new Category();
            category1.setTitle(category);
            //String category --> but in Product class it works like a object so we need to convert this
            product.setCategory(category1);

            return product;


        }


        public long getId() {
            return this.id;
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

        public String getImage() {
            return this.image;
        }

        public String getCategory() {
            return this.category;
        }

        public void setId(long id) {
            this.id = id;
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

        public void setImage(String image) {

            this.image = image;
        }

        public void setCategory(String category) {

            this.category = category;
        }
    }


