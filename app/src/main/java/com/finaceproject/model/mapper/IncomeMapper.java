package com.finaceproject.model.mapper;

import com.finaceproject.model.dao.Income;
import com.finaceproject.model.dto.IncomeDto;

public class IncomeMapper implements Mapper<Income, IncomeDto>{
    @Override
    public IncomeDto toDao(Income income) {
        return new IncomeDto(income.getId(), income.getDate(), income.getComment(), income.getCategory());
    }

    @Override
    public Income toDto(IncomeDto incomeDto) {
        return new Income(incomeDto.getId(), incomeDto.getDate(),
                incomeDto.getComment(), incomeDto.getCategory());
    }
}
