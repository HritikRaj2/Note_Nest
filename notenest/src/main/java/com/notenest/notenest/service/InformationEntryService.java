package com.notenest.notenest.service;

import com.notenest.notenest.entity.InformationEntry;
import com.notenest.notenest.entity.User;
import com.notenest.notenest.repository.InformationEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.bson.types.ObjectId;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.List;


@Service
public class InformationEntryService {

    @Autowired
    private InformationEntryRepository informationEntryRepository;

    @Autowired
    private UserService userService;

    public List<InformationEntry> getAll(){
        return informationEntryRepository.findAll();
    }

//    public InformationEntry saveEntry(InformationEntry myEntry){
//        return informationEntryRepository.save(myEntry);
//    }

    @Transactional
    public void saveEntry(InformationEntry informationEntry,String userName){
        User user= userService.findByUsername(userName);
        InformationEntry saved =informationEntryRepository.save(informationEntry);
        user.getInformationEntries().add(saved);
        userService.saveUser(user);
    }


}
