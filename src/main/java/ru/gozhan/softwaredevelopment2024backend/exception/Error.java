package ru.gozhan.softwaredevelopment2024backend.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer code;
    private String message;
}
