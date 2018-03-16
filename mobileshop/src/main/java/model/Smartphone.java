package model;

public class Smartphone {
    private int product_id;
    private String name;
    private int color_id;
    private int shape_id;
    private String cpu;
    private int ram;
    private int rom;

    public Smartphone(int product_id,String name,int color_id,int shape_id,String cpu,int ram,int rom){
        this.product_id = product_id;
        this.name = name;
        this.color_id = color_id;
        this.shape_id = shape_id;
        this.cpu = cpu;
        this.ram = ram;
        this.rom =rom;
    }
    public Smartphone(int product_id,String name,String cpu,int ram,int rom,int shape_id,int color_id){
        this.name = name;
        this.color_id = color_id;
        this.shape_id = shape_id;
        this.cpu = cpu;
        this.ram = ram;
        this.rom =rom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public int getColor_id() {
        return color_id;
    }

    public int getShape_id() {
        return shape_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public int getRam() {
        return ram;
    }

    public String getCpu() {
        return cpu;
    }

    public int getRom() {
        return rom;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setRom(int rom) {
        this.rom = rom;
    }

    public void setShape_id(int shape_id) {
        this.shape_id = shape_id;
    }

}
