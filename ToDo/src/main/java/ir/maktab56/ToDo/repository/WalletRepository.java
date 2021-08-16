package ir.maktab56.ToDo.repository;

import ir.maktab56.ToDo.base.reposiotry.BaseRepository;
import ir.maktab56.ToDo.domain.Wallet;

public interface WalletRepository extends BaseRepository<Wallet, Long> {

	Class<Wallet> getEntityClass();
	
	<T> Wallet findByUserId(T id);

}
