package dao;

import model.Smartphone;

import java.sql.Date;
import java.util.List;

public interface SmartphoneDAO {
    String PRODUCT_ID = "product_id";

    String HOME_TEAM_ID = "home_team_id";

    String NAME = "name";

    String CPU = "cpu";

    String RAM = "ram";

    String ROM = "rom";

    String SHAPE_ID = "shape_id";

    String COLOR_ID = "color_id";

    void addSmartphone(Smartphone smartphone);

    List<Smartphone> getSmartphones();

    List<Smartphone> getSmartphones(int shape_id);

    Smartphone getSmartphone(String name);

    Smartphone getSmartphone(int product_id);

    void updateSmartphone(Smartphone smartphone);

    void deleteSmartphone(Smartphone smartphone);

    void deleteSmartphone(int product_id);
}