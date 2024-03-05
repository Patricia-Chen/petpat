package com.example.pojo.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String type;

    @NotNull
    private String breed;

    @NotNull
    private String size;

    @NotNull
    private String gender;

    @NotNull
    private String age;

    @NotNull
    private String source;

    @NotNull
    private List<String> health;

    @NotNull
    private List<String> requirements;

    @NotNull
    private String price;

    private String reason;

    @NotNull
    private List<String> urls;

    @NotNull
    private String address;

    @NotNull
    private String story;

    @NotNull
    private String attention;

    @NotNull
    private String date;

}
