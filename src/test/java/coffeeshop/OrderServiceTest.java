package coffeeshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class OrderServiceTest {
    private Barista mockBarista;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        mockBarista = mock(Barista.class);
        orderService = new OrderService(mockBarista);
    }

    @Test
    void shouldCallBrewForEachItemInOrder() {
        Order order = new Order();
        order.addItem(Coffee.LATTE);
        order.addItem(Coffee.ESPRESSO);

        orderService.processOrder(order);

        verify(mockBarista, times(1)).brew(Coffee.LATTE);
        verify(mockBarista, times(1)).brew(Coffee.ESPRESSO);
    }

    @Test
    void shouldNotCallBrewForEmptyOrder() {
        Order order = new Order();

        orderService.processOrder(order);

        verify(mockBarista, never()).brew(any());
    }
}
