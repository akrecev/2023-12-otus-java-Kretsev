package ru.otus.atm;

import java.util.EnumMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import ru.otus.atm.model.Banknote;
import ru.otus.atm.repository.impl.SimpleBanknoteStorageImpl;
import ru.otus.atm.rest.AtmController;
import ru.otus.atm.service.impl.SimpleAtmServiceImpl;

@Slf4j
public class AtmApp {
    public static void main(String[] args) {
        log.debug("Starting application...");

        AtmController atmController = new AtmController(new SimpleAtmServiceImpl(new SimpleBanknoteStorageImpl()));
        Map<Banknote, Integer> banknotes = new EnumMap<>(Banknote.class);
        banknotes.put(Banknote.BN_1000, 2);
        banknotes.put(Banknote.BN_100, 5);

        log.debug(String.valueOf(atmController.show()));

        log.debug(String.valueOf(atmController.deposit(banknotes)));

        atmController.get(1300);

        log.debug(String.valueOf(atmController.show()));
    }
}
