package ru.otus.atm.utility;

import lombok.experimental.UtilityClass;
import ru.otus.atm.exception.BadRequestException;

@UtilityClass
public class Validator {
    public static void validation(int sum) {
        checkMultiple10(sum);
        checkNotNegative(sum);
    }

    private static void checkMultiple10(int sum) {
        if (sum % 10 != 0) {
            throw new BadRequestException("Required sum multiple 10");
        }
    }

    private static void checkNotNegative(int sum) {
        if (sum < 0) {
            throw new BadRequestException("Required not negative sum");
        }
    }
}
