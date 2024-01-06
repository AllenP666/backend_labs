package ru.test.firsttest.DTO;

import lombok.Data;

@Data
public class ResponseDTO {
    private String status;
    private Object data;
}
