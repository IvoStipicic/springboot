package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterDto;
import com.alkemy.disney.dto.CharacterModifyDto;
import com.alkemy.disney.entity.Character;
import java.util.List;

public interface CharacterService {

    List<CharacterDto> getAll();
    Character createCharacter(Character character);
    Character modifyCharacter(CharacterModifyDto character);
    void deleteCharacter(int id);
    List<Character> lookForName(String name);
    List<Character> lookForAge(int age);
    List<Character> lookForWeight(double weight);
    Character getDetailsCharacter(int id);
}
