package com.notenest.notenest.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Indexed;

import java.util.ArrayList;
import java.util.List;

@Document(collection="User")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Long id;

    @NonNull
    private String username;

    @NonNull
    private String password;

    @DBRef
    private List<InformationEntry> informationEntries=new ArrayList<>();
    private List<String> roles;
}
