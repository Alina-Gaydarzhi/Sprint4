import data.OrderData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.OrderFormDataCustomer;
import pages.OrderFormRentalConditions;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {

    private final OrderData orderData;
    private final  String orderButtonType;

    public OrderTest(String orderButtonType, OrderData orderData) {
        this.orderButtonType = orderButtonType;
        this.orderData = orderData;
    }

    @Parameterized.Parameters(name = "Кнопка: {0}, данные: {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"header", OrderData.DATA_SET_1},
                {"header", OrderData.DATA_SET_2},
                {"middle", OrderData.DATA_SET_1},
                {"middle", OrderData.DATA_SET_2}
        };
    }

    @Test
    public void flowPositiveOrderTest() {
        if ("header".equals(orderButtonType)) {
            mainPage.clickOrderButtonHeader();
        } else {
            mainPage.scrollToOrderButtonMiddle();
            mainPage.clickOrderButtonMiddle();
        }

        OrderFormDataCustomer dataCustomer = new OrderFormDataCustomer(driver);
        dataCustomer.fillForm(
                orderData.getName(),
                orderData.getSurname(),
                orderData.getAddress(),
                orderData.getStationName(),
                orderData.getPhone()
        );
        dataCustomer.clickNextButton();

        OrderFormRentalConditions rentalConditions = new OrderFormRentalConditions(driver);
        rentalConditions.fillFormRental(
                orderData.getDeliveryDate(),
                orderData.getRentalPeriod(),
                orderData.getColor(),
                orderData.getComment()
        );
        rentalConditions.clickOrderButton();
        rentalConditions.confirmOrderYesButton();

        assertTrue("Должно отображаться окно успешного оформления заказа", rentalConditions.orderPlacedDisplayed());
    }

}