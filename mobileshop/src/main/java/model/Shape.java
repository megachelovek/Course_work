package model;

public class Shape {
    private int shape_id;
    private int width;
    private int height;
    private int weight;

    public Shape(){}

    public Shape(int shape_id,int width,int height,int weight){
        this.shape_id = shape_id;
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public Shape(int width,int height,int weight){
        this.width = width;
        this.height = height;
        this.weight = weight;
    }

    public void setShape_id(int shape_id){this.shape_id = shape_id;}
    public void setWidth(int width){this.width = width;}
    public void setHeight(int height){this.shape_id = height;}
    public void setWeight(int weight){this.shape_id = weight;}

    public int getHeight() {
        return height;
    }
    public int getShape_id() {
        return shape_id;
    }
    public int getWeight() {
        return weight;
    }
    public int getWidth() {
        return width;
    }
}
