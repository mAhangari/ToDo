package ir.maktab56.ToDo.repository.impl;

import javax.persistence.*;
import ir.maktab56.ToDo.base.reposiotry.impl.BaseRepositoryImpl;
import ir.maktab56.ToDo.domain.Wallet;
import ir.maktab56.ToDo.repository.WalletRepository;

public class WalletRepositoryImpl extends BaseRepositoryImpl<Wallet, Long> implements WalletRepository {

	public WalletRepositoryImpl(EntityManagerFactory emf) {
		super(emf);
	}
	
	@Override
	public <T> Wallet findByUserId(T id) {
		EntityManager em = emf.createEntityManager();
		try {
			Wallet wallet = em.createQuery("SELECT w FROM Wallet AS w WHERE w.customer = (SELECT c FROM Customer AS c WHERE c.id =: id)", Wallet.class).setParameter("id", id).getSingleResult();
			return wallet;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public Class<Wallet> getEntityClass() {
		return Wallet.class;
	}
	
}
