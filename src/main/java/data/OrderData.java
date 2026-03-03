package data;

public class OrderData {
    private final String name;
    private final String surname;
    private final String address;
    private final String stationName;
    private final String phone;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String color;
    private final String comment;


    public OrderData(String name, String surname, String address, String stationName, String phone, String deliveryDate, String rentalPeriod, String color, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.stationName = stationName;
        this.phone = phone;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.color = color;
        this.comment = comment;
    }

    public String getName() { return name; }
    public String getSurname() { return surname; }
    public String getAddress() { return address; }
    public String getStationName() { return stationName; }
    public String getPhone() { return phone; }
    public String getDeliveryDate() { return deliveryDate; }
    public String getRentalPeriod() { return rentalPeriod; }
    public String getColor() { return color; }
    public String getComment() { return comment; }

    public static final OrderData DATA_SET_1 = new OrderData(
            "Малина", "Малинова", "ул. Лубянская, д.1", "Лубянка",
            "+79998181818", "25", "двое суток", "black", "связаться за час перед доставкой"
    );

    public static final OrderData DATA_SET_2 = new OrderData(
            "Иван", "Сидоров", "Раменская улица, дом 1", "Раменки",
            "+79898181818", "27", "двое суток", "grey", "согласовать время перед доставкой"
    );


}