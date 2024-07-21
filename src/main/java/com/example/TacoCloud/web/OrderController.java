package com.example.TacoCloud.web;

import com.example.TacoCloud.Taco;
import com.example.TacoCloud.TacoOrder;
import com.example.TacoCloud.data.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    
    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    
    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }
    
    @PostMapping
    public String proccessOrder(@Valid TacoOrder order,
            Errors errors,
            SessionStatus sessionStatus){
        if(errors.hasErrors()){
            return "orderForm";
        }
        
        long i = 0;
        for(Taco taco : order.getTacos()){
            taco.setTacoOrderKey(i++);
        }
        orderRepository.save(order);
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        
        return "redirect:/";
    }
    
}
