package ir.maktab56.ToDo.service.impl;

import ir.maktab56.ToDo.base.service.impl.BaseServiceImpl;
import ir.maktab56.ToDo.domain.Wallet;
import ir.maktab56.ToDo.repository.impl.WalletRepositoryImpl;
import ir.maktab56.ToDo.service.WalletService;

public class WalletServiceImpl extends BaseServiceImpl<Wallet, Long, WalletRepositoryImpl> implements WalletService {

	public WalletServiceImpl(WalletRepositoryImpl repository) {
		super(repository);
	}

}
