package ru.test.firsttest.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String breed;
}
