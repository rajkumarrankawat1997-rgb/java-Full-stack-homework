package org.example.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Long id;

    @NotBlank(message = "Title must not be blank")
    @Size(min = 2, max = 50, message = "Title must be between 2 and 50 characters")
    private String title;

    @NotNull(message = "isActive must be specified")
    private boolean isActive;

    @PastOrPresent(message = "createdAt cannot be in the future")
    private LocalDateTime createdAt;
}
