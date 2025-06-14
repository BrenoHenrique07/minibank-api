package br.com.nobre.minibank_api.wallet.transaction.category.controller;

import br.com.nobre.minibank_api.commons.dto.PageResponseDto;
import br.com.nobre.minibank_api.commons.exception.NotFoundException;
import br.com.nobre.minibank_api.wallet.transaction.category.dto.TransactionCategoryRequestDto;
import br.com.nobre.minibank_api.wallet.transaction.category.dto.TransactionCategoryResponseDto;
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
    public ResponseEntity<PageResponseDto<TransactionCategoryResponseDto>> getAllCategories(@PageableDefault(size = 100, page = 0) Pageable pageable) {
        Page<TransactionCategoryResponseDto> page = categoryService.findAllCategories(pageable);
        return ResponseEntity.ok(PageResponseDto.from(page));
    }

    @PostMapping
    public ResponseEntity<TransactionCategoryResponseDto> createCategory(@RequestBody @Valid TransactionCategoryRequestDto categoryDto) {
        TransactionCategoryResponseDto responseDto = categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok(responseDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionCategoryResponseDto> updateCategory(@PathVariable(name = "id") Integer categoryId, @RequestBody @Valid TransactionCategoryRequestDto categoryDto) throws NotFoundException {
        TransactionCategoryResponseDto responseDto = categoryService.updateCategory(categoryId, categoryDto);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable(name = "id") Integer categoryId) throws NotFoundException {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.noContent().build();
    }

}
