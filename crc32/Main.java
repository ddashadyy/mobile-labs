import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.zip.CRC32;

public class Main {
    // хэш функция - это одностороннее преобразование произвольного числа байт
    // в число фиксированного размера (например, для CRC32 - это 32 бита, для MD5 - 128)
    // невозможно получить исходный набор байт по хэшу кроме как перебрать все 
    // возможные комбинации (полный перебор, brute force)

    public static void main(String[] args) throws IOException { // указывается, что возникает исключение
        long hash1 = 0x0B91A851BL; // это CRC32 хэш пароля apple123
        long hash2 = 0x0BA02B6E1L; // хэш CRC32 пароля, который нужно угадать
        // пароль состоит из слова (из файла), за котрым следует число от 1 до 9999
        // примеры паролей: master111 shadow1234
        // посчитать хэш можно и  в браузере http://www.sunshine2k.de/coding/javascript/crc/crc_js.html
        
        // часть 1. проверяем, как пользоваться CRC32
        // используем простой алгоритм CRC32 
        CRC32 crc32 = new  CRC32();
        String plaintext = "apple123";
        crc32.update(plaintext.getBytes());
        // хэш - это контрольная сумма в виде числа типа long
        long checksum = crc32.getValue();
        // выводим наш хэш в шестнадцатеричной форме
        // System.out.println(Long.toHexString(checksum));

        // объект можно использовать повторно, вызвав метод reset()
        crc32.reset();
        crc32.update(plaintext.getBytes());
        // получаем хэш - это просто число
        checksum = crc32.getValue();
        // пример вывода хэша в 16-ричной системе счисления
        // System.out.println(Long.toHexString(checksum));

        // часть 2. считываем список слов из файла
        // https://github.com/danielmiessler/SecLists/blob/master/Passwords/Common-Credentials/10k-most-common.txt
        // кстати, могу рекомендовать блог автора, пишет про инф. безопасность
        // https://danielmiessler.com/blog/
        // использовать класс Scanner и его методы hasNextLine(), nextLine()
        // тут чтение файла (работаем со сканером как обычно)
        File f = new File("10k-most-common.txt");
        try (Scanner sc = new Scanner(f)) { // вместо потока можно передать просто файл
            // часть 3: подбор пароля. 
            // через вложенный цикл формируем пароль, считаем его хэш, сравниваем с искомым hash2 0x0BA02B6E1L
            // если мы нашли такой пароль, выводим его на экран и радуемся
            // подсказка - если ваш пароль имеет связь с лошадями, вы, скорее всего, угадали
            while (sc.hasNextLine()) {
                String partOfPasswd = sc.nextLine();
                
                boolean isRightPasswd = false;

                for (int i = 1; i < 10000; ++i) {
                    StringBuilder passwdBuilder = new StringBuilder(partOfPasswd);
                    passwdBuilder.append(i);

                    String passwd = passwdBuilder.toString();

                    crc32.reset();
                    crc32.update(passwd.getBytes());

                    if (Long.toHexString(crc32.getValue()).equals(Long.toHexString(hash2))) {
                        isRightPasswd = true;

                        System.out.println(passwd);
                        break;
                    }
                }

                if (isRightPasswd) break;
            }
	    } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }
}
