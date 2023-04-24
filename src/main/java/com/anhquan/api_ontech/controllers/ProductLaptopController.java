package com.anhquan.api_ontech.controllers;

import com.anhquan.api_ontech.models.ProductLaptop;
import com.anhquan.api_ontech.services.ProductLaptopService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/laptops")
public class ProductLaptopController {
    @Autowired
    private ProductLaptopService service;
    @Autowired
    private Cloudinary cloudinary;

   //GET ALL PRODUCT LAPTOP
    @GetMapping("/all")
    public List<ProductLaptop> getAllProducts() {
        return service.getAllProducts();
    }

    //GET PRODUCT LAPTOP BY ID
    @GetMapping("/{id}")
    public ProductLaptop getLaptopById(@PathVariable Long id) {
        return service.getProductById(id);
    }

    //POST PRODUCT LAPTOP
    @PostMapping("/insert")
    public ProductLaptop createLaptop(@RequestBody ProductLaptop laptop) {
        return service.createProduct(laptop);
    }
//Insert Product with Image
//    @PostMapping("/upload")
//    public ProductLaptop uploadLaptop(
//                                      @RequestParam("name") String name,
//                                      @RequestParam("description") String description,
//                                      @RequestParam("price") double price,
//                                      @RequestParam("years") int year,
//                                      @RequestParam(value = "image", required = false) MultipartFile file ) throws IOException {
//        // Tạo public_id cho file ảnh
//        String publicId = "laptop_" + new Date().getTime();
//
//        // Upload file ảnh lên Cloudinary
//        Map uploadResult = cloudinary.uploader().upload(file.getBytes(),
//                ObjectUtils.asMap("public_id", publicId));
//
//        // Lấy url ảnh từ Cloudinary
//        String imageUrl = (String) uploadResult.get("secure_url");
//
//        // Tạo đối tượng Laptop mới
//        ProductLaptop laptop = new ProductLaptop();
//        laptop.setName(name);
//        laptop.setDescription(description);
//        laptop.setPrice((int) price);
//        laptop.setYears(year);
//        laptop.setImageUrl(imageUrl);
//
//        // Trả về đối tượng Laptop đã upload thành công
//      return service.createProduct(laptop);
////        return laptop;
//    }
    //UPDATE PRODUCT LAPTOP
    @PutMapping("/{id}")
    public ResponseEntity<ProductLaptop> updateProduct(@PathVariable Long id, @RequestBody ProductLaptop product) {
        ProductLaptop updatedProduct = service.updateProduct(id, product);
        if (updatedProduct == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedProduct);
    }

     //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = service.deleteProduct(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
