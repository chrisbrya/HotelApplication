package org.example.model;

public class FreeRoom extends Room{

    public FreeRoom(String roomNumber, Double price, RoomType enumeration) {
        super(roomNumber, price = Double.valueOf(0), enumeration);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
