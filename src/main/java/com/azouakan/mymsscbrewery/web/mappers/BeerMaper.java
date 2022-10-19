package com.azouakan.mymsscbrewery.web.mappers;

import com.azouakan.mymsscbrewery.domain.Beer;
import com.azouakan.mymsscbrewery.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMaper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
