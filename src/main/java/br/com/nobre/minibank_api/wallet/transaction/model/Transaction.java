package br.com.nobre.minibank_api.wallet.transaction.model;

import br.com.nobre.minibank_api.wallet.model.Wallet;
import br.com.nobre.minibank_api.wallet.transaction.category.model.TransactionCategory;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transaction")
public class Transaction {

    private Integer id;
    private Wallet wallet;
    private TransactionCategory category;
    private BigDecimal cash;
    private Boolean isIncome;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id", referencedColumnName = "id")
    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    public TransactionCategory getCategory() {
        return category;
    }

    public void setCategory(TransactionCategory category) {
        this.category = category;
    }

    @Column(name = "cash")
    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    @Column(name = "is_income")
    public Boolean getIncome() {
        return isIncome;
    }

    public void setIncome(Boolean income) {
        isIncome = income;
    }
}
