package model;

public class Categories {
    private int category_id;
    private String name;

    public Categories(int category_id,String name){
        this.category_id = category_id;
        this.name = name;
    }
    public Categories(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
