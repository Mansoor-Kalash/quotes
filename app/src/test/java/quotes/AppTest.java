/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void appHasAGreeting() {
        App classUnderTest = new App();
//        assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
//public int vv (){
//   
//
//
//}


@Test public void testreadNdRandom (){
     String s =  "Marilyn Monroe";
     String ts = "I am good, but not an angel. I do sin, but I am not the devil. I am just a small girl in a big world trying to find someone to love.” ";
    Quotes quotes = new Quotes();
    String path = "app/src/main/resources/test.json";
    quotes.read(path);
    quotes.random();


    String ss = quotes.getQuotes()[0].getAuthor();

    assertTrue(s==ss);


}
}