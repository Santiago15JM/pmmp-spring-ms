package com.ppyd.statisticsservice.models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;

@Data
@Document
public class Summary {

    public Summary(String type, String breed) {
        this.type = type;
        this.breed = breed;
    }

    public void addEntry(SummaryEntry entry) {
        entries.addLast(entry);
    }

    String type;
    String breed;
    LinkedList<SummaryEntry> entries = new LinkedList<>();
}
