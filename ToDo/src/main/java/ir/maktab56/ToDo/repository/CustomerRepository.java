package ir.maktab56.ToDo.repository;

import ir.maktab56.ToDo.base.reposiotry.BaseRepository;
import ir.maktab56.ToDo.domain.Customer;

public interface CustomerRepository extends BaseRepository<Customer, Long> {

	Class<Customer> getEntityClass();
	
	<T> boolean checkUsername(T username);

	<UT, PT> boolean checkCustomerInfo(UT username, PT password);
	
	<T> Customer findByUsername(T username);

}
