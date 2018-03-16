package dao;

import model.Colors;

import java.awt.*;
import java.sql.Date;
import java.util.List;

public interface ColorsDAO {
    String COLOR_ID = "color_id";

    String RGB = "rgb";

    String NAME = "name";


    void addColor(Colors color);

    List<Colors> getColors();

    Colors getColor(String name);

    Colors getColor(int color_id);

    void updateColor(Colors color);

    void deleteColor(String name);

    void deleteColor(int color_id);
}
