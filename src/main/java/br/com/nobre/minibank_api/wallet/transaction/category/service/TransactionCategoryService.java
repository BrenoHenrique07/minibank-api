package br.com.nobre.minibank_api.wallet.transaction.category.service;

import br.com.nobre.minibank_api.commons.exception.NotFoundException;
import br.com.nobre.minibank_api.wallet.transaction.category.dto.TransactionCategoryRequestDto;
import br.com.nobre.minibank_api.wallet.transaction.category.dto.TransactionCategoryResponseDto;
import br.com.nobre.minibank_api.wallet.transaction.category.repository.TransactionCategoryRepository;
import br.com.nobre.minibank_api.wallet.transaction.category.model.TransactionCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionCategoryService {

    private final TransactionCategoryRepository categoryRepository;

    public TransactionCategoryService(TransactionCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<TransactionCategoryResponseDto> findAllCategories(Pageable pageable) {
        Page<TransactionCategory> categories =  categoryRepository.findAllByActiveTrue(pageable);
        return categories.map(category -> new TransactionCategoryResponseDto(category.getId(), category.getName()));
    }

    public TransactionCategoryResponseDto saveCategory(TransactionCategoryRequestDto categoryDto) {
        TransactionCategory category = new TransactionCategory();
        category.setName(categoryDto.name());

        categoryRepository.save(category);
        return new TransactionCategoryResponseDto(category.getId(), category.getName());
    }

    public TransactionCategoryResponseDto updateCategory(Integer categoryId, TransactionCategoryRequestDto categoryDto) throws NotFoundException {
        Optional<TransactionCategory> category = categoryRepository.findByIdAndActiveTrue(categoryId);

        if(category.isEmpty()) {
            throw new NotFoundException(String.format("Categoria com id %d não existe ou está inativada", categoryId));
        }

        TransactionCategory categoryUpdated = category.get();
        categoryUpdated.setName(categoryDto.name());

        categoryRepository.save(categoryUpdated);
        return new TransactionCategoryResponseDto(categoryUpdated.getId(), categoryUpdated.getName());
    }

    public void deleteCategory(Integer categoryId) throws NotFoundException {
        Optional<TransactionCategory> category = categoryRepository.findByIdAndActiveTrue(categoryId);

        if(category.isEmpty()) {
            throw new NotFoundException(String.format("Categoria com id %d não existe ou está inativada", categoryId));
        }

        TransactionCategory categoryInactivated = category.get();
        categoryInactivated.setActive(false);

        categoryRepository.save(categoryInactivated);

    }

}
