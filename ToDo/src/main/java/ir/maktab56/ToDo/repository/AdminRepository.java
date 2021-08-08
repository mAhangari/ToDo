package ir.maktab56.ToDo.repository;

import ir.maktab56.ToDo.base.reposiotry.BaseRepository;
import ir.maktab56.ToDo.domain.Admin;

public interface AdminRepository extends BaseRepository<Admin, Long> {

	<T> boolean checkUsername(T username);

	<UT, PT> boolean checkAdminInfo(UT username, PT password);

	<T> Admin findByUsername(T username);

}
