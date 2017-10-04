import static org.junit.Assert.*;
import org.mockito.*;
import org.junit.*;
import java.util.ArrayList;

public class RentACatTest {

    // Re-usable RentACat reference.
    RentACat _1;
	Cat mockCat;

    // Create a new RentACat instance and mock Cat object before each test.
    @Before
    public void setup() {
		_1 = new RentACat();
		mockCat = Mockito.mock(Cat.class);
    }
    
	//test that returnCat returns false if the Cat object hasn't been rented yet
    @Test
	public void testReturnNotRentedCat() {
		Mockito.when(mockCat.getRented()).thenReturn(false);
		assertFalse(_1.returnCat(mockCat));
	}
	
	//test that rentCat returns true if the Cat object hasn't been rented yet
	@Test
	public void testRentNotRentedCat() {
		Mockito.when(mockCat.getRented()).thenReturn(false);
		assertTrue(_1.rentCat(mockCat));
	}
	
	//test that listCats returns an empty string if the arraylist is null
	@Test
	public void testListNullArray() {
		ArrayList<Cat> al = null;
		assertEquals("", _1.listCats(al));
	}
	
	//test that listCats returns an empty string if the arraylist only contains rented out cats
	@Test
	public void testListAllRented() {
		Mockito.when(mockCat.getRented()).thenReturn(true);
		ArrayList<Cat> al = new ArrayList<Cat>();
		al.add(mockCat);
		assertEquals("", _1.listCats(al));
	}
	
	//test that catExists returns false if the arraylist is null
	@Test
	public void testExistsNullArray() {
		ArrayList<Cat> al = null;
		assertFalse(_1.catExists(1, al));
	}
	
	//test that catExists returns false if no cat in the arraylist matches the ID
	@Test
	public void testExistsNoID() {
		Mockito.when(mockCat.getId()).thenReturn(2);
		ArrayList<Cat> al = new ArrayList<Cat>();
		al.add(mockCat);
		assertFalse(_1.catExists(1, al));
	}
}
