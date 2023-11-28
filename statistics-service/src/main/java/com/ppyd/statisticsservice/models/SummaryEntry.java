package com.ppyd.statisticsservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SummaryEntry {
    String disease;
    int percentage;
    Recommendation[] recommendations;
}
