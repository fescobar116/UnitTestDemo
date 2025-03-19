package edu.unac;

import edu.unac.exception.InvalidVerificationCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class VerificationCodeGeneratorTest {
    private RandomNumberGenerator randomNumberGenerator;
    private VerificationCodeGenerator codeGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = mock(RandomNumberGenerator.class);
    }

    @Test
    void generateCode() {
        when(randomNumberGenerator.generate()).thenReturn(1,7,9,2,0,5);

        codeGenerator = new VerificationCodeGenerator(randomNumberGenerator);

        String code = codeGenerator.generateCode();
        assertEquals("179205", code);
    }

    @Test
    void validateCode() {
        when(randomNumberGenerator.generate()).thenReturn(9,6,2,9,4,6);

        codeGenerator = new VerificationCodeGenerator(randomNumberGenerator);
        codeGenerator.generateCode();

        assertTrue(codeGenerator.validateCode("962946"));
        assertFalse(codeGenerator.validateCode("334455"));
    }

    @Test
    void validateCodeExpired() {
        when(randomNumberGenerator.generate()).thenReturn(9,6,2,9,4,6);

        codeGenerator = new VerificationCodeGenerator(randomNumberGenerator);
        codeGenerator.generateCode();

        for (int i =0; i < 5; i++)
            assertTrue(codeGenerator.validateCode("962946"));

        assertFalse(codeGenerator.validateCode("962946"));
    }

    @Test
    void generateCodeInvalid() {
        when(randomNumberGenerator.generate()).thenReturn(9,3,4,5,2,7);

        codeGenerator = new VerificationCodeGenerator(randomNumberGenerator);

        InvalidVerificationCodeException ex = assertThrows(InvalidVerificationCodeException.class,
                () -> codeGenerator.generateCode());

        assertEquals("Tree consecutive digits not allowed", ex.getMessage());
    }

    @Test
    void generateCodeLast() {
        when(randomNumberGenerator.generate()).thenReturn(1,2,9,2,0,5);

        codeGenerator = new VerificationCodeGenerator(randomNumberGenerator);

        String code = codeGenerator.generateCode();
        assertEquals("129205", code);
    }
}