package br.com.nobre.minibank_api.wallet.transaction.category.controller;

import br.com.nobre.minibank_api.commons.dto.PageResponseDto;
import br.com.nobre.minibank_api.wallet.transaction.category.dto.TransactionCategoryRequestDto;
import br.com.nobre.minibank_api.wallet.transaction.category.dto.TransactionCategoryResponseDto;
import br.com.nobre.minibank_api.wallet.transaction.category.model.TransactionCategory;
import br.com.nobre.minibank_api.wallet.transaction.category.service.TransactionCategoryService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transaction-categories")
public class TransactionCategoryController {

    private final TransactionCategoryService categoryService;

    public TransactionCategoryController(TransactionCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<PageResponseDto<TransactionCategory>> getAllCategories(@PageableDefault(size = 100, page = 0) Pageable pageable) {
        Page<TransactionCategory> page = categoryService.findAllCategories(pageable);
        return ResponseEntity.ok(PageResponseDto.from(page));
    }

    @PostMapping
    public ResponseEntity<TransactionCategoryResponseDto> createCategory(@RequestBody @Valid TransactionCategoryRequestDto categoryDto) {
        TransactionCategoryResponseDto responseDto = categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok(responseDto);
    }

}
