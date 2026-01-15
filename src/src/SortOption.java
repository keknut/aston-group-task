package src;


public enum SortOption {
    MODEL_ASC("По модели - возрастание", new ModelAscStrategy()),
    MODEL_DESC("По модели - убывание", new ModelDescStrategy()),
    POWER_ASC("По мощности - возрастание", new PowerAscStrategy()),
    POWER_DESC("По мощности - убывание", new PowerDescStrategy()),
    YEAR_ASC("По году - возрастание", new YearAscStrategy()),
    YEAR_DESC("По году - убывание", new YearDescStrategy());

    private final String description;
    private final CarSortStrategy strategy;

    SortOption(String description, CarSortStrategy strategy) {
        this.description = description;
        this.strategy = strategy;
    }

    public CarSortStrategy getStrategy() { return strategy; }

    public String getDescription() { return description; }

    public static SortOption fromInput(String field, String direction) {
        return switch (field) {
            case "1" -> "1".equals(direction) ? MODEL_ASC : MODEL_DESC;
            case "2" -> "1".equals(direction) ? POWER_ASC : POWER_DESC;
            case "3", "4" -> "1".equals(direction) ? YEAR_ASC : YEAR_DESC;
            default -> throw new IllegalArgumentException("Неверное поле сортировки: " + field);
        };
    }
}
