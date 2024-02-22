package ru.otus.atm.rest;

import java.util.EnumMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.atm.exception.BadRequestException;
import ru.otus.atm.exception.NotEnoughBanknotesException;
import ru.otus.atm.model.Banknote;
import ru.otus.atm.repository.impl.SimpleBanknoteStorageImpl;
import ru.otus.atm.service.impl.SimpleAtmServiceImpl;

class AtmTest {

    private AtmController atmController;
    private Map<Banknote, Integer> banknotes;

    @BeforeEach
    void setUp() {
        atmController = new AtmController(new SimpleAtmServiceImpl(new SimpleBanknoteStorageImpl()));
        banknotes = new EnumMap<>(Banknote.class);
        banknotes.put(Banknote.BN_1000, 2);
        banknotes.put(Banknote.BN_500, 2);
        banknotes.put(Banknote.BN_100, 20);
    }

    @Test
    @DisplayName("ATM balance should be zero")
    void shouldZeroBalance() {
        int expectedBalance = 0;
        int actualBalance = atmController.show();
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("ATM balance should be 5000 after deposit")
    void should4000Balance() {
        int expectedBalance = 5000;
        int actualBalance = atmController.deposit(banknotes);
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("ATM balance should be 3200 after deposit 4000 and withdrawing 1500")
    void should2500Balance() {
        int expectedBalance = 3200;
        atmController.deposit(banknotes);
        int actualBalance = atmController.get(1800);
        Assertions.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    @DisplayName("Should be thrown NotEnoughBanknotesException")
    void shouldNotEnoughBanknotesException() {
        atmController.deposit(banknotes);
        Assertions.assertThrows(NotEnoughBanknotesException.class, () -> atmController.get(10000));
    }

    @Test
    @DisplayName("Should be thrown BadRequestException")
    void shouldBadRequestException() {
        atmController.deposit(banknotes);
        Assertions.assertThrows(BadRequestException.class, () -> atmController.get(101));
    }
}
