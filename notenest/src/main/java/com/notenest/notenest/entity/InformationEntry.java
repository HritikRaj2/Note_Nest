package com.notenest.notenest.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection="Information")
@Data
@NoArgsConstructor
public class InformationEntry {
    @Id
    private ObjectId id;

    @NonNull
    private String notename;
    private LocalDateTime date;
    private String content;

}
