package com.example.spring_final.Controller;

import com.example.spring_final.DTODS.CreateProductsDtos;
import com.example.spring_final.Models.Product;
import com.example.spring_final.Service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
    public class ProductController {

        /*why we created object of ProductService rather than FakeStore
        --> in future there will many services we need create
         object for all instead of doing this we create parent object

         -->created variable of ProductService
         -->decency Injection --> create object of productService
         -->gave output in JSON format */
        //DI--> controller can't work without service object--> so create object of ProductService
        //constructor injection--> inject the object into the class Constructor
        // here fake and self two service present--> current we using fake so we put into Qualifier
        private ProductService productService;
        public ProductController(@Qualifier("SelfProductService") ProductService productService)
        {
            this.productService = productService;
        }


        @GetMapping("/Products")
        public List<Product> GetAllProducts(){

            return productService.GetAllProducts();
        }

        /* 3API -->GET ALL, GET SINGLE, CREATE -->controller call multiple API'S
         here /Products/{id} --> id is variable -->it can be anything
         @PathVariable("id") --> taking path of /Products/{id} here and put into long id
        * */
        @GetMapping("/Products/{id}")
        public Optional<Product> GetSingleProducts(@PathVariable long id){

            return productService.GetSingleProducts(id);
        }


        /*
        added to rest API --> usser gives product info in form of payload (JSON)format info
        * {
             title ='---',
             description= '___',    // it's called payload  controlled received from user
             imageUrl='___'         // which is stored in controller by createProductsDTO--
                                   //CreateProductsDtos in this class
             .
             .
             }
        *

        * */
        /*
         * here we are changing the return type from void to Product just for testing*/


        /* @PostMapping("/Products")
        public Product CreateProduct(@RequestBody CreateProductsDtos createProductsDtos){
            // @RequestBody and payload both are same -->
            // payload(using postman) coming from user to controller inJSONformat
            return productService.CreateProduct(createProductsDtos);

        } */
        @PostMapping("/Products")
        public Product CreateProduct(@RequestBody CreateProductsDtos createProductsDtos){
            // @RequestBody and payload both are same -->
            // payload(using postman) coming from user to controller inJSONformat
            //controller first validate these dto object and that send in
            // service don't need the dto object it just want parameters foRm of parameters to the servise
            return productService.CreateProduct(createProductsDtos.getTitle(),
                    createProductsDtos.getDescription(), createProductsDtos.getPrice(),
                    createProductsDtos.getImage(),
                    createProductsDtos.getCategory());





    }}


