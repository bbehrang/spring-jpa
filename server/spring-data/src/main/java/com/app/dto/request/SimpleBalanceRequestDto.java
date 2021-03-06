package com.app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimpleBalanceRequestDto {
    @Positive(message = "Requested amount should be greater than 0")
    private Double amount;
}
