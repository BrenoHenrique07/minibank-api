package br.com.nobre.minibank_api.wallet.transaction.category.repository;

import br.com.nobre.minibank_api.wallet.transaction.category.model.TransactionCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Integer> {
    Page<TransactionCategory> findAllByActiveTrue(Pageable pageable);
    Optional<TransactionCategory> findByIdAndActiveTrue(Integer id);
}
