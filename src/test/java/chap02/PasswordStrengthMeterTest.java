package chap02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * =======암호 검사기=========
 * 1. 길이가 8글자 이상이어야 한다.
 * 2. 0부터 9사이의 숫자를 포함해야한다.
 * 3. 대문자를 포함해야한다.
 * ----
 * 3가지 규칙을 모두 충족하면 '강함'
 * 2가지 규칙을 충족하면 '보통'
 * 1가지 규칙을 충족하면 '약함'
 */
public class PasswordStrengthMeterTest {

    private PasswordStrengthMeter meter = new PasswordStrengthMeter();

    private void assertStrength(String password, PasswordStrength expStr) {
        PasswordStrength result2 = meter.meter(password);
        assertEquals(expStr,result2);
    }

    @Test
    void metersAllCriteria_Then_Strong() {
        assertStrength("ab12!@AB", PasswordStrength.STRONG);
        assertStrength("abc1!Add", PasswordStrength.STRONG);
    }

    @Test
    void meetsOtherCriteria_except_for_Length_Then_Normal() {
        assertStrength("ab12!@A", PasswordStrength.NORMAL);
        assertStrength("Ab12!c", PasswordStrength.NORMAL);
    }

    @Test
    void meetsOtherCriteria_except_for_number_Then_Normal() {
        assertStrength("ab!@AZ", PasswordStrength.NORMAL);
    }

    @Test
    void nullInput_Then_Invalid() {
        assertStrength(null,PasswordStrength.INVALID);
    }
    @Test
    void emptyInput_Then_Invalid() {
        assertStrength("",PasswordStrength.INVALID);
    }

    @Test
    void meets_OtherCriteria_except_for_Uppercase_Then_Normal() {
        assertStrength("ab12!@df",PasswordStrength.NORMAL);
    }

    @Test
    void meetsOnlyLengthCriteria_Then_Weak() {
        assertStrength("abdefghi", PasswordStrength.WEAK);
    }
}

