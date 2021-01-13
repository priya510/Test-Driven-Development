package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import daoimpl.UserDAOImpl;
import model.User;

public class UserTest 
{
	/*
	  	Junit Methods:
	  	
	  		1) assertEquals()
	  		2) assertNotEquals()
	  		3) assertNull()
	  		4) assertNotNull()
	  		5) assertTrue()
	  		6) assertFalse()
	  		7) assertSame()
	  		8) assertNotSame()
	  		
	  	Annotations:
	  	
	  		1) @Test
	  		2) @Ignore
	  		3) @Before
	  		4) @After
	  		5) @BeforeClass
	  		6) @AfterClass
	  		
	  	@Before annotated method
	  	executes before each test case.
	  	
	  	@After annotated method
	  	executes after each test case.
	  	
	  	Rules for creating @AfterClass & @BeforeClass methods:
	  		1) Method should be static
	  		2) These methods cannot take any value in parameter
	  		3) These methods cannot return any value.
	  		4) These methods are always public.
	*/
	
	UserDAOImpl userDAOImpl =new UserDAOImpl();
	
	@BeforeClass
	public static void beforeClass()
	{
		System.out.println("Before Class.....");
	}
	
	@AfterClass
	public static void AfterClass()
	{
		System.out.println("After Class.....");
	}
	
	
	@Before
	public void setUp1()
	{
		System.out.println("Before Method 1.....");
	}
	
	@After
	public void tearDown1()
	{
		System.out.println("After Method 1.....");
	}
	
	@Test
	@Ignore
	public void addUser()
	{
		User u=new User();
		u.setUsername("Sameer123");
		u.setEmail("sameer@gmail.com");
		u.setPassword("pass@123");
		
		//1st parameter - error message
		//2nd parameter - expected
		//3rd parameter - actual value
		assertEquals("data is not added",true,userDAOImpl.addUser(u));
	}
	
	@Test
	@Ignore
	public void deleteUser()
	{
		assertTrue(userDAOImpl.deleteUser("Sameer123"));
	}
	
	@Test
	@Ignore
	public void updateUser()
	{
		User u=new User();
		u.setUsername("Sameer123");
		u.setEmail("sameer123@gmail.com");
		u.setPassword("pass@1234");
		
		assertEquals(true,userDAOImpl.updateUser(u));
	}
	
	@Test
	public void displayUser()
	{
		System.out.println("display user test case");
		//assertNotEquals(null,userDAOImpl.displayUser("Sameer123"));
		//assertNotNull(userDAOImpl.displayUser("Sameer123"));
		assertNull(userDAOImpl.displayUser("Prabhas123"));
	}
	
	@Test
	public void test2()
	{
		System.out.println("test module");
	}
	
	@Test
	public void checksameornot()
	{
		//User u1=new User();
		//User u2=u1;
		
		//assertSame(u1, u2);
		
		User u1=new User();
		Scanner sc=new Scanner(System.in);
	
		assertSame("they are not same",u1, sc);
	}
	
}
