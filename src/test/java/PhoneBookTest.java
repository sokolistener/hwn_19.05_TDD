import org.example.PhoneBook;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

public class PhoneBookTest {
    private PhoneBook phoneBook;
    private final PrintStream standardOut = System.out;

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
    @ParameterizedTest
    @MethodSource("sourceForFindByNumber")
    void testFindByNumber(String searchingNumber, String expectedName) {
        String name1 = "John";
        String phone1 = "900889512";
        String name2 = "Jack";
        String phone2 = "900889513";

        phoneBook.add(name1, phone1);
        phoneBook.add(name2,phone2);
        Assertions.assertEquals(expectedName,phoneBook.findByNumber(searchingNumber));
    }

    private static Stream<Arguments> sourceForFindByNumber() {
        return Stream.of(Arguments.of("900889512", "John"),
                Arguments.of("900889513", "Jack"));
    }

    @ParameterizedTest
    @MethodSource("sourceForFindByName")
    void testFindByName(String searchingName, String expectedNumber) {
        String name1 = "John";
        String phone1 = "900889512";
        String name2 = "Jack";
        String phone2 = "900889513";

        phoneBook.add(name1, phone1);
        phoneBook.add(name2,phone2);
        Assertions.assertEquals(expectedNumber,phoneBook.findByName(searchingName));
    }

    private static Stream<Arguments> sourceForFindByName() {
        return Stream.of(Arguments.of("John", "900889512"),
                Arguments.of("Jack", "900889513" ));
    }

    @Test
    void testPrintAllNames(){
        String name1 = "John";
        String phone1 = "900889512";
        String name2 = "Jack";
        String phone2 = "900889513";
        String name3 = "James";
        String phone3 = "900889514";

        phoneBook.add(name1, phone1);
        phoneBook.add(name2, phone2);
        phoneBook.add(name3, phone3);

        String expectedString = "Jack\nJames\nJohn";
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        phoneBook.printAllNames();
        System.setOut(standardOut);

        Assertions.assertEquals(expectedString, outputStreamCaptor.toString().trim());
    }

}
