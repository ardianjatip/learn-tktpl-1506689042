package com.mobileprogramming.helloworld;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Band {
    private String name;
    private String yearFormed;
    private String origin;
    private String genre;
}
