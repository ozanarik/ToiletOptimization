import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of women: ");
        int womenCount = scanner.nextInt();

        System.out.print("Number of men: ");
        int menCount = scanner.nextInt();

        System.out.print("Total area allocated to toilets (in square meters): ");
        double totalArea = scanner.nextDouble();

        System.out.print("Break time (in minutes): ");
        double breakTime = scanner.nextDouble();

        // Estimated toilet times for men and women
        double womenTime = 3.0; // 3 minutes for women
        double menTime = 1.0; // 1 minute for men

        calculator(womenCount, menCount, totalArea, womenTime, menTime, breakTime);
    }

    public static void calculator(int womenCount, int menCount, double totalArea, double womenTime, double menTime, double breakTime) {
        // Assumptions
        double urinalRequiredArea = 1.0; // Area covered by a urinal (square meters)
        double cabinRequiredArea = 2.0; // Area covered by one cabin (square meters)

        // How many people can use the toilets at the same time according to the break time
        double womenCapacityPerMinute = breakTime / womenTime;
        double menCapacityPerMinute = breakTime / menTime;


        // We assume that half of men and women go to the toilet
        int womenToiletUsers = (int) Math.ceil(womenCount / 2.0);
        int menToiletUsers = (int) Math.ceil(menCount / 2.0);

        // Number of cabins and urinals required
        int cabinCount = (int) Math.ceil(womenToiletUsers / womenCapacityPerMinute);
        int urinalCount = (int) Math.ceil(menToiletUsers / menCapacityPerMinute);

        double totalWomenArea = cabinCount * cabinRequiredArea;
        double totalMenArea = urinalCount * urinalRequiredArea;
        double requiredArea = totalWomenArea + totalMenArea;

        // Warns if space is insufficient
        if (requiredArea > totalArea) {
            double minRequiredArea = Math.ceil(requiredArea - totalArea);
            System.out.println("Total space provided is not enough. At least " + minRequiredArea + " square meters more space is needed.");
        } else {
            System.out.println("Number of cabins required for women: " + cabinCount);
            System.out.println("Number of urinals required for men: " + urinalCount);
            System.out.println("Total space to be reserved for women: " + totalWomenArea + " square meter");
            System.out.println("Total space to be reserved for men: " + totalMenArea + " square meter");
        }
    }
}