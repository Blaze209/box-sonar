package hardening_tests;

import java.io.InputStream;
import defpackage.IntuneNonceCalculator;

/**
 * Test to demonstrate vulnerable vs fixed behavior for IntuneNonceCalculator.
 *
 * Expected behavior (fixed):
 * When generating a fallback nonce (email is null), IntuneNonceCalculator must use a cryptographically
 * secure random number generator (java.security.SecureRandom) instead of kotlin.random.Random.
 *
 * Actual behavior (vulnerable):
 * IntuneNonceCalculator uses kotlin.random.Random, which is a cryptographically insecure PRNG.
 */
public class IntuneNonceCalculator31HIGH_InsecureRandomNonce {
    public static void main(String[] args) throws Exception {
        // Read bytecode of IntuneNonceCalculator to check for the insecure random reference
        String className = "defpackage.IntuneNonceCalculator";
        String classAsPath = className.replace('.', '/') + ".class";
        InputStream stream = IntuneNonceCalculator.class.getClassLoader().getResourceAsStream(classAsPath);
        if (stream == null) {
            throw new RuntimeException("Could not find class file for " + className);
        }

        byte[] bytes = stream.readAllBytes();
        String bytecodeString = new String(bytes, java.nio.charset.StandardCharsets.ISO_8859_1);

        if (bytecodeString.contains("kotlin/random/Random")) {
            throw new RuntimeException("VULNERABLE CODE DETECTED: IntuneNonceCalculator references kotlin/random/Random!");
        }

        System.out.println("Test passed successfully: Cryptographically insecure random has been removed!");
    }
}
