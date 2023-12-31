package com.woodpecker.backend.controller;

import com.woodpecker.backend.dtos.FlashcardRequest;
import com.woodpecker.backend.dtos.FlashcardResponse;
import com.woodpecker.backend.model.FlashCard;
import com.woodpecker.backend.service.FlashcardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flashcard")
public class FlashcardController {

    @Autowired
    private FlashcardService service;

    @PostMapping("/{categoryId}")
    public ResponseEntity<?> create(@PathVariable String categoryId, @Valid @RequestBody FlashcardRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            List<String> validationErrors = bindingResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                    .collect(Collectors.toList());
            //criando resposta de erro personalizada
            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", new Date());
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("errors", validationErrors);
            response.put("path", "/flashcard");

            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(service.create(categoryId, request));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<List<FlashcardResponse>> findAllByCategoryId(@PathVariable String categoryId){
        return ResponseEntity.ok(service.findAllByCategoryId(categoryId));
    }

    @GetMapping
    public ResponseEntity<List<FlashcardResponse>> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

 /*    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<FlashCard> findById(@PathVariable String id){

        FlashCard obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    } */

    @PutMapping("/{id}")
    public ResponseEntity<?> updateByUser(@PathVariable String id, @Valid @RequestBody FlashcardRequest request, BindingResult bindingResult){
        if(bindingResult.hasErrors()) handleErrors(bindingResult);
        return ResponseEntity.ok(service.updateByUser(id,request));
    }

    @PutMapping("/review/{id}")
    public ResponseEntity<?> updateByReview(@PathVariable String id, @Valid @RequestBody FlashcardRequest request) throws Exception{
        if(request.getDifficulty() == null){
            Map<String, Object> response = new HashMap<>();
            response.put("timestamp", new Date());
            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("errors", "Dificuldade nula.");
            response.put("path", "/flashcard");
        }
        return ResponseEntity.ok(service.udpateByReview(id, request));
    }

    private ResponseEntity<?> handleErrors(BindingResult bindingResult){

        List<String> validationErrors = bindingResult.getFieldErrors().stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.toList());
        //criando resposta de erro personalizada
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", new Date());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("errors", validationErrors);
        response.put("path", "/flashcard");

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

    }
}


