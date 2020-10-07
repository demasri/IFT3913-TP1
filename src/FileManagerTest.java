import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class FileManagerTest {
	
	// Private Fields
	private FileManager fileManager;
	
	/***
	 * Initialising Method for the Test Cases
	 */
	@Before
	public void initTest() 
	{
		fileManager = new FileManager("/home/daniel/Desktop/University/AUT20/IFT3913/IFT3913-TP1/src/files_to_analyze/");
	}
	
	// Test Case Methods

	/***
	 * Test Method 1 : 
	 */
	@Test
	void getClassesArray_ShouldBeSuccessful() 
	{
		// Arrange
		int expectedNumberOfClasses =  0;
		
		// Act
		
		// Assert
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void getClassesArray_ShouldNotBeSuccessful() 
	{
		// Arrange
		
		// Act
		
		// Assert
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void getClassNamesArray_ShouldBeSuccessful() 
	{
		// Arrange
		
		// Act
		
		// Assert
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void getClassNamesArray_ShouldNotBeSuccessful() 
	{
		// Arrange
		
		// Act
		
		// Assert
	}

}
