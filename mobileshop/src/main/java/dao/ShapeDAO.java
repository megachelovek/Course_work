package dao;

import model.Shape;

import java.sql.Date;
import java.util.List;

public interface ShapeDAO {
    String SHAPE_ID = "shape_id";

    String WIDTH = "width";

    String HEIGHT = "height";

    String WEIGHT = "weight";


    void addShape(Shape shape);

    List<Shape> getShapes();

    Shape getShape(int shape_id);

    void updateShape(Shape shape);

    void deleteShape(int shape_id);
}