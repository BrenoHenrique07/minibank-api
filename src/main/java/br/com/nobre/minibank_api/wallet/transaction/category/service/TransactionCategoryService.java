package br.com.nobre.minibank_api.wallet.transaction.category.service;

import br.com.nobre.minibank_api.wallet.transaction.category.dto.TransactionCategoryRequestDto;
import br.com.nobre.minibank_api.wallet.transaction.category.dto.TransactionCategoryResponseDto;
import br.com.nobre.minibank_api.wallet.transaction.category.repository.TransactionCategoryRepository;
import br.com.nobre.minibank_api.wallet.transaction.category.model.TransactionCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionCategoryService {

    private final TransactionCategoryRepository categoryRepository;

    public TransactionCategoryService(TransactionCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<TransactionCategory> findAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public TransactionCategoryResponseDto saveCategory(TransactionCategoryRequestDto categoryDto) {
        TransactionCategory category = new TransactionCategory();
        category.setName(categoryDto.name());

        categoryRepository.save(category);
        return new TransactionCategoryResponseDto(category.getId(), category.getName());
    }

}
