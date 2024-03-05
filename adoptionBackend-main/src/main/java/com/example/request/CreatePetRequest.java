package com.example.request;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
public class CreatePetRequest {

    private String name;

    private String type;

    private String breed;

    private String size;

    private String gender;

    private String age;

    private String source;

    private List<String> health;

    private List<String> requirements;

    private String price;

    private String reason;

    private List<String> urls;

    private String address;

    private String story;

    private String attention;

    private String date;
}
