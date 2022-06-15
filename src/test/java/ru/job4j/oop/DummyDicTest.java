package ru.job4j.oop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class DummyDicTest {
    //запоминаем настоящий PrintStream в специальную переменную
    private final PrintStream standardOut = System.out;
    //Создаем динамический массив
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    @DisplayName("Test engToRus method")
    void engToRus() {
        DummyDic dic = new DummyDic();
        String in = "Cat";
        String out = dic.engToRus(in);
        String expected = "Неизвестное слово. Cat";
        assertThat(out, is(expected));
    }

    @Test
    @DisplayName("Test main method")
    void main() {
        String expected = "Translation: Неизвестное слово. good";
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStreamCaptor);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);
        DummyDic.main(null);
        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStreamCaptor.toString().trim();
        //Возвращаем все, как было
        System.setOut(standardOut);
        assertThat(result, is(expected));
    }
}