package com.notenest.notenest.service;

import com.notenest.notenest.entity.InformationEntry;
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

//    public InformationEntry saveEntry(InformationEntry entry){
//        return informationEntryRepository.save(entry);
//    }
    public List<InformationEntry> getAll(){
        return informationEntryRepository.findAll();
    }

//    public void saveEntry(InformationEntry myEntry){
//        informationEntryRepository.save(myEntry);
//    }

    public InformationEntry saveEntry(InformationEntry myEntry){
        return informationEntryRepository.save(myEntry);
    }


}
