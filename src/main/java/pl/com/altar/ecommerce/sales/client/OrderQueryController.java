package pl.com.altar.ecommerce.sales.client;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.altar.ecommerce.sales.client.vm.OrderDetailsVM;
import pl.com.altar.ecommerce.sales.client.vm.OrderVM;
import pl.com.altar.ecommerce.sales.domain.purchase.ports.PurchaseQueryPort;

import java.util.List;


@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderQueryController {

    private final PurchaseQueryPort purchaseQueryPort;


    @GetMapping
    public ResponseEntity<List<OrderVM>> getAllOrders() {
        final var orderList = purchaseQueryPort.findAll();
        return new ResponseEntity<>(ModelMapper.map(orderList), HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDetailsVM> getOrder(@PathVariable Long orderId) {
        final var orderVM = purchaseQueryPort.findPurchase(orderId);
        return new ResponseEntity<>(ModelMapper.mapDetails(orderVM), HttpStatus.OK);
    }

}
