package br.com.nobre.minibank_api.wallet.transaction.category.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transaction_category")
public class TransactionCategory {

    private Integer id;
    private String name;
    private boolean isActive;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_active")
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
