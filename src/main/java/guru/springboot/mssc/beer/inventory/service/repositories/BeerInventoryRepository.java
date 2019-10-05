package guru.springboot.mssc.beer.inventory.service.repositories;

import guru.springboot.mssc.beer.inventory.service.domain.BeerInventory;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerInventoryRepository extends JpaRepository<BeerInventory, UUID> {

  List<BeerInventory> findAllByBeerId(UUID beerId);
}
