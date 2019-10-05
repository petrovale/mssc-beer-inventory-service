package guru.springboot.mssc.beer.inventory.service.web.mappers;

import guru.springboot.mssc.beer.inventory.service.domain.BeerInventory;
import guru.springboot.mssc.beer.inventory.service.web.model.BeerInventoryDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerInventoryMapper {

  BeerInventory beerInventoryDtoToBeerInventory(BeerInventoryDto beerInventoryDTO);

  BeerInventoryDto beerInventoryToBeerInventoryDto(BeerInventory beerInventory);
}
