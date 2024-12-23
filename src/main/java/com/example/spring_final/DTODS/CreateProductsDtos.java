package com.example.spring_final.DTODS;

public class CreateProductsDtos {



//sending info to third party API's-->
// dtos used for sending & receiving data to third party
// JSON format info we created -->to match this to third party

    // sending from postman

        private String title;
        private String description;
        private double price;
        private String image;
        private String category;

        public CreateProductsDtos(String title, String description, double price, String image, String category) {
            this.title = title;
            this.description = description;
            this.price = price;
            this.image = image;
            this.category = category;
        }

        public CreateProductsDtos() {
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

    /*category type is string bec in third party
     category will be in String format we need to match this to this
    */
    }




