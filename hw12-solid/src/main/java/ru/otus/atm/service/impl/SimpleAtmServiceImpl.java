package ru.otus.atm.service.impl;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import ru.otus.atm.exception.NotEnoughBanknotes;
import ru.otus.atm.model.Banknote;
import ru.otus.atm.repository.BanknoteStorage;
import ru.otus.atm.service.AtmService;

@RequiredArgsConstructor
public class SimpleAtmServiceImpl implements AtmService {
    private final BanknoteStorage storage;

    @Override
    public int depositMoney(Map<Banknote, Integer> banknotes) {
        return storage.putTheMoney(banknotes).entrySet().stream()
                .mapToInt(e -> e.getKey().value * e.getValue())
                .sum();
    }

    @Override
    public int getMoney(int sum) {
        checkMultiple10(sum);
        for (Map.Entry<Banknote, Integer> banknotes : storage.showMeTheMoney().entrySet()) {
            int amount = sum / banknotes.getValue();
            banknotes.setValue(banknotes.getValue() + amount);
            sum -= (banknotes.getValue() * amount);
        }

        return 0;
    }

    @Override
    public int showMoney() {
        return storage.showMeTheMoney().entrySet().stream()
                .mapToInt(e -> e.getKey().value * e.getValue())
                .sum();
    }

    private void checkMultiple10(int sum) {
        if (sum % 10 != 0) {
            throw new NotEnoughBanknotes("Required sum multiple 10");
        }
    }
}
