package ru.gb.group4546_5984.spring_sem06_hw_task02.domain.locations;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class LocationResult {
    private Integer id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private Date created;
}
