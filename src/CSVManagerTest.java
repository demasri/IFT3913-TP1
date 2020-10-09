import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CSVManagerTest {

	/***
	 * Private Fields
	 */
	private CSVManager manager;
	private CodeAnalyzer analyzer;
	
	/***
	 * Initiation methods pre-testing executions
	 */
	@Before
	public void initTest()
	{
		analyzer = new CodeAnalyzer("files_to_analyze");
		manager = new CSVManager();
	}
	
	// Test Methods
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void updateCSVFile_CreateFileWhenFileExists() {
		// Arrange
		analyzer = new CodeAnalyzer("files_to_analyze");
		manager = new CSVManager();
		
		// Act
		
		// Assert
	}
	
	/***
	 * Test Method 2 : 
	 */
	@Test
	void updateCSVFile_ShouldNotBeSuccessful() {
		// Arrange
		analyzer = new CodeAnalyzer("files_to_analyze");
		manager = new CSVManager();
		// Act
		
		// Assert
	}
	
	

}
