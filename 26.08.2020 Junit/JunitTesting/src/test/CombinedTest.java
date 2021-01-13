package test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({UserTest.class,CalculatorTest.class})
public class CombinedTest
{
	@BeforeClass
	public static void m1()
	{
		System.out.println("before class in suite class");
	}
	
	@AfterClass
	public static void m2()
	{
		System.out.println("after class in suite class");
	}
}
