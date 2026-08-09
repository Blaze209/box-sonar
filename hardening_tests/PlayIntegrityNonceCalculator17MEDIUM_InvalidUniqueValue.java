package hardening_tests;

import com.box.android.clientadmin.integrity.PlayIntegrityNonceCalculator;

/**
 * Test to demonstrate vulnerable vs fixed behavior for PlayIntegrityNonceCalculator.
 *
 * Expected behavior (fixed):
 * The calculate method should handle invalid non-numeric inputs safely and gracefully,
 * returning an empty string or fallback instead of crashing with a NumberFormatException.
 *
 * Actual behavior (vulnerable):
 * Passing a non-numeric string results in an unhandled NumberFormatException.
 */
public class PlayIntegrityNonceCalculator17MEDIUM_InvalidUniqueValue {
    public static void main(String[] args) {
        PlayIntegrityNonceCalculator calculator = new PlayIntegrityNonceCalculator();
        try {
            String result = calculator.calculate("invalid_input_123");
            if (!"".equals(result)) {
                throw new RuntimeException("Assertion failed: Expected empty string fallback for invalid unique value");
            }
            System.out.println("Test passed successfully on fixed code!");
        } catch (NumberFormatException e) {
            System.err.println("VULNERABLE CODE DETECTED: NumberFormatException thrown!");
            throw e; // Fail the test on vulnerable code
        }
    }
}
