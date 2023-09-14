package com.example.labs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @NotBlank(message = "Vui lòng nhập họ tên")
    private String name;
    @NotBlank(message = "Vui lòng nhập email")
    @Email
    private String email;
    @Min(value = 0, message = "Điểm phải lớn hơn hoặc bằng 0")
    @Max(value = 10, message = "Điểm phải nhỏ hơn hoặc bằng 10")
    @NotNull(message = "Vui lòng nhập điểm")
    private Double marks;
    @NotNull(message = "Vui lòng chọn giới tính")
    private Boolean gender;
    @NotNull(message = "Vui lòng chọn khoa")
    private String faculty;
    @NotEmpty(message = "Vui lòng chọn sở thích")
    private String hobbies;
}
