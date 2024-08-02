package com.example.TacoCloud.data;

import com.example.TacoCloud.Taco;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author aleksandrov_maksim
 */
public interface TacoRepository 
        extends PagingAndSortingRepository<Taco, Long>{

    Optional<Taco> findById(Long id);
    
    Taco save(Taco taco);
    
}
