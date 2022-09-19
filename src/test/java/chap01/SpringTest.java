package chap01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpringTest {
    @Test
    void substring(){
        String str = "ABCD";
        Assertions.assertEquals("AB",str.substring(0,2));
    }

}
