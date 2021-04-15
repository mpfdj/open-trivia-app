package com.example.restservice.model.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Data
@Document(indexName = "open-trivia")
public class Question {

    @Id
    private String id;

    @Field(type = FieldType.Keyword, name = "category")
    private String category;

    @Field(type = FieldType.Text, name = "question")
    private String question;

    @Field(type = FieldType.Keyword, name = "type")
    private String type;

    @Field(type = FieldType.Text, name = "answer")
    private String answer;

    @Field(type = FieldType.Nested, name = "choices")
    private List<String> choices;

}
