import org.example.PhoneBook;
import org.junit.jupiter.api.*;

public class PhoneBookTest {
    private PhoneBook phoneBook;

    @BeforeEach
    void initiation(){
        phoneBook = new PhoneBook();
    }
    @Test
    void testAdd() {
        String name1 = "John";
        String phone1 = "900889512";
        String name2 = "Jack";
        String phone2 = "900889513";

        phoneBook.add(name1, phone1);
        Assertions.assertEquals(2,phoneBook.add(name2,phone2));

    }
}
