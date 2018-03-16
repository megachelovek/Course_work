package model;

public class Colors {
    private int color_id;
    private int rgb;
    private String name;

    public Colors(int color_id,int rgb,String name){
        this.color_id = color_id;
        this.rgb = rgb;
        this.name = name;
    }

    public Colors(int rgb,String name){
        this.rgb = rgb;
        this.name = name;
    }

    public int getColor_id() {
        return color_id;
    }

    public int getRgb() {
        return rgb;
    }

    public String getName() {
        return name;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRgb(int rgb) {
        this.rgb = rgb;
    }
}
