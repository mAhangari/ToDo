package ir.maktab56.ToDo.service.impl;

import ir.maktab56.ToDo.base.service.impl.BaseServiceImpl;
import ir.maktab56.ToDo.domain.Activity;
import ir.maktab56.ToDo.repository.impl.ActivityRepositoryImpl;
import ir.maktab56.ToDo.service.ActivityService;

public class ActivityServiceImpl extends BaseServiceImpl<Activity, Long, ActivityRepositoryImpl> implements ActivityService {

	public ActivityServiceImpl(ActivityRepositoryImpl repository) {
		super(repository);
	}

}
