package guru.springboot.mssc.beer.inventory.service.services;

import guru.springboot.mssc.beer.inventory.service.config.JmsConfig;
import guru.springboot.mssc.beer.inventory.service.domain.BeerInventory;
import guru.springboot.mssc.beer.inventory.service.repositories.BeerInventoryRepository;
import guru.sfg.brewery.model.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class NewInventoryListener {

  private final BeerInventoryRepository beerInventoryRepository;

  @JmsListener(destination = JmsConfig.NEW_INVENTORY_QUEUE)
  public void listen(NewInventoryEvent event){

    log.debug("Got Inventory: " + event.toString());

    beerInventoryRepository.save(BeerInventory.builder()
        .beerId(event.getBeerDto().getId())
        .upc(event.getBeerDto().getUpc())
        .quantityOnHand(event.getBeerDto().getQuantityOnHand())
        .build());
  }

}
