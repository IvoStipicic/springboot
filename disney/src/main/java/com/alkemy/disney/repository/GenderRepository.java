package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<Gender, Integer> {
}
