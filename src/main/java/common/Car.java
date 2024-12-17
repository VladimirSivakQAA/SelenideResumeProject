package common;

import lombok.AllArgsConstructor;

/**
 * Енам с марками автомобилей
 */
@AllArgsConstructor
public enum Car {
    BMW("BMW"),
    GEELY("Geely"),
    HAVAL("Haval"),
    LADA("Lada");

    private final String car;

    @Override
    public String toString() {
        return car;
    }
}
