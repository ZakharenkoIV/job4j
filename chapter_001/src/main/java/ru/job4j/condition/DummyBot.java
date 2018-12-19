package ru.job4j.condition;

/**
 * @author Ilya Zakharenko (ZakharenkoIV@yandex.ru)
 * @version $Id$
 * @since 19.12.2018
 */
public class DummyBot {
    /**
     * Отвечает на вопросы.
     * @param question Вопрос от клиента.
     * @return Ответ.
     */
    public String answer(String question) {
        String rs1 = "Это ставит меня в тупик. Спросите другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rs1 = "Привет, умник.";
        } else if ("Пока.".equals(question)){
            rs1 = "До скорой встречи.";
        }
        return rs1;
    }
}