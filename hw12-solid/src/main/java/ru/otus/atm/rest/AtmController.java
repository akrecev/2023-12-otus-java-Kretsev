package ru.otus.atm.rest;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import ru.otus.atm.model.Banknote;
import ru.otus.atm.service.AtmService;

@RequiredArgsConstructor
public class AtmController {
    private final AtmService atmService;

    public int deposit(Map<Banknote, Integer> banknotes) {
        return atmService.depositMoney(banknotes);
    }

    public int get(int sum) {
        return atmService.getMoney(sum);
    }

    public int show() {
        return atmService.showMoney();
    }
}
