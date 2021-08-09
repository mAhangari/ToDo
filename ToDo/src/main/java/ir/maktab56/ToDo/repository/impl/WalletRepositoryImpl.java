package ir.maktab56.ToDo.repository.impl;

import java.util.*;
import javax.persistence.*;
import ir.maktab56.ToDo.base.reposiotry.impl.BaseRepositoryImpl;
import ir.maktab56.ToDo.domain.Wallet;
import ir.maktab56.ToDo.repository.WalletRepository;

public class WalletRepositoryImpl extends BaseRepositoryImpl<Wallet, Long> implements WalletRepository {

	public WalletRepositoryImpl(EntityManagerFactory emf) {
		super(emf);
	}

	@Override
	public void save(Wallet wallet) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.persist(wallet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void update(Wallet wallet) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			em.merge(wallet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public List<Wallet> findAllById(Collection<Long> ids) {
		EntityManager en = emf.createEntityManager();
		try {
			List<Wallet> wallets = new ArrayList<>();
			for(Long id: ids) {
				wallets.add(findById(id));
			}
			return wallets;
		}catch(NoResultException e) {
			return null;
		}finally {
			en.close();
		}
	}

	@Override
	public List<Wallet> findAll() {
		EntityManager em = emf.createEntityManager();
		try{
			List<Wallet> wallets = em.createQuery("SELECT * FROM Wallet", Wallet.class).getResultList();
			return wallets;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}

	@Override
	public void deleteById(Long id) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			Wallet wallet = em.find(Wallet.class, id);
			em.remove(wallet);
		em.getTransaction().commit();
		em.close();
	}

	@Override
	public Wallet findById(Long id) {
		EntityManager em = emf.createEntityManager();
		Wallet wallet = em.find(Wallet.class, id);
		em.close();
		return wallet;
	}

	@Override
	public Boolean existsById(Long id) {
		EntityManager em = emf.createEntityManager();
		if(em.find(Wallet.class, id) != null) {
			em.close();
			return true;
		}
		em.close();
		return false;
	}
	
	@Override
	public <T> Wallet findByUserId(T id) {
		EntityManager em = emf.createEntityManager();
		try {
			Wallet wallet = em.createQuery("SELECT w FROM Wallet AS w WHERE w.customer_id =: customer_id", Wallet.class).setParameter("customer_id", id).getSingleResult();
			return wallet;
		}catch(NoResultException e) {
			return null;
		}finally {
			em.close();
		}
	}
}
