package enums;

public enum Food {

    HAY(1, 4),
    STEAK(3, 4),
    FRUIT(2, 3),
    CELERY(0, 1),
    FISH(3, 2),
    ICE_CREAM(1, 3);


    private final int health;
    private final int  waste;
    Food(int health, int waste) {
        this.health = health;
        this.waste = waste;
    }
    public int getHealth() {
        return health;
    }
    public int getWaste() {
        return waste;
    }
}
