package com.example.labs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentTwo {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    private String email;
    @Min(value = 0)
    @Max(value = 10)
    @NotNull
    private Double marks;
    @NotNull
    private Boolean gender;
    @NotNull
    private String faculty;
    @NotEmpty
    private String hobbies;
}
