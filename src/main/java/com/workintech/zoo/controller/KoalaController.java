package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {

    private Map<Integer, Koala> koalas;

    // Bean oluştuğunda Map'i başlatıyoruz
    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
    }

    // [GET] /workintech/koalas
    @GetMapping
    public List<Koala> getAll() {
        return new ArrayList<>(koalas.values());
    }

    // [GET] /workintech/koalas/{id}
    @GetMapping("/{id}")
    public Koala getById(@PathVariable Integer id) {
        return koalas.get(id);
    }

    // [POST] /workintech/koalas
    @PostMapping
    public Koala add(@RequestBody Koala koala) {
        koalas.put(koala.getId(), koala);
        return koalas.get(koala.getId());
    }

    // [PUT] /workintech/koalas/{id}
    @PutMapping("/{id}")
    public Koala update(@PathVariable Integer id, @RequestBody Koala koala) {
        koala.setId(id);
        koalas.put(id, koala);
        return koalas.get(id);
    }

    // [DELETE] /workintech/koalas/{id}
    @DeleteMapping("/{id}")
    public Koala delete(@PathVariable Integer id) {
        return koalas.remove(id);
    }
}