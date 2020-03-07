package knc.rogue.data;

public enum SpawnType {
    NONE(Category.TERRAIN),
    FLOOR_STONE(Category.TERRAIN),
    WALL_STONE(Category.TERRAIN),

    ENTRANCE_ROCK(Category.OBJECT),
    EXIT_ROCK(Category.OBJECT),

    MONSTER_BAT(Category.MONSTER);

    private Category category;

    SpawnType(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public enum Category {
        TERRAIN,
        OBJECT,
        MONSTER;
    }
}
