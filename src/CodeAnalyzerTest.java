import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class CodeAnalyzerTest {
	
	/***
	 * Private Fields
	 */
	private CodeAnalyzer analyzer;
	
	/***
	 * Initiation Method before Test Execution
	 */
	@Before
	public void initTest()
	{
		analyzer = new CodeAnalyzer("files_to_analyze");
	}

	// Test Methods:
	

	/***
	 * Test Method 1 : 
	 */
	@Test
	void getMethodes_ShouldBeSuccessful() {
		// Arrange
		
		// Act
		
		// Assert
		fail("Not yet implemented");
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void getMethodes_ShouldNotBeSuccessful() {
		fail("Not yet implemented");
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void methodes_LOC_ShouldBeSuccessful() {
		// Arrange
		String[] testMethod = Arrays.copyOfRange(analyzer.classes[0], 1, 1);
		int expectedLOC = 33;
		
		// Act
		int testLOC = analyzer.methode_LOC(testMethod);
		
		// Assert
		assertEquals(testLOC, expectedLOC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void methodes_LOC_ShouldNotBeSuccessful() {
		// Arrange
		String[] testMethod = Arrays.copyOfRange(analyzer.classes[0], 1, 1);
		int expectedLOC = 30;
		
		// Act
		int testLOC = analyzer.methode_LOC(testMethod);
		
		// Assert
		assertFalse(testLOC == expectedLOC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void methodes_CLOC_ShouldBeSuccessful() {
		// Arrange
		String[] testMethod = Arrays.copyOfRange(analyzer.classes[0], 1, 1);
		int expectedCLOC = 12;
		
		// Act
		int testCLOC = analyzer.methode_CLOC(testMethod);
		
		// Assert
		assertEquals(testCLOC, expectedCLOC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void methodes_CLOC_ShouldNotBeSuccessful() {
		// Arrange
		String[] testMethod = Arrays.copyOfRange(analyzer.classes[0], 1, 1);
		int expectedCLOC = 30;
		
		// Act
		int testCLOC = analyzer.methode_CLOC(testMethod);
		
		// Assert
		assertFalse(testCLOC == expectedCLOC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void methodes_DC_ShouldBeSuccessful() {
		// Arrange
		String[] testMethod = Arrays.copyOfRange(analyzer.classes[0], 1, 1);
		double expectedDC = 0.36363637;
		
		// Act
		double testDC = analyzer.methode_DC(testMethod);
		
		// Assert
		assertEquals(testDC, expectedDC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void methodes_DC_ShouldNotBeSuccessful() {
		// Arrange
		String[] testMethod = Arrays.copyOfRange(analyzer.classes[0], 1, 1);
		double expectedDC = 0.30;
		
		// Act
		double testDC = analyzer.methode_DC(testMethod);
		
		// Assert
		assertFalse(testDC == expectedDC);
    }
    
    	/***
	 * Test Method 1 : 
	 */
	@Test
	void classe_LOC_ShouldBeSuccessful() {
		// Arrange
		String[] testClass = analyzer.classes[0];
		int expectedLOC = 181;
		
		// Act
		int testLOC = analyzer.classe_LOC(testClass);
		
		// Assert
		assertEquals(testLOC, expectedLOC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void classe_LOC_ShouldNotBeSuccessful() {
		// Arrange
		String[] testClass = analyzer.classes[0];
		int expectedLOC = 70;
		
		// Act
		int testLOC = analyzer.classe_LOC(testClass);
		
		// Assert
		assertFalse(testLOC == expectedLOC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void classe_CLOC_ShouldBeSuccessful() {
		// Arrange
		String[] testClass = analyzer.classes[0];
		int expectedCLOC = 78;
		
		// Act
		int testCLOC = analyzer.classe_CLOC(testClass);
		
		// Assert
		assertEquals(testCLOC, expectedCLOC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void classe_CLOC_ShouldNotBeSuccessful() {
		// Arrange
		String[] testClass = analyzer.classes[0];
		int expectedCLOC = 70;
		
		// Act
		int testCLOC = analyzer.classe_CLOC(testClass);
		
		// Assert
		assertFalse(testCLOC == expectedCLOC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void classe_DC_ShouldBeSuccessful() {
		// Arrange
		String[] testClass = analyzer.classes[0];
		double expectedDC = 0.43093923;
		
		// Act
		double testDC = analyzer.classe_DC(testClass);
		
		// Assert
		assertEquals(testDC, expectedDC);
	}
	
	/***
	 * Test Method 1 : 
	 */
	@Test
	void classe_DC_ShouldNotBeSuccessful() {
		// Arrange
		String[] testClass = analyzer.classes[0];
		double expectedDC = 0.4309123;
		
		// Act
		double testDC = analyzer.classe_DC(testClass);
		
		// Assert
		assertFalse(testDC == expectedDC);
	}
	

}