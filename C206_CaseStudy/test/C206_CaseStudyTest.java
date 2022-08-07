import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest { 
	private Package p1;
	private Package p2;
	private static ArrayList<Package> packageList;
	 
	

	
	public C206_CaseStudyTest() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		p1 = new Package(001, "Package1", "2020-09-04", "2021-01-15", 5000.20);
		p2 = new Package(002, "Package2", "2021-04-16", "2021-10-23", 6540.90);
		packageList= new ArrayList<Package>();
		
	
	}

	
	
	
    //Package 

	@Test
	public void testRetrieveAllPackage() {
		
		assertNotNull("Test if there is valid Package arraylist to retrieve item", packageList);
	
		String allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		String testOutput = "";
		assertEquals("Check that ViewAllPackagelist", testOutput, allPackage);
		
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Test that Package array list size is 2", 2, packageList.size());
		
		allPackage= C206_CaseStudy.retrieveAllPackage(packageList);
		testOutput = String.format("%-10d %-20s %-15s %-15s %-10.1f\n", 001, "Package1", "2020-09-04", "2021-01-15", 5000.20);
		testOutput += String.format("%-10d %-20s %-15s %-15s %-10.1f\n", 002, "Package2", "2021-04-16", "2021-10-23", 6540.90);
	
		assertEquals("Test that ViewAllPackagelist", testOutput, allPackage);
	}

	@Test
	public void testAddPackage() {
		assertNotNull("Check if there is valid Package arraylist to add to", packageList);
		
		C206_CaseStudy.addPackage(packageList, p1);
		assertEquals("Check that Package size of the arrayList is 1", 1, packageList.size());
		assertSame("Check that Package is added", p1, packageList.get(0));
		
		C206_CaseStudy.addPackage(packageList, p2);
		assertEquals("Check that Package size of the arrayList is 2", 2, packageList.size());
		assertSame("Check that Package is added", p2, packageList.get(1));
	}
		
	@Test
	public void testRemovePackage() {
		assertNotNull("Test if there is valid Package arraylist to retrieve item", packageList);
		
		
		C206_CaseStudy.addPackage(packageList, p1);
		C206_CaseStudy.addPackage(packageList, p2);

	
		boolean test = C206_CaseStudy.findPackageCode(packageList, p1.getCode());
		assertTrue("Check package exists in Package List", test);
		
		
		C206_CaseStudy.doRemovePackage(packageList, p1.getCode());
		assertEquals("Check that Package arraylist size is 1", 1, packageList.size());		
	}


	@Test
	public void c206_test() {
		
		assertTrue("C206_CaseStudy_SampleTest ",true);
	}

}
