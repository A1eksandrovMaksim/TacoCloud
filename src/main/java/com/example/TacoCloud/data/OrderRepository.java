package com.example.TacoCloud.data;

import com.example.TacoCloud.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long>{
    
}
