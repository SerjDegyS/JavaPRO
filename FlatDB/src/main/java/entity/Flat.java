package entity;

public class Flat {
    private int id;
    private String district;
    private String address;
    private double area;
    private int roomQuantity;
    private int price;

    public Flat(int id, String district, String address,
                double sguare, int roomQuantity, int price) {
        this.id = id;
        this.district = district;
        this.address = address;
        this.area = sguare;
        this.roomQuantity = roomQuantity;
        this.price = price;
    }

    public Flat() {};

    public int getId() {
        return id;
    }

    public String getDistrict() {
        return district;
    }

    public String getAddress() {
        return address;
    }

    public double getArea() {
        return area;
    }

    public int getRoomQuantity() {
        return roomQuantity;
    }

    public int getPrice() {
        return price;
    }

    public static Builder newBuilder(){
        return new Flat().new Builder();
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", district='" + district + '\'' +
                ", address='" + address + '\'' +
                ", sguare=" + area +
                ", roomQuantity=" + roomQuantity +
                ", price=" + price +
                '}';
    }

    public class Builder{

        private Builder() {
        }

        public Builder setId(int id) {
            Flat.this.id = id;
            return this;
        }

        public Builder setDistrict(String district) {
            Flat.this.district = district;
            return this;
        }

        public Builder setAddress(String address) {
            Flat.this.address = address;
            return this;
        }

        public Builder setArea(double sguare) {
            Flat.this.area = sguare;
            return this;
        }

        public Builder setRoomQuantity(int roomQuantity) {
            Flat.this.roomQuantity = roomQuantity;
            return this;
        }

        public Builder setPrice(int price) {
            Flat.this.price = price;
            return this;
        }

        public Flat build(){
            return Flat.this;
        }
    }

}
