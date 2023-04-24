package com.anhquan.api_ontech.repositorys;

import com.anhquan.api_ontech.models.ProductLaptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductLaptopRepository extends JpaRepository<ProductLaptop, Long> {
}
