package com.notenest.notenest.contoller;


import com.notenest.notenest.entity.InformationEntry;
import com.notenest.notenest.service.InformationEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/InfoCnt")
public class InformationController {
    @Autowired
    private InformationEntryService informationEntryService;

    @GetMapping("/getall")
    public ResponseEntity<?> getAllInformationEntriesofNotes(){
        List<InformationEntry> all= informationEntryService.getAll();
        return new ResponseEntity<>(all,HttpStatus.OK);


    }
    @PostMapping("/create")
    public ResponseEntity<InformationEntry> createUser(@RequestBody InformationEntry myEntry) {
        try {
            myEntry.setDate(LocalDateTime.now());
            InformationEntry savedEntry = informationEntryService.saveEntry(myEntry);
            return new ResponseEntity<>(savedEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PostMapping
//    public ResponseEntity<InformationEntry> createEntry(@RequestBody InformationEntry myEntry) {
//        try {
//            myEntry.setDate(LocalDateTime.now());
//            informationEntryService.saveEntry(myEntry);
//            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.BAD_GATEWAY);
//        }
//    }
//      @PostMapping("/create")
//      public void createUser (@RequestBody InformationEntry myEntry){
//                informationEntryService.saveEntry(myEntry);
//}


}
