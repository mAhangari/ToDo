package ir.maktab56.ToDo.service.impl;

import java.util.*;
import ir.maktab56.ToDo.base.service.impl.BaseServiceImpl;
import ir.maktab56.ToDo.domain.Admin;
import ir.maktab56.ToDo.repository.impl.AdminRepositoryImpl;
import ir.maktab56.ToDo.service.AdminService;

public class AdminServiceImpl extends BaseServiceImpl<Admin, Long, AdminRepositoryImpl> implements AdminService {
	
	public List<Admin> admins = new ArrayList<>();
	
	public AdminServiceImpl(AdminRepositoryImpl repository) {
		super(repository);
	}

}
