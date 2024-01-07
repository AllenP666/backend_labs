package ru.test.firsttest.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class StatusDTO {
    private Long id;
    private Boolean status;
}
