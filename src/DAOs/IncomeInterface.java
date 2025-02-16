package DAOs;

import DTOs.Income;
import java.util.List;
import java.util.Date;

public interface IncomeInterface {
     void addIncome(Income income);
        void deleteIncome(int incomeID);
        List<IncomeDao> listAllIncomes();
        double calculateTotalIncome();
        List<Income> listIncomesByMonth(int month, int year);
    }
