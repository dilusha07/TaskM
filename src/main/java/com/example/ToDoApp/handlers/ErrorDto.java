package com.example.ToDoApp.handlers;

import com.example.ToDoApp.exception.ErrorCodes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = "Holds error code, error message and related error messages of an error")
public class ErrorDto {

    @ApiModelProperty(value = "The error code.", required = true)
    private Integer httpCode;

    @ApiModelProperty(value = "The error code.", required = true)
    private ErrorCodes code;

    @ApiModelProperty(value = "A detailed error message.")
    private String message;

    @ApiModelProperty(value = "The input fields related to the error, if any.")
    List<String> errors = new ArrayList<>();

    public Integer getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(Integer httpCode) {
        this.httpCode = httpCode;
    }

    public ErrorCodes getCode() {
        return code;
    }

    public void setCode(ErrorCodes code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
