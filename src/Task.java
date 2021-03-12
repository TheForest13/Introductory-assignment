import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task {

    public static boolean check(String str) {
        boolean result = false;
        Pattern pattern = Pattern.compile("\\d\\[[A-Za-z]+\\]");
        Matcher matcher = pattern.matcher(str);
        result = matcher.find();
        return result;
    }

    public static String method(String str) {
        String str2 = "";
        while (check(str)) {
            Pattern pattern = Pattern.compile("\\d\\[[A-Za-z]+\\]");
            Matcher matcher = pattern.matcher(str);
            if (matcher.find()) {
                str2 = methodSupport(matcher.group());
                str = str.replace(matcher.group(), str2);
            }
        }
        return str;
    }

    public static  String methodSupport(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        int count = 1;
        if (matcher.find()  ) {
            count = Integer.valueOf(matcher.group());
        }
        String result = str.replaceAll("[^A-Za-z]+", "");
        str = "";
        for (int i = 0; i < count; i++) {
            str += result + "";
        }
        return str;
    }

    public static void main(String[] args) {
        String result;
        System.out.println("Использовать значения по умолчанию ввод нажмите - 'y'\nРучной ввод нажмите - 'n'");
        Scanner scanner =  new Scanner(System.in);
        String line = scanner.next();
        if (line.equals("y")) {
            //Default values
            String str = "3[xyz]4[xy]z";
            String str2 = "2[3[x]y]";
            result = method(str);
            System.out.println("3[xyz]4[xy]z\n" + "Распакованная строка: " + result);
            String result2 = method(str2);
            System.out.println("2[3[x]y]\n" + "Распакованная строка: " +  result2);
        } else if (line.equals("n")) {
            System.out.println("Введите строку в виде шаблона 2[xyz]");
            scanner =  new Scanner(System.in);
            result = method(scanner.nextLine());
            System.out.println("Распакованная строка: " + result);
        } else {
            System.out.println("Не верный ввод");
        }
    }
}