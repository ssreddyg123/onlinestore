package com.dsg.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dsg.onlinestore.model.Beverage;

@Repository
public interface BeverageRepository extends JpaRepository<Beverage, Long> {

}
