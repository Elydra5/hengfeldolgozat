package com.example;

public class Model {
    public int id;
    public Double radius;
    public Double height;
    public Double surface;

    public Model(int id, Double radius, Double height, Double surface) {
        this.id = id;
        this.radius = radius;
        this.height = height;
        this.surface = surface;
    }

    @Override
    public String toString() {
        String str = "%d,%f,%f,%f";
        return String.format(str, id,radius,height,surface);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getSurface() {
        return surface;
    }

    public void setSurface(Double surface) {
        this.surface = surface;
    }
}
