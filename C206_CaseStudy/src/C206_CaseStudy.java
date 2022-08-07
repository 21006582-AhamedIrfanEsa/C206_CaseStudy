import java.util.ArrayList;

public class C206_CaseStudy {

	public static ArrayList<Package> packageList = new ArrayList<Package>();
	
	private static final int VIEWING = 1;
	private static final int ADDING = 2;
	private static final int DELETING = 3;
	private static final int QUIT = 4;


	
	public static void main(String[] args) {
		
		ArrayList<RequestQuotation> rQuotationList =    new ArrayList<RequestQuotation>() ;
        rQuotationList.add(new RequestQuotation("HDB",500.00,"John",12345678,"john@gmail.com",10000," 21 Aug 2022","Whole house",2,2,true));
        ArrayList<User> chromebookList = new ArrayList<User>();
		
		
		packageList.add(new Package(101, "Kitchen Package", "2022-11-09", "2022-12-15", 7000.20));
		packageList.add(new Package(102, "Dining Area Package", "2021-04-16", "2021-10-23", 3520.70));
		packageList.add(new Package(103, "Whole Place Package", "2021-06-18", "2021-10-16", 1950.75));
		
		
		
		int option = 0;

		while (option != QUIT) {

			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			switch (option) {
			
			case 1:  //Customer view: Request Quotation, Add appointment		
				customerMenu();
				int customerOption = Helper.readInt("Enter an option > ");
				
				switch (customerOption) {
				case 1:  //Request for quotation
					
					System.out.println("Quotation Requested");
					break;
				case 2: 
				}
				break;
				
				
			case 2:  //Admin view: Add/Delete/View Package, Add/View/Delete Appointment, View/Delete request quotation
				adminMenu();
				int adminOption = Helper.readInt("Enter an option > ");
				
				switch (adminOption) {
				
				case 1:  //Manage Package
					adminPackageOption();					
					break;
				
				
				case 2:  //Manage Quotation Requests
					adminReqQuoOption(rQuotationList);
					break;
					
				}//end of adminOption
				break;

			case 3:  //Designer view: Add/View/Delete quotation, View request quotation
				designQuoOption();
				break;
				
			case QUIT:
				System.out.println("Thank You!!!");
				option = 4;
				break;
				
			default:
				System.out.println("Invalid Option");
				break;		
			}
		}//end of while loop
		
	}//end of method
	
	
	public static void menu() {
		setHeader("RENOVATION ACE");
		System.out.println("1. Enter as a Customer");
		System.out.println("2. Enter as an Admin");
		System.out.println("3. Enter as an Designer");
		System.out.println("4. Quit");
		Helper.line(100, "-");
	}
	
	public static void customerMenu() {
		setHeader("Customer");
		System.out.println("1. Request For Quotation");
		System.out.println("2. Make Appointment");
		System.out.println("3. Quit");
		Helper.line(100, "-");
	}

	
	
	public static void adminMenu() {
		setHeader("Admin");
		System.out.println("1. Manage Package");
		System.out.println("2. Manage Quotation Requests");
		System.out.println("3. Quit");
		Helper.line(100, "-");
	}
	
	
	
	public static void designerMenu() {
		setHeader("Designer");
		System.out.println("1. View Quotation");
		System.out.println("2. Add Quotation");
		System.out.println("3. Delete Quotation");
		System.out.println("4. View Quotation Requests");
		System.out.println("5. Quit");
		Helper.line(100, "-");
	}

	public static void adminPackageMenu() {
		setHeader("Manage Package");
		System.out.println("1. View Package");
		System.out.println("2. Add Package");
		System.out.println("3. Delete Package");
		System.out.println("4. Quit");
		Helper.line(100, "-");
	}
	
	public static void adminReqQuotMenu() {
		setHeader("Manage Quotation Requests");
		System.out.println("1. View quotation request");
		System.out.println("2. Add quotation request");
		System.out.println("3. Delete quotation request");
		System.out.println("4. Quit");
		Helper.line(100, "-");
	}

	
	public static void adminPackageOption(){
		adminPackageMenu();
		int adminPackageOption = Helper.readInt("Enter an option > ");

		switch (adminPackageOption) {
		case VIEWING:
			viewAllPackage(packageList);
			break;
		case ADDING:
			Package userp = inputPackage();
			addPackage(packageList, userp);
			System.out.println("Package added");
			break;
		case DELETING:
			removePackage(packageList);
			break;
		default:
			System.out.println("Invalid input");
		}
	}
	
	public static void adminReqQuoOption(ArrayList<RequestQuotation> rQuotation){
		adminReqQuotMenu();
		int adminReqQuoOption = Helper.readInt("Enter an option > ");		

		switch (adminReqQuoOption) {
		case VIEWING:
		
			viewAllRequestQuotation(rQuotation);
			
			break;
		case 2: //Delete Quotation request
		//	removeRequestQuotation(requestQuotationList);
			break;
		case 3:
			removeRequestQuotation(rQuotationList);
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}

	public static void designQuoOption(){
		designerMenu();
		int desigOption = Helper.readInt("Enter an option > ");		

		switch (desigOption) {
		case VIEWING:
		//	viewAllManageQuotation(manageList);
			break;
		case ADDING:
	//		ManageQuotation userq = inputManageQuotation();
		//	addManageQuotation(manageList, userq);
			System.out.println("Quotation added");
			break;
		case DELETING:
		//	removeManageQuotation(manageList);
			break;
		case 4:
		//	viewAllRequestQuotation(requestQuotationList);
			break;
		case 5:
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}

	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
		
	
	//================================= Manage Package================================
	
	public static boolean findPackageCode(ArrayList<Package> packageList, int x) {
		boolean isExist = false;
		
		for(Package i : packageList) {
			if (x == i.getCode()) {
				isExist = true;
			}
		}
		return isExist;
	}

	public static Package inputPackage() {
		int cd = Helper.readInt("Enter package code > ");
		boolean isFound = findPackageCode(packageList, cd);
		
		while(isFound == true) {
				System.out.println("Package code already exists!");
				cd = Helper.readInt("Enter package code > ");
				isFound = findPackageCode(packageList, cd);
		}

		String description = Helper.readString("Enter description > ");
		String startDate = Helper.readString("Enter start date > ");
		String endDate = Helper.readString("Enter end date > ");
		double amount = Helper.readDouble("Enter amount > ");
		
		Package p = new Package(cd, description, startDate, endDate, amount);
		return p;	
	}
	
	
	
	public static String retrieveAllPackage(ArrayList<Package> packageList) {
		String output = "";

		for (int i = 0; i < packageList.size(); i++) {

			output += String.format("%-74s", packageList.get(i).toString());	
		}
		return output;
	}
	
	
	
	public static void viewAllPackage(ArrayList<Package> packageList) {
		C206_CaseStudy.setHeader("PACKAGE LIST");
		String output = String.format("%-10s %-20s %-15s %-15s %-10s\n", "CODE", "DESCRIPTION",
				"START DATE", "END DATE","AMOUNT");
		 output += retrieveAllPackage(packageList);	
		System.out.println(output);
	}

	public static void addPackage(ArrayList<Package> packageList, Package p) {
		packageList.add(p);
	}
	public static void doRemovePackage(ArrayList<Package> packageList, int x) {
		for(Package i : packageList) {
			if (x == i.getCode()) {
				packageList.remove(i);
			}
		}
	}
	

	public static void removePackage(ArrayList<Package> packageList) {
		int code = Helper.readInt("Enter package code > ");
		boolean isFound = false;
		
		for(int c = 0; c < packageList.size(); c++) {
			if(code == packageList.get(c).getCode()) {
				isFound = true;
				packageList.remove(c);
				System.out.println("Package deleted!");
			}
		
		
	}
		if(isFound == false) {
			System.out.println("Package not deleted");
		}
	}

	
//	========================== Sayed===============


public static RequestQuotation inputRequestQuotation() {
    String PropertyType = Helper.readString("Enter property type - HDB,Private,Landed>");
    Double AreaSize = Helper.readDouble("Enter area size >");
    String RequestorName = Helper.readString("Enter requestor name >");
    int ContactNumber = Helper.readInt("Enter mobile number here >");
    String Email = Helper.readString("Enter email address >");
    Double budget = Helper.readDouble("Enter bugdet >");
    String TCdate = Helper.readString(" Enter target completetion date >");
    String Renotype = Helper.readString("Enter renovation type -Whole house,room,Kitchen,toilet >");
    int NumRooms = Helper.readInt("Enter number of rooms > ");
    int Numtoilets = Helper.readInt("Enter numbr of toilets > ");
    boolean urgent = Helper.readBoolean("Enter urgency -true, false > ");

    RequestQuotation rQ = new RequestQuotation(PropertyType,AreaSize,RequestorName,ContactNumber,Email,budget,TCdate,Renotype,NumRooms,Numtoilets,urgent);
    return rQ;

}

public static void addRequestQuotation(ArrayList<RequestQuotation> rQuotationList, RequestQuotation rQ) {
    // TODO Auto-generated method stub
    rQuotationList.add(rQ);
}


//public static  String retrieveAllRequestQuotation(ArrayList<RequestQuotation> rQuotationList) {
//    // TODO Auto-generated method stub
//    String output = "";
//    for (int i = 0; i < rQuotationList.size(); i++) {
//        output += String.format("%-10s %-30.2f %-30s %-30d %-30s %-30d %-30s %-30s %-30d %-30d %-30b\n" , rQuotationList.get(i).getPropertyType(),rQuotationList.get(i).getAreaSize(),rQuotationList.get(i).getRequestorName(),
//                rQuotationList.get(i).getContactNumber(),rQuotationList.get(i).getEmail(),rQuotationList.get(i).getBudget(),rQuotationList.get(i).getTCdate(),rQuotationList.get(i).getRenoType(),
//                rQuotationList.get(i).getNumRooms(),rQuotationList.get(i).getNumtoilets(),rQuotationList.get(i).getUrgent());
//    }
//    return output;
//}
public static void viewAllRequestQuotation(ArrayList<RequestQuotation> rQuotationList) {

    String output = String.format("%-10s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s %-30s\n", "PROPERTY TYPE", "AREA SIZE","REQUESTOR NAME","CONTACT NUMBER","EMAIL","BUDGET","TARGET COMPLETION DATE"
            ,"RENOVATION TYPE", "NUMBER OF ROOMS","NUMBER OF TOILETS","URGENCY");
    for (int i = 0; i < rQuotationList.size(); i++) {
        output += String.format("%-10s %-30.2f %-30s %-30d %-30s %-30.2f %-30s %-30s %-30d %-30d %-30b\n" , rQuotationList.get(i).getPropertyType(),rQuotationList.get(i).getAreaSize(),rQuotationList.get(i).getRequestorName(),
                rQuotationList.get(i).getContactNumber(),rQuotationList.get(i).getEmail(),rQuotationList.get(i).getBudget(),rQuotationList.get(i).getTCdate(),rQuotationList.get(i).getRenoType(),
                rQuotationList.get(i).getNumRooms(),rQuotationList.get(i).getNumtoilets(),rQuotationList.get(i).getUrgent());
    }
   
    System.out.println(output);

}
public static void doRemoveRequestQuotation(ArrayList<RequestQuotation> rQuotationList, String y) {
    for (int i = 0; i < rQuotationList.size(); i++) {
        if(y == rQuotationList.get(i).getRequestorName()) {
            rQuotationList.remove(i);
        }
    }
}
public static void DeleteRequestQuotation(ArrayList<RequestQuotation> rQuotationList) {
    String RName = Helper.readString("Enter requestor name >");
    boolean isFound = false;

    for (int i = 0; i < rQuotationList.size(); i++) {
        if(RName == rQuotationList.get(i).getRequestorName()) {
            isFound = true;
            rQuotationList.remove(i);
            System.out.println("Request for quotation is deleted");
        }
    }
    if(isFound == false) {
        System.out.println("Request for quotation has not been deleted");
    }
}
}
//=============Ethan-==========
//
///*
//private static final int RETURN = 4;
//private static final int LOAN = 3;
//private static final int ADD = 2;
//private static final int DISPLAY = 1;
///**
// * 
// 
//private static final int QUIT = 5;
//
//public static void main(String[] args) {
//
//	ArrayList<User> chromebookList = new ArrayList<User>();
//
//	ADD_ITEMS(chromebookList);
//
//	int option = 0;
//
//	while (option != QUIT) {
//
//		C206_Ese.menu();
//		option = Helper.readInt("Enter an option > ");
//
//		if (option == DISPLAY) {
//			// View all items
//			;
//			C206_Ese.viewAllChromebook(chromebookList);
//
//		} else if (option == ADD) {
//			// Add a new item
//			C206_Ese.setHeader("ADD");
//			
//			
//
//			int itemType = Helper.readInt("Enter option to select item type > ");
//
//			if (itemType == 1) {
//				// Add Chromebook
//				User cb = inputChromebook();
//				C206_Ese.addChromebook(chromebookList, cb);
//
//			} else if (itemType == 2) {
//
//			} else {
//				System.out.println("Invalid type");
//			}
//
//		} else if (option == LOAN) {
//			// Loan item
//			C206_Ese.setHeader("LOAN");
//			
//
//			int itemType = Helper.readInt("Enter option to select item type > ");
//
//			if (itemType == 1) {
//				// Loan Chromebook
//				C206_Ese.loanChromebook(chromebookList);
//			} else if (itemType == 2) {
//
//			} else {
//				System.out.println("Invalid type");
//			}
//
//		} else if (option == RETURN) {
//			// Return item
//			C206_Ese.setHeader("RETURN");
//
//
//			int itemType = Helper.readInt("Enter option to select item type > ");
//			if (itemType == 1) {
//				// Return Chromebook
//				C206_Ese.returnChromebook(chromebookList);
//			} else if (itemType == 2) {
//
//			} else {
//				System.out.println("Invalid type");
//			}
//
//		} else if (option == QUIT) {
//			System.out.println("Bye!");
//		} else {
//			System.out.println("Invalid option");
//		}
//
//	}
//
//}
//
///**
// *
// * @param chromebookList
// */
//private static void ADD_ITEMS(ArrayList<User> chromebookList) {
//	chromebookList.add(new User("James", "Customer", "James@gamail.com", "1234", "New"));
//	chromebookList.add(new User("Allen", "Customer", "Allen@gamail.com", "1234", "New"));
//	chromebookList.add(new User("Tim", "Customer", "Tim@gamail.com", "1234", "New"));
//	chromebookList.add(new User("Alex", "Admin", "Alex@gamail.com", "1234", "New"));
//}
//
//public static void menu() {
//	C206_Ese.setHeader("RENOVATION ACE");
//	System.out.println("1. Display Users");
//	System.out.println("2. Add User");
//	System.out.println("3. ");
//	System.out.println("4. ");
//	System.out.println("5. Quit");
//	Helper.line(80, "-");
//
//}
//
//public static void setHeader(String header) {
//	Helper.line(80, "-");
//	System.out.println(header);
//	Helper.line(80, "-");
//}
//
//public static String showAvailability(boolean isAvailable) {
//	String avail;
//
//	if (isAvailable == true) {
//		avail = "Yes";
//	} else {
//		avail = "No";
//	}
//	return avail;
//}
//
//// ================================= Option 1 View (CRUD - Read)
//// =================================
//
//public static String retrieveAllChromebook(ArrayList<User> chromebookList) {
//	String output = "";
//	// write your code here
//	for (int i = 0; i < chromebookList.size(); i++) {
//
//		output += String.format("%-20s %-30s %-20s %-20s %-20s\n", chromebookList.get(i).getName(),
//				chromebookList.get(i).getRole(), chromebookList.get(i).getEmail(),
//				chromebookList.get(i).getPassword(), chromebookList.get(i).getStatus());
//	}
//	return output;
//}
//
//public static void viewAllChromebook(ArrayList<User> chromebookList) {
//
//	C206_Ese.setHeader("USER LIST");
//	String output = String.format("%-20s %-30s %-20s %-20s %-20s\n", "NAME", "ROLE", "EMAIL",
//			"PASSWORD", "STATUS");
//	output += retrieveAllChromebook(chromebookList);
//	System.out.println(output);
//}
//
//// ================================= Option 2 Add (CRUD -
//// Create)=================================
//
//public static User inputChromebook() {
//	String name = Helper.readString("Enter name :");
//	String role = Helper.readString("Enter role :");
//	String email = Helper.readString("Enter email :");
//	String password = Helper.readString("Enter password :");
//	String status = Helper.readString("Enter status :");
//
//	User cb = new User(name, role, email, password, status);
//	return cb;
//
//}
//
//public static void addChromebook(ArrayList<User> chromebookList, User cb) {
//
//	chromebookList.add(cb);
//	System.out.println("Chromebook added");
//}
//
//// ================================= Option 3 Loan (CURD- Update)
//// =================================
//
//public static boolean doLoanChromebook(ArrayList<User> chromebookList, String tag, String dueDate) {
//	// write your code here
//	boolean isLoaned = false;
//
//	int CHROMEBOOK_SIZE = chromebookList.size();
//	for (int i = 0; i < CHROMEBOOK_SIZE; i++) {
//		String assetTag = chromebookList.get(i).getName();
//
//	}
//	return isLoaned;
//}
//
//public static void loanChromebook(ArrayList<User> chromebookList) {
//	// write your code here
//	C206_Ese.viewAllChromebook(chromebookList);
//	String tag = Helper.readString("Enter name > ");
//	String due = Helper.readString("Enter due date > ");
//	Boolean isLoaned = doLoanChromebook(chromebookList, tag, due);
//	if (isLoaned == false) {
//		System.out.println("Invalid asset tag");
//	} else {
//		System.out.println("Chromebook " + tag + " loaned out");
//	}
//
//}
//
//// ================================= Option 4 Return (CURD-
//// Update)=================================
//// write your doReturnChromebook code here
//public static boolean doReturnChromebook(ArrayList<User> chromebookList, String tag) {
//	boolean isReturned = false;
//
//	for (int i = 0; i < chromebookList.size(); i++) {
//		if (tag.equalsIgnoreCase(chromebookList.get(i).getName()))
//			;
//
//	}
//	return isReturned;
//
//}
//
//public static void returnChromebook(ArrayList<User> chromebookList) {
//	// write your code here
//	C206_Ese.viewAllChromebook(chromebookList);
//	String tag = Helper.readString("Enter Name > ");
//	Boolean isReturned = doReturnChromebook(chromebookList, tag);
//
//	if (isReturned == false) {
//		System.out.println("Invalid name");
//	} else {
//		System.out.println("Chromebook " + tag + " returned");
//	}
//}
//
//}
//
