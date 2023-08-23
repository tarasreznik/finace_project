package com.finaceproject.model.mapper;

import com.finaceproject.model.dao.Costs;
import com.finaceproject.model.dto.CostsDto;

public class CostsMapper implements Mapper<Costs, CostsDto> {
    @Override
    public CostsDto toDao(Costs costs) {
        return new CostsDto(costs.getId(), costs.getDate(), costs.getComment(), costs.getCategory());
    }

    @Override
    public Costs toDto(CostsDto costsDto) {
        return new Costs(costsDto.getId(), costsDto.getDate(), costsDto.getComment(), costsDto.getCategory());
    }
}
