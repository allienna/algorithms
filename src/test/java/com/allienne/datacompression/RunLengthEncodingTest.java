package com.allienne.datacompression;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class RunLengthEncodingTest {

    private RunLengthEncoding cut;

    @BeforeEach
    void setUp() {
        cut = new RunLengthEncoding();
    }

    @Test
    void encode() {
        assertAll(
                () -> {
                    String result = cut.encode("WWWWWWWWWWWWBWWWWWWWWWWWWWWBBBWWWWWWWWWWWWWWWWWWWWWWWBWWWWWWWWWWW");
                    assertEquals("12W1B14W3B23W1B11W", result);
                },
                () -> {
                    String result = cut.encode("WBWBWBWBWB");
                    assertEquals("1W1B1W1B1W1B1W1B1W1B", result);
                }
        );
    }
}