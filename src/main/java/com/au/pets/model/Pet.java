package com.au.pets.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "pets")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pet {

    @Id
    @Field("_id")
    private ObjectId id;
    private String name;
    private String type;
    private String origin;

    public Pet(ObjectId id, String name, String type, String origin) {

        this.id = id;
        this.name = name;
        this.type = type;
        this.origin = origin;
    }

    public ObjectId geId() {
        return id;
    }

    public String getIdString() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
