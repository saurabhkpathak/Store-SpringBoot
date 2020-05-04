package com.apparel.apparelstore.repositories;

import com.apparel.apparelstore.models.Clothing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClothingRepository extends JpaRepository<Clothing, Integer> {

}