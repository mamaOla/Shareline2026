import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    // кратно 3 и 5  возвращать TSM
    // кратно 3 возвращать Т
    // кратно 5 возвращать М

    public String trialCode(int number) {
        if (number % 3 ==0 && number % 5 ==0) {
            return "TSM";
        } else if (number % 5 ==0) {
            return "M";
        } else if (number % 3 ==0) {
            return "T";
        } else return "FAIL";
    }

    @Test
    public void checkTrialNumber() {
    String actualResult = trialCode(9);
    assertEquals  (actualResult, "T");
}

    @Test
    public void checkTrialNumber2() {
        String actualResult = trialCode(25);
        assertEquals  (actualResult, "M");}


    @Test
    public void checkTrialNumber3() {
        String actualResult = trialCode(15);
        assertEquals  (actualResult, "TSM");}

}
