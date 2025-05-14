package com.notenest.notenest.contoller;


import com.notenest.notenest.entity.InformationEntry;
import com.notenest.notenest.entity.User;
import com.notenest.notenest.service.InformationEntryService;
import com.notenest.notenest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/InfoCnt")
public class InformationController {
    @Autowired
    private InformationEntryService informationEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllInformationEntriesofNotes(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName=authentication.getName();
        User user=userService.findByUsername(userName);
        //List<InformationEntry> all= informationEntryService.getAll();
        List<InformationEntry> all=user.getInformationEntries();
        return new ResponseEntity<>(all,HttpStatus.OK);


    }
    @PostMapping("/create")
    public ResponseEntity<InformationEntry> createUser(@RequestBody InformationEntry myEntry) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String userName=authentication.getName();
            myEntry.setDate(LocalDateTime.now());
            informationEntryService.saveEntry(myEntry,userName);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }





}
