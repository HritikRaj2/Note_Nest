package com.notenest.notenest.service;

import com.notenest.notenest.entity.InformationEntry;
import com.notenest.notenest.repository.InformationEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InformationEntryService {

    @Autowired
    private InformationEntryRepository informationEntryRepository;
    public InformationEntry saveEntry(InformationEntry entry){
        return informationEntryRepository.save(entry);
    }

}
