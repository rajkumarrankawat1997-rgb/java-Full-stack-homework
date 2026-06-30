package org.example.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.validation.Prime;
import org.example.validation.ValidPassword;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;

    @NotBlank(message = "Name must not be blank")
    @Size(min = 2, max = 100)
    private String name;

    @Email(message = "Email must be valid")
    @NotBlank
    private String email;

    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number must be exactly 10 digits")
    private String phoneNumber;

    @ValidPassword
    private String password;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 65, message = "Age must not exceed 65")
    private Integer age;

    @DecimalMin(value = "10000.0", message = "Salary must be at least 10000")
    @DecimalMax(value = "1000000.0", message = "Salary must not exceed 1000000")
    private Double salary;

    @Positive(message = "Experience years must be positive")
    private Integer experienceYears;

    @PositiveOrZero(message = "Number of dependents cannot be negative")
    private Integer numberOfDependents;

    @Past(message = "Date of birth must be in the past")
    private LocalDate dateOfBirth;

    @FutureOrPresent(message = "Joining date cannot be in the past")
    private LocalDate joiningDate;

    @AssertTrue(message = "Employee must accept terms and conditions")
    private boolean acceptedTerms;

    @URL(message = "Portfolio link must be a valid URL")
    private String portfolioUrl;

    @CreditCardNumber(message = "Invalid credit card number")
    private String reimbursementCardNumber;

    @Digits(integer = 6, fraction = 0, message = "Employee code must be a number with up to 6 digits")
    private String employeeCode;

    @NotEmpty(message = "Skills list must not be empty")
    private List<String> skills;

    @Prime(message = "Lucky number must be a prime number")
    private Integer luckyNumber;
}
