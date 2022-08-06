package pokemon.application.domain.repository;

import org.springframework.data.repository.CrudRepository;
import pokemon.application.domain.entity.Pokemon;

import java.util.Optional;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    Optional<Pokemon> findByName(String name);
}
