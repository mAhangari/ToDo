package ir.maktab56.ToDo.service.impl;

import java.util.*;
import ir.maktab56.ToDo.base.service.impl.BaseServiceImpl;
import ir.maktab56.ToDo.domain.*;
import ir.maktab56.ToDo.domain.enumeration.State;
import ir.maktab56.ToDo.repository.impl.ActivityRepositoryImpl;
import ir.maktab56.ToDo.service.ActivityService;
import ir.maktab56.ToDo.util.ApplicationContext;

public class ActivityServiceImpl extends BaseServiceImpl<Activity, Long, ActivityRepositoryImpl> implements ActivityService {
	
	private Scanner input = new Scanner(System.in);
	public ActivityServiceImpl(ActivityRepositoryImpl repository) {
		super(repository);
	}

	public void addActivity(Customer customer, State state, String title) {
		Activity activity = new Activity(false, state, title, new Date());
		activity.setCustomer(customer);
		save(activity);
		System.out.println("    +-----------------------------+");
		System.out.printf("%5s     %10s%5s\n", "|", "Operation Successed.", "|");
		System.out.println("    +-----------------------------+");
	}

	public boolean showCustomerActivity(Long cId, Comparator<Activity> comparator) {
		List<Activity> activities = ApplicationContext.activityRepo.findByUserId(cId);
		activities.sort(comparator);
		if(activities.isEmpty())
			return false;
		String str = "    +---------------------------------------------------------------------+\n" +
					 "    |  ID  |      Title       |       Create Date         |     State     |\n" +
      	 	 	 	 "    +---------------------------------------------------------------------+";
		System.out.print(str);
		for(Activity activity: activities) {
			System.out.print(activity);
		}
		System.out.println();
		return true;
	}
	
	public Comparator<Activity> sorting() {
		try {
			System.out.println("    +---------- Sorting ----------+");
			System.out.printf("%5s     %-22s%3s\n", "|", "1. Sort with Title", "|");
			System.out.printf("%5s     %-22s%3s\n", "|", "2. Sort with Date", "|");
			System.out.println("    +-----------------------------+");
			System.out.print("       Select an Option: ");
			
			switch(input.nextInt()) {
			
			case 1:
				return sortingMode(1);
			case 2:
				return sortingMode(2);
			default:
				System.out.println("    +--------------------------------+");
				System.out.printf("%5s     %-25s%3s\n", "|", "Your Number Was Wrong!!", "|");
				System.out.println("    +--------------------------------+");
				sorting();
			}
			
			
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("    +-------------------------------------+");
			System.out.printf("%5s     %-30s%3s\n", "|", "Please Insert a Right Number!", "|");
			System.out.println("    +-------------------------------------+");
			sorting();
		}
		return null;
	}
	
	private Comparator<Activity> sortingMode(int sort) {
		Comparator<Activity> comparator;
		try {
			if(sort == 1)
				comparator = new Comparator<Activity>() {
				@Override
				public int compare(Activity o1, Activity o2) {
					return o1.getTitle().compareTo(o2.getTitle());
				}
			};
			else
				comparator = new Comparator<Activity>() {
				@Override
				public int compare(Activity o1, Activity o2) {
					return o1.getDate().compareTo(o2.getDate());
				}
			};
			
			System.out.println("    +---------- Sorting ----------+");
			System.out.printf("%5s     %-22s%3s\n", "|", "1. Increase Mode", "|");
			System.out.printf("%5s     %-22s%3s\n", "|", "2. Decrease Mode", "|");
			System.out.println("    +-----------------------------+");
			System.out.print("       Select an Option: ");
			
			switch(input.nextInt()) {
			
			case 1:
				return comparator;
			case 2:
				return comparator.reversed();
			default:
				System.out.println("    +--------------------------------+");
				System.out.printf("%5s     %-25s%3s\n", "|", "Your Number Was Wrong!!", "|");
				System.out.println("    +--------------------------------+");
				sortingMode(sort);
			}
	
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("    +-------------------------------------+");
			System.out.printf("%5s     %-30s%3s\n", "|", "Please Insert a Right Number!", "|");
			System.out.println("    +-------------------------------------+");
			sortingMode(sort);
		}
		return null;
	}

	public void showAdminActivity(Admin admin) {
		String str = "    +----------------------------------------------------------------------+\n" +
      	 	 	 "    |  ID  |      Title       |        Create Date         |     State     |\n" +
      	 	 	 "    +----------------------------------------------------------------------+";
		System.out.println(str);
		
	}

	public void changeState(Customer customer) {
		try {
			System.out.print("       Enter Activity ID: ");
			var id = input.nextLong();
			System.out.println("    +------ Stete Of Activity ------+");
			System.out.printf("%5s     %-24s%3s\n", "|", "1. Open an Activity", "|");
			System.out.printf("%5s     %-24s%3s\n", "|", "2. Activity In Progress", "|");
			System.out.printf("%5s     %-24s%3s\n", "|", "3. Activity Completed", "|");
			System.out.println("    +-------------------------------+");
			System.out.print("       Select an Option: ");
			State state = null;
			switch(input.nextInt()) {
			
			case 1:
				state = State.OPEN;
				break;
			case 2:
				state = State.IN_PROGRESS;
				break;
			case 3:
				state = State.COMPLETED;
				break;
			default:
				System.out.println("    +--------------------------------+");
				System.out.printf("%5s     %-25s%3s\n", "|", "Your Number Was Wrong!!", "|");
				System.out.println("    +--------------------------------+");
				changeState(customer);
			}
			Activity activity = findById(id);
			if(activity != null) {
				activity.setState(state);
				save(activity);
				System.out.println("    +-----------------------------+");
				System.out.printf("%5s     %10s%5s\n", "|", "Operation Successed.", "|");
				System.out.println("    +-----------------------------+");
			}
			else {
				System.out.println("    +--------------------------------+");
				System.out.printf("%5s     %-25s%3s\n", "|", "ID is Wrong!!!", "|");
				System.out.println("    +--------------------------------+");
				changeState(customer);
			}
			
		}catch(InputMismatchException e) {
			input.nextLine();
			System.out.println("    +-------------------------------------+");
			System.out.printf("%5s     %-30s%3s\n", "|", "Please Insert a Right Number!", "|");
			System.out.println("    +-------------------------------------+");
			changeState(customer);
		}
	}

}
