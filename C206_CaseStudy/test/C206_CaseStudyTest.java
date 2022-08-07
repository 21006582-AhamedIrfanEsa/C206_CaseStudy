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


private RequestQuotation RQ1;
private RequestQuotation RQ2;

private ArrayList<RequestQuotation> rQuotationList;

public void C206_CaseStudyTest1() {
    
}

@Before
public void setUp1() throws Exception {
    RQ1 =  new RequestQuotation("HDB",500.00,"John",12345678,"john@gmail.com",10000," 21 Aug 2022","Whole house",2,2,true);
    RQ2 =  new RequestQuotation("Private",700.00,"Chloe",12345679,"Chloe@gmail.com",20000," 22 Aug 2022","Room",1,0,false);
    rQuotationList = new ArrayList<RequestQuotation>();
}

@Test
public void testAddRequestQuotation () {
assertNotNull("Test if there is valid RequestQuotation arraylist to add to", rQuotationList);

C206_CaseStudy.addRequestQuotation(rQuotationList, RQ1);        
assertEquals("Test if that RequestQuotation arraylist size is 1?", 1, rQuotationList.size());
assertSame("Test that RequestQuotation is added same as 1st item of the list?", RQ1, rQuotationList.get(0));

C206_CaseStudy.addRequestQuotation(rQuotationList, RQ2);
assertEquals("Test that RequestQuotation arraylist size is 2?", 2, rQuotationList.size());
assertSame("Test that RequestQuotation is added same as 2nd item of the list?", RQ2, rQuotationList.get(1));
}

public void testViewAllRequestQuotation() {
assertNotNull("Test if there is valid RequestQuotation arraylist to add to", rQuotationList);

String allRequestQuotation= C206_CaseStudy.DeleteRequestQuotation(rQuotationList);
String testOutput = "";
assertEquals("Check that ViewAllrQuotationlist", testOutput, allRequestQuotation);

C206_CaseStudy.addRequestQuotation(rQuotationList,RQ1);
C206_CaseStudy.addRequestQuotation(rQuotationList,RQ2);
assertEquals("Test that RequestQuotation arraylist size is 2?", 2, rQuotationList.size());

allRequestQuotation = C206_CaseStudy.DeleteRequestQuotation(rQuotationList);

testOutput += String.format("%-10s %-30.2f %-30s %-30d %-30s %-30d %-30s %-30s %-30d %-30d %-30b\n ","HDB",500.00,"John",12345678,"john@gmail.com",10000," 21 Aug 2022","Whole house",2,2,true);
testOutput += String.format("%-10s %-30.2f %-30s %-30d %-30s %-30d %-30s %-30s %-30d %-30d %-30b\n ","Private",700.00,"Chloe",12345679,"Chloe@gmail.com",20000," 22 Aug 2022","Room",1,0,false);
assertEquals("Check that ViewAllRequestQuotation",allRequestQuotation,testOutput);





}


public void testDeleteRequestQuotation() {
assertNotNull("Test if there is valid RequestQuotation arraylist to add to", rQuotationList);

C206_CaseStudy.addRequestQuotation(rQuotationList,RQ1);
C206_CaseStudy.addRequestQuotation(rQuotationList,RQ2);

assertEquals(2,rQuotationList.size());
rQuotationList.remove(0);
assertEquals(1,rQuotationList.size());
rQuotationList.remove(0);

assertTrue(rQuotationList.isEmpty());


}
@After
public void tearDown() throws Exception {
    RQ1 = null;
    RQ2 = null; 
    rQuotationList = null;
}

}