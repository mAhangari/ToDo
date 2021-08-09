package ir.maktab56.ToDo.domain;

import javax.persistence.*;

import ir.maktab56.ToDo.base.domain.BaseEntity;

@Entity
@Table(name = "wallet")
public class Wallet extends BaseEntity<Long> {
	
	@OneToOne
	@JoinColumn(name = "customer_id", unique = true, nullable = false)
    private Customer customer;
	
	@Column(name = "total_amount")
    private Long totalAmount = 0L;
	
	@Column(name = "credit_amount")
    private Long creditAmount = 0L;
	
	@Column(name = "cach_amount")
    private Long cashAmount = 0L;

    public Wallet(Long id, boolean isDeleted, Long totalAmount, Long creditAmount, Long cashAmount) {
		super(id, isDeleted);
		this.setTotalAmount(totalAmount);
		this.setCreditAmount(creditAmount);
		this.setCashAmount(cashAmount);
	}

	public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Long totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Long getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Long creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Long getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(Long cashAmount) {
        this.cashAmount = cashAmount;
    }
}
