package com.notenest.notenest.contoller;


import com.notenest.notenest.entity.InformationEntry;
import com.notenest.notenest.service.InformationEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/InfoCnt")
public class InformationController {
    @Autowired
    private InformationEntryService informationEntryService;

//    @GetMapping
//    public ResponseEntity<?> getAllInformationEntriesofUser(){
//
//    }


    @PostMapping
    public ResponseEntity<InformationEntry> createEntry(@RequestBody InformationEntry myEntry) {
        try {
            myEntry.setDate(LocalDateTime.now());
            InformationEntry savedEntry = informationEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }



}
