package com.example.TacoCloud.data;

import com.example.TacoCloud.TacoOrder;


public interface OrderRepository {
    
    TacoOrder save(TacoOrder order);
    
}
