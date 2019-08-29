package ru.job4j.trainee.part002.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[]{"в", "1"})
        );
        input.ask("Ввеедите пункт меню : ", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Ввеедите пункт меню : %n"
                                + "Введите номер пункта меню%n"
                                + "Ввеедите пункт меню : %n")
                )
        );
    }
}
