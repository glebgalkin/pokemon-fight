package pokemon.challenge.domain.repository;

import pokemon.challenge.domain.entity.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    Optional<Pokemon> findByName(String name);
}
