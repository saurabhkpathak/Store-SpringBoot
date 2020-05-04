package com.apparel.apparelstore.controllers;

import java.util.List;

import com.apparel.apparelstore.models.Clothing;
import com.apparel.apparelstore.repositories.ClothingRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/clothing")
public class ClothingController {
    @Autowired
    private ClothingRepository repo;

    @GetMapping
    public List<Clothing> GetAll() {
        return repo.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Clothing GetById(@PathVariable int id) {
        return repo.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Clothing Add(@RequestBody final Clothing clothing) {
        return repo.saveAndFlush(clothing);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void Delete(@PathVariable int id) {
        repo.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Clothing Update(@PathVariable int id, @RequestBody Clothing clothing) {
        Clothing clothToUpdate = repo.getOne(id);
        BeanUtils.copyProperties(clothing, clothToUpdate, "id");
        return repo.saveAndFlush(clothToUpdate);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PATCH)
    public Clothing UpdatePrice(@PathVariable int id, @RequestBody Double price) {
        Clothing clothToUpdate = repo.getOne(id);
        clothToUpdate.setPrice(price);
        return repo.saveAndFlush(clothToUpdate);
    }
}