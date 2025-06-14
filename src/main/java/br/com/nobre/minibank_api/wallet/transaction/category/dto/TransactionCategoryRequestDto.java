package br.com.nobre.minibank_api.wallet.transaction.category.dto;

import jakarta.validation.constraints.NotBlank;

public record TransactionCategoryRequestDto(
        @NotBlank(message = "Nome é obrigatório")
        String name
) {}
