package com.SpringJavaProfessionals.SpringJavaProfessionals.Controller;

import com.SpringJavaProfessionals.SpringJavaProfessionals.Data.FileStorageRepository;
import com.SpringJavaProfessionals.SpringJavaProfessionals.Data.PersonRepository;
import com.SpringJavaProfessionals.SpringJavaProfessionals.Model.Person;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping ("/people")
@Log4j2
public class PeopleController {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private FileStorageRepository fileStorageRepository;

//  @Autowired
//    public PeopleController(PersonRepository personRepository, FileStorageRepository filestoreRepository) {
//        this.personRepository = personRepository;
//        this.fileStoryRepository = fileStoreRepository
//    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople(){
        return personRepository.findAll();
    }

    @ModelAttribute //spring will catch the nameclass person and end up with ("person") without the need for specify
    public Person getPerson(){
        return new Person();
    }

    @GetMapping
    public String showPeoplePage(Model model){
        return "people";
    }

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors, @RequestParam("photoFilename") MultipartFile photoFile) throws IOException {
        if (!errors.hasErrors()) {
            fileStorageRepository.save(photoFile.getOriginalFilename(), photoFile.getInputStream());
            personRepository.save(person);
            return "redirect:people";
        }
        return "people";
    }

    @PostMapping(params = "delete=true")
    public String deletePerson(@RequestParam Optional<List<Long>> selections){
        if (selections.isPresent()) {
            personRepository.deleteAllById(selections.get());
        }
        return "redirect:people";
    }

    @PostMapping(params = "edit=true")
    public String editPerson(@RequestParam Optional<List<Long>> selections, Model model){
        if (selections.isPresent()) {
            Optional<Person> person = personRepository.findById(selections.get().get(0));
            model.addAttribute("person", person);
        }
        return "people";
    }



}
