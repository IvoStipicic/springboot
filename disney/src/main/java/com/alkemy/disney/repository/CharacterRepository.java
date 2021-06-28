package com.alkemy.disney.repository;

import com.alkemy.disney.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    List<Character> findByNameIgnoreCase(String name);
    List<Character> findByAge(int age);
    List<Character> findByWeight(double weight);
}
