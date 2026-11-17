package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos;

    // Bean oluştuğunda Map'i başlatıyoruz
    @PostConstruct
    public void init() {
        kangaroos = new HashMap<>();
    }

    // [GET] /workintech/kangaroos
    @GetMapping
    public List<Kangaroo> getAll() {
        return new ArrayList<>(kangaroos.values());
    }

    // [GET] /workintech/kangaroos/{id}
    @GetMapping("/{id}")
    public Kangaroo getById(@PathVariable Integer id) {
        // Eğer istenen id map içerisinde yoksa kendi özel hatamızı fırlatıyoruz
        if (!kangaroos.containsKey(id)) {
            throw new ZooException("Kangaroo with given id is not exist: " + id, HttpStatus.NOT_FOUND);
        }
        return kangaroos.get(id);
    }

    // [POST] /workintech/kangaroos
    @PostMapping
    public Kangaroo add(@RequestBody Kangaroo kangaroo) {
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroos.get(kangaroo.getId());
    }

    // [PUT] /workintech/kangaroos/{id}
    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable Integer id, @RequestBody Kangaroo kangaroo) {
        kangaroo.setId(id); // ID eşleşmesini garantiye alıyoruz
        kangaroos.put(id, kangaroo);
        return kangaroos.get(id);
    }

    // [DELETE] /workintech/kangaroos/{id}
    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable Integer id) {
        return kangaroos.remove(id); // remove() metodu silinen objeyi geri döner
    }
}