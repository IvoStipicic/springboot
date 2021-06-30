package com.alkemy.disney.service.impl;


import com.alkemy.disney.dto.CharacterDto;
import com.alkemy.disney.dto.CharacterModifyDto;
import com.alkemy.disney.entity.Character;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.service.CharacterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }


    @Override
    public List<CharacterDto> getAll() {
        List<Character> characters = characterRepository.findAll();
        ArrayList<CharacterDto> characterDtos = new ArrayList<CharacterDto>() {
        };
        for(Character character : characters){
            characterDtos.add(new CharacterDto(character.getName(), character.getImage()));
        }
        return characterDtos;
    }


    @Override
    public Character createCharacter(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public Character modifyCharacter(CharacterModifyDto character) {
        Character existCharacter = characterRepository.findById(character.getId()).orElseThrow();
            existCharacter.setName(character.getName());
            existCharacter.setAge(character.getAge());
            existCharacter.setWeight(character.getWeight());
            existCharacter.setHistory(character.getHistory());
            existCharacter.setMovies(character.getMovies());
            existCharacter.setImage(character.getImage());
        return characterRepository.save(existCharacter);
    }

    @Override
    public void deleteCharacter(int id) {
        Optional<Character> character = characterRepository.findById(id);
        if(character != null) {
            characterRepository.deleteById(id);
        }
    }

    @Override
    public List<Character> lookForName(String name) {
        return characterRepository.findByNameIgnoreCase(name);
    }

    @Override
    public List<Character> lookForAge(int age) {
        return characterRepository.findByAge(age);
    }

    @Override
    public List<Character> lookForWeight(double weight) {
        return characterRepository.findByWeight(weight);
    }

    @Override
    public Character getDetailsCharacter(int id) {
        Character character = characterRepository.findById(id).orElse(null);
        return character;
    }


}