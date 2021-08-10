package ir.maktab56.ToDo.repository;

import java.util.Collection;
import java.util.List;

import ir.maktab56.ToDo.base.reposiotry.BaseRepository;
import ir.maktab56.ToDo.domain.Activity;

public interface ActivityRepository extends BaseRepository<Activity, Long>  {

	<T> List<Activity> findByUserId(T id);

	void saveAll(Collection<Activity> activities);

	void updateAll(Collection<Activity> activities);

}
