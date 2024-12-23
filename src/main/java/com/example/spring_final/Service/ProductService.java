package com.example.spring_final.Service;

import com.example.spring_final.Models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

     /*--> we use interface--> it has multiple implementation-->
     here it's acts like a dummy service -->
     bec we don't have our own
     database we are taking from third party*/


    //called by controller

    public List<Product> GetAllProducts();

    public Optional<Product> GetSingleProducts(long id);

    /*Product CreateProduct(CreateProductsDtos createProductsDtos);

    avoid sending CreateProductsDtos object to service
     we just send whatever info we need to send  service class from CreateProductsDtos
     we send these parameters to service
     */

    Product CreateProduct(String title,String description,double price,
                          String image, String category);

}
