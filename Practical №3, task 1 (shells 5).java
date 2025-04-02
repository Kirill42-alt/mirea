// Объявление публичного класса
public class DoubleToStringDemo {
// Главный метод программы — точка входа
    public static void main(String[] args) {
        double num = 3.14;

        String s1 = Double.toString(num);
        String s2 = String.valueOf(num);
        String s3 = num + "";
        String s4 = String.format("%.2f", num); // Округление до двух знаков

        System.out.println("Double.toString: " + s1);
        System.out.println("String.valueOf: " + s2);
        System.out.println("Сложение с пустой строкой: " + s3);
        System.out.println("String.format (2 знака после запятой): " + s4);
    }
}
