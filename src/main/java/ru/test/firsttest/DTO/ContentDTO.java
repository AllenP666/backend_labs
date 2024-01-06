package ru.test.firsttest.DTO;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ContentDTO {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
}
