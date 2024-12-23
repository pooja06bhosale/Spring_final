package com.example.spring_final.Service;

import com.example.spring_final.Models.Category;
import com.example.spring_final.Models.Product;
import com.example.spring_final.Repository.CategoryRepository;
import com.example.spring_final.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
    public class self_product_Service implements ProductService
    {
        //di --> dproductrepo
        private ProductRepository productRepository;
        private CategoryRepository categoryRepository;
        public self_product_Service(ProductRepository productRepository,
                                    CategoryRepository categoryRepository){
            this.productRepository = productRepository;
            this.categoryRepository = categoryRepository;
        }




        @Override
        //get all products from product table
        //findAll() --> JPA query method-->behind the seen orm implement all these method
        public List<Product> GetAllProducts() {
            List<Product> products = productRepository.findAll();
            return products;
        }

        @Override
        public Optional<Product> GetSingleProducts(long id) {
          Optional<Product> singleproduct =  productRepository.findById(id);
            return singleproduct;

        }

        /*@Override
        public Product CreateProduct(CreateProductsDtos createProductsDtos) {
            return null;
        }
        */
        @Override
        public Product CreateProduct(String title, String description, double price, String image, String category) {
            /* u need to get corresponding category object from the category table
            // u need to check with a category with name in the parameters exist or not
            // if category already exist will not create
            // here if i take string category="pooja" ; which already present
             in category table no need to create it
            //  if i take string category="poo" ; which not present in
             category table u have to  create it and set into Product
             */

            /* 1. we are getting all attributes from the controller
               2.we have to insert it into product table --> set all by creating product object
               3.we want to set category also
                 we have to first check weather category already exist or not
               4. we made database query (CategoryRepository ) inside findByTitle();
               5. if already exist than add into that category
               6. else create newCategory object add set into that category
               7. to save this product into table use ProductRepository
               8. save() ; method

             */

            Product product = new Product();
          product.setTitle(title);
          product.setDescription(description);
          product.setPrice(price);
          product.setImageUrl(image);

            /* just telling spring ple provide me
             object who's title is equal to  this String title
             which we maintained in String category inside CreateProduct method
            --> we put into Category --> will return category object
            if title already exist just put --product.setCategory(categoryFromDB);
            othervise create it and put it
            */


          Category categoryFromDB =categoryRepository.findByTitle(category);
          if(categoryFromDB != null){
              product.setCategory(categoryFromDB);
          }
          else{
              Category newCategory = new Category();
              newCategory.setTitle(category);
              product.setCategory(newCategory);

          }
         /* now u have to save this object into the database
            // insert the product into product table who will help?
            --> ProductRepository --> save method
           // if someone tried to insert product whose category does not exist
           by using cascade  persist we can do that --> present in Product class
            */

           Product createdProduct = productRepository.save(product);
           return createdProduct;

        }
    }


