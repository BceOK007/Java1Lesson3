import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        * 1. Написать программу, которая загадывает случайное число от 0 до 9 и пользователю дается 3 попытки угадать это число.
        * При каждой попытке компьютер должен сообщить, больше ли указанное пользователем число,
        * чем загаданное, или меньше.
        * После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
        * */

        System.out.println("Задача #1.");
        guessNumber();

        /*
        * 2. * Создать массив из слов
        *  String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
        * "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
        * "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}.
        * При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает его
        * с загаданным словом и сообщает, правильно ли ответил пользователь.
        * Если слово не угадано, компьютер показывает буквы, которые стоят на своих местах.
        * apple – загаданное
        * apricot - ответ игрока
        * ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
        * */

        System.out.println("\nЗадача #2.* Создать массив из слов");
        guessWord();
    }

    static void guessNumber ()
    {
        Random rand = new Random();

        while (true)
        {
            boolean isWin = false;
            int hiddenNumber = rand.nextInt(10);

            System.out.println("Угадайте загаданное число за 3 попытки");

            for (int i = 1; i <= 3; i++) {

                int supposedNumber;
                System.out.println("Попытка №" + i);
                do
                {
                    System.out.println("Введите число от 0 до 9.");
                    supposedNumber = readIntegerFromConsole();
                }
                while (supposedNumber < 0 || supposedNumber > 9);

                if (supposedNumber == hiddenNumber) {
                    System.out.println("Вы угадали. Загаданное число: " + supposedNumber);
                    isWin = true;
                    break;
                } else if (supposedNumber > hiddenNumber) {
                    System.out.println("Загаданое число меньше");
                } else {
                    System.out.println("Загаданное число больше");
                }
            }
            if (!isWin)
                System.out.println("Вы проиграли.");

            if (!isExit()) break;
        }

    }

    public static int readIntegerFromConsole()
    {
        Scanner sc = new Scanner(System.in);

        do
        {
            if (sc.hasNextInt())
            {
                return sc.nextInt();
            }
            System.out.println("Введите целое число!");
            sc.nextLine();
        }
        while (true);
    }

    static boolean isExit()
    {
        System.out.println("\nПовторить игру еще раз? 1 – да / 0 – нет");
        while (true)
        {
            int exitNumber = readIntegerFromConsole();
            if (exitNumber == 1)
            {
                return true;
            }
            else if (exitNumber == 0)
            {
                return false;
            }
            else
            {
                System.out.println("Введите 1 - если желаете продолжить, или же 0 - если желаете закончить!");
            }
        }
    }

    static void guessWord()
    {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive",
                "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};

        Random rand = new Random();

        int hiddenWordNum = rand.nextInt(words.length);
        String hiddenWord = words[hiddenWordNum];
//        System.out.println("              " + hiddenWord);

        String inputWord;
        Scanner sc = new Scanner(System.in);

        do
        {
            inputWord = sc.nextLine();

            if (inputWord.equals(hiddenWord))
            {
                System.out.println("Вы угадали!");
                break;
            }
            else
            {
                String helpString = "";
                for (int i = 0; i < 15; i++)
                {
                    if (inputWord.length() <= i || hiddenWord.length() <= i)
                    {
                        helpString += "#";
                    }
                    else if (inputWord.charAt(i) == hiddenWord.charAt(i))
                    {
                        helpString += inputWord.charAt(i);
                    }
                    else
                    {
                        helpString += "#";
                    }
                }

                System.out.println("Вы не угадали слово. Подсказка: " + helpString);
            }
        }
        while (!(inputWord.equals(hiddenWord)));
    }


}
