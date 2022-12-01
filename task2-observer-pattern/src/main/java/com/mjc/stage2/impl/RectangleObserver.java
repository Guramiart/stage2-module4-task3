package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();
        Rectangle rectangle = event.getSource();
        RectangleValues rectangleValues = rectangleWarehouse.get(rectangle.getId());
        if(rectangleValues != null) {
            rectangleValues.setPerimeter(perimeter(rectangle));
            rectangleValues.setSquare(square(rectangle));
        } else {
            rectangleWarehouse.put(rectangle.getId(), new RectangleValues(perimeter(rectangle), square(rectangle)));
        }
    }

    private double perimeter(Rectangle rectangle) {
        return rectangle.getSideA() * 2 + rectangle.getSideB() * 2;
    }

    private double square(Rectangle rectangle) {
        return rectangle.getSideA() * rectangle.getSideB();
    }
}
