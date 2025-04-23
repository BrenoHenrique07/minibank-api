package br.com.nobre.minibank_api.wallet.transaction.category.repository;

import br.com.nobre.minibank_api.wallet.transaction.category.model.TransactionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionCategoryRepository extends JpaRepository<TransactionCategory, Integer> {
}
