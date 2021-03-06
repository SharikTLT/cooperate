package com.cooperate;

import com.cooperate.service.ContributionService;
import org.apache.log4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Calendar;

/**
 * Класс обновления пеней при запуске приложения
 */
public class InitFines {

    private final Logger logger = Logger.getLogger(InitFines.class);

    /**
     * При создании экземпляра запускаетс метод обновления пеней
     *
     * @param service Сервис по работе с долговыми периодами
     */
    public InitFines(ContributionService service) {
        try {
            service.updateFines();
            service.onFines(Calendar.getInstance());
        } catch (DataIntegrityViolationException e) {
            logger.error(e);
        }

    }
}
