package com.marolix.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.entity.Hospital;


public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
    Hospital findByHospitalName(String hospitalName);

    // Add more query methods as needed for your hospital entity
}


