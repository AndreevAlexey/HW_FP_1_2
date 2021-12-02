import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    // генератор сделов
    private static List<Area> dealsGenerator(int count) {
        int l, w, cost;
        Random random = new Random();
        // список сделок
        List<Area> deals = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            // длина
            l = random.nextInt(10);
            // ширина
            w = random.nextInt(10);
            // стоимость
            cost = l * w * (100 + random.nextInt(50));
            // если выпал 0 - повторяем
            if(cost == 0) {
                i--;
                continue;
            }
            // добавить в список
            deals.add(new Area(l, w, cost));
        }
        return deals;
    }
    // текстовая характеристика сделки
    public static String isTrueDealStr(boolean a) {
        return (a) ? "честная" : "нечестная";
    }

    public static void main(String[] args) {
        int userCost;
        String input;
        Scanner scanner = new Scanner(System.in);
        List<Area> deals = dealsGenerator(10);

        while(true) {
            System.out.println("Введите стоимость квадратного метра(0 для выхода):");
            // ввод значения
            input = scanner.nextLine();
            try {
                userCost = Integer.parseInt(input);
            } catch (Exception exp) {
                System.out.println("Введено некорректное значение!");
                continue;
            }
            // проверка на выход
            if(userCost == 0) break;
            // вывод списка сделок в консоль
            for(Area deal : deals) {
                System.out.println(deal.toString() + ", стоимость M2 = " + deal.calcCostM2() + " - " + isTrueDealStr(deal.checkDeal(userCost)));
            }
            System.out.println();
        }
    }
}
