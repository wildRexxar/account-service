package com.example.accountservice.dto;

import com.example.accountservice.entity.Currency;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Account create dto")
public class AccountCreateDto {

     @Schema(description = "Account currency must be only BYN or USD or RUB or EUR.", example = "BYN")
     private Currency currency;
     @Schema(description = "ID of the person for whom the account is being created.")
     private Long personId;
}
