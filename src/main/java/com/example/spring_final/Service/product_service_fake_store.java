package com.example.spring_final.Service;


import com.example.spring_final.DTODS.Fake_Store_Dto;
import com.example.spring_final.Models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("FakeStoreProductService")
public class product_service_fake_store implements ProductService{
    // is it like proxy service-->work with third party API's
    // DI--> inject RestTemplate class object
    // REST tamplate work like thirdparty
    //crete object of RestTamplate--> service connected to restTemplate --> third party

    private RestTemplate restTemplate;
    public product_service_fake_store(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }




    @Override
    public List<Product> GetAllProducts() {

        // getting an array of fakestoredto objects


        // Product return type is list --create list
        // which will be returned by method

        Fake_Store_Dto[] productDtosFakeArray = restTemplate.getForObject("https://fakestoreapi.com/products",Fake_Store_Dto[].class);
        List<Product> products = new ArrayList<>();
        for(Fake_Store_Dto productDtosFake: productDtosFakeArray) {
            //iterate over the array
            // took individual productDtosFake and converted into toProduct()
            Product product = productDtosFake.toProduct();
            //and added into products
            products.add(product);
        }
        return products;

    }



    @Override
    public Optional<Product> GetSingleProducts(long id) {
        // get single product from this url nad put into dto class -->
        // dto class have exactly same variable like third party
        // you're getting data in  Fake_Store_Dto format u have to convert it into Product format
        // Product class have extra variables
        /*we want operation for single products
         * url--> thirdParty
         * restTemplate.getForObje --> used for getting product info from third party
         * ProductDtosFake.class --> storing info toward this class
         * ProductDtosFake productDtosFake --> fetching data from third party and store in DTO class
         * */

       // Fake_Store_Dto  productDtosFake = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,Fake_Store_Dto.class);
      //  return productDtosFake.toProduct();

        //toProduct called from DTOSFake
        return null;
    }



    /*
     this is dummy a dummy endpoint , it does nothing
     --> consider so many user posing there that make issues thats reason
     --> CreateProductDtos coming from controller that converted into  ProductDtosFake
     -->bec third party variable need to have same variable so we converted into dtofake
     */

   /*
    @Override
    public Product CreateProduct( CreateProductsDtos createProductsDtos) {
        Fake_Store_Dto productDtosFake = new Fake_Store_Dto();
        productDtosFake.setTitle(createProductsDtos.getTitle());
        productDtosFake.setDescription(createProductsDtos.getDescription());
        productDtosFake.setPrice(createProductsDtos.getPrice());
        productDtosFake.setCategory(createProductsDtos.getCategory());
        productDtosFake.setImage(productDtosFake.getImage());

        // doing posting of object to restAPI user postfor object
        Fake_Store_Dto productDtosFake1=  restTemplate.postForObject("https://fakestoreapi.com/products",productDtosFake,Fake_Store_Dto.class);
        return productDtosFake1.toProduct();
    }
    */
    @Override
    public Product CreateProduct(String title, String description, double price, String image, String category) {
        return null;
    }

}
