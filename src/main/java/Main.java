import java.io.IOException;

public class Main {

    private static long countWrongPositions(int amountOfGuests) {
        switch (amountOfGuests) {
            case 0:
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
        }
        long combinations = 2;
        long combinationsWithRepeat = 3;
        for (int i = (int) combinationsWithRepeat; i < amountOfGuests; i++) {
            long combinationsWithoutRepeat = combinationsWithRepeat * i;
            combinationsWithRepeat = combinationsWithoutRepeat + combinations;
            combinations = combinationsWithoutRepeat;
        }

        return combinations;
    }

    public static void main(String[] args) {

        try {
            int input = Integer.parseInt(FileDao.readOneLineFromFile());
            long result = countWrongPositions(input);
            FileDao.writeStringToFile(""+result);
        } catch (IOException | NullPointerException e) {
            System.err.println(e.toString());
        }

    }
}
