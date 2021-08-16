package ir.maktab56.ToDo.service.impl;

import java.util.InputMismatchException;
import java.util.Scanner;
import ir.maktab56.ToDo.base.service.impl.BaseServiceImpl;
import ir.maktab56.ToDo.domain.Wallet;
import ir.maktab56.ToDo.repository.impl.WalletRepositoryImpl;
import ir.maktab56.ToDo.service.WalletService;
import ir.maktab56.ToDo.util.ApplicationContext;

public class WalletServiceImpl extends BaseServiceImpl<Wallet, Long, WalletRepositoryImpl> implements WalletService {
	
	Scanner input = new Scanner(System.in);
	
	public WalletServiceImpl(WalletRepositoryImpl repository) {
		super(repository);
	}

	public void changeCash(Wallet wallet) {
		try {
			System.out.print("       Insert Value: ");
			wallet.setCashAmount(input.nextLong());
			save(wallet);
			System.out.println("    +-----------------------------+");
			System.out.printf("%5s     %10s%5s\n", "|", "Operation Successed.", "|");
			System.out.println("    +-----------------------------+");
			
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("    +-------------------------------------+");
			System.out.printf("%5s     %-30s%3s\n", "|", "Please Insert a Right Number!", "|");
			System.out.println("    +-------------------------------------+");
			changeCash(wallet);
		}
	}
	
	public void showCash(Long id) {
		Wallet wallet = ApplicationContext.walletRepo.findByUserId(id);
		System.out.println("    +-----------------------------+");
		System.out.printf("%5s     %-22s%3s\n", "|", "Your Cash Amount is:", "|");
		System.out.printf("%5s     %10d%16s\n", "|", wallet.getCashAmount(), "|");
		System.out.println("    +-----------------------------+");
	}
	
}
