package com.dsg.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dsg.onlinestore.model.Bottle;

public interface BottleRepository extends JpaRepository<Bottle, Long> {

}
