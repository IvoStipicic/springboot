package com.alkemy.disney.controller.rest;

import com.alkemy.disney.dto.CharacterDto;
import com.alkemy.disney.dto.CharacterModifyDto;
import com.alkemy.disney.entity.Character;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/characters")
public class CharacterRestController {

    @Autowired
    private CharacterService characterService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CharacterDto> getAll(){
        return characterService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Character getDetailsCharacter(@PathVariable(value = "id") int id){
        return characterService.getDetailsCharacter(id);
    }

    @GetMapping("/name")
    public  @ResponseBody List<Character> getCharacterName(@RequestParam("name") String name){
        return characterService.lookForName(name);
    }

    @GetMapping("/age")
    @ResponseStatus(HttpStatus.OK)
    public List<Character> getCharacterAge(@RequestParam(value = "age") int age){
        return characterService.lookForAge(age);
    }

    @GetMapping("/weight")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody List<Character> getCharacterWeight(@RequestParam(value = "weight") double weight){
        return characterService.lookForWeight(weight);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Character createCharacter(@RequestBody Character character){
        return characterService.createCharacter(character);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCharacter(@PathVariable(value = "id") int id) {
        characterService.deleteCharacter(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Character updateCharacter(@RequestBody CharacterModifyDto character, @PathVariable(value = "id") int id){
        return characterService.modifyCharacter(character);
    }

}
