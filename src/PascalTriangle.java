import java.util.Arrays;

public class PascalTriangle {

    public static void main(String[] args) {

        if (args.length != 1) System.out.println("Incorrect amount of arguments");
        if (!isNumeric(args[0])) System.out.println("Invalid.  Enter a numeric value");

        PascalTriangle triangle = new PascalTriangle();
        int[] pascalRow = triangle.getPascalRow(Integer.parseInt(args[0]));
        System.out.println(Arrays.toString(pascalRow));
    }

    public static boolean isNumeric(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public int[] getPascalRow(int rowNumber) {

        int[] pascalRow = new int[1];
        pascalRow[0] = 1;

        for (int i = 0; i < rowNumber; i++) {

            int[] arr = new int[pascalRow.length + 1];

            for (int j = 0; j < pascalRow.length; j++) {
                if (j == 0) arr[0] = 1;
                if (j == pascalRow.length - 1) arr[pascalRow.length] = 1;
                else arr[j + 1] = pascalRow[j] + pascalRow[j + 1];
            }
            pascalRow = arr;
        }
        return pascalRow;
    }
}
