
public class Area {
    private int length;
    private int width;
    private int cost;
    // конструкто
    public Area(int length, int width, int cost) {
        this.length = length;
        this.width = width;
        this.cost = cost;
    }
    // геттер-сеттеры
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    // рассчитать стоимость кв.метра
    public int calcCostM2() {
        return cost/(length * width);
    }
    // проверка сделки на "честность"
    public boolean checkDeal(int costM2) {
        return cost >= costM2 * length * width;
    }

    @Override
    public String toString() {
        return "Area(L" + length + "xW" + width + ") = " + cost;
    }
}
