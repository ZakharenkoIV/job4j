package ru.job4j.trainee.part002.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"one", "1"})
        );
        input.askInt("Enter");
        assertThat(
                mem.toString(),
                is(String.format("Please enter validate data again.%n"))
        );
        System.setOut(out);
    }

    @Test
    public void whenMoreMaxInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        Input input = new ValidateInput(
                new StubInput(new String[]{"5", "1"}));
        input.askInt("Enter", 3);
        String lnSprtr = System.lineSeparator();
        assertThat(
                mem.toString(),
                is(String.format("Out of about %s > [0, %s]%s", "5", "3", lnSprtr + "Please select key from menu." + lnSprtr))
        );
        System.setOut(out);
    }
}
