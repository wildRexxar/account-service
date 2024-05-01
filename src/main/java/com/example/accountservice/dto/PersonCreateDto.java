package com.example.accountservice.dto;

import com.example.accountservice.entity.DocumentType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Schema(description = "Person create dto")
public class PersonCreateDto {
     @Schema(description = "Person email, must be uniq.", example = "test@test.com")
     private String email;
     @Schema(description = "Person document PASSPORT or DRIVE_ID.", example = "PASSPORT")
     private DocumentType documentType;
     @Schema(description = "Document number, must be uniq.", example = "PP110093")
     private String documentNumber;
}