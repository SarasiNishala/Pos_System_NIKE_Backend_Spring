package lk.ijse.gdse68.nike_spring.controller;

import jakarta.validation.Valid;
import lk.ijse.gdse68.nike_spring.dto.OrderDTO;
import lk.ijse.gdse68.nike_spring.excption.DataPersistFailedException;
import lk.ijse.gdse68.nike_spring.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private final OrderService orderService;

    static Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@Valid @RequestBody OrderDTO order) {
        if (order == null) {
            return ResponseEntity.badRequest().build();
        } else {
            try {
                orderService.saveOrder(order);
                logger.info("Order saved : " + order);
                return ResponseEntity.created(null).build();
            } catch (DataPersistFailedException e) {
                return ResponseEntity.badRequest().build();
            } catch (Exception e) {
                logger.error(e.getMessage());
                return ResponseEntity.internalServerError().build();
            }
        }
    }
}