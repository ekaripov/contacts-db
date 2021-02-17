package ru.ekaripov.contactsdb.api.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ekaripov.contactsdb.exceptions.DatabaseEntryNotFoundException;
import ru.ekaripov.contactsdb.exceptions.IdNotDefinedException;
import ru.ekaripov.contactsdb.model.PersonCategory;
import ru.ekaripov.contactsdb.model.converter.impl.PersonCategoryDtoConverter;
import ru.ekaripov.contactsdb.model.dto.PersonCategoryDto;
import ru.ekaripov.contactsdb.service.interf.PersonCategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person/category")
@AllArgsConstructor
public class PersonCategoryRestController {
    private final PersonCategoryService personCategoryService;
    private final PersonCategoryDtoConverter converter;
    
    @GetMapping
    public ResponseEntity<List<PersonCategoryDto>> getAllPersonCategory(){
        return ResponseEntity.ok(converter.convertToDto(personCategoryService.getAllPersonCategory()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PersonCategoryDto> getPersonCategoryById(@PathVariable Long id){
        return personCategoryService.findById(id)
                .map(personCategory -> ResponseEntity.ok(converter.convertToDto(personCategory)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PersonCategoryDto> addPersonCategory(@RequestBody PersonCategory personCategory){
        personCategory.setId(null);
        return ResponseEntity.ok(converter.convertToDto(personCategoryService.addPersonCategory(personCategory)));
    }

    @PutMapping
    public ResponseEntity<PersonCategoryDto> updatePersonCategory(@RequestBody PersonCategory personCategory){
        try{
            return ResponseEntity.ok(converter.convertToDto(personCategoryService.updatePersonCategory(personCategory)));
        } catch (DatabaseEntryNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (IdNotDefinedException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersonCategory(@PathVariable Long id){
        try{
            personCategoryService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (DatabaseEntryNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
