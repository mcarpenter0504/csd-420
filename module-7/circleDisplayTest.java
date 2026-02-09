import static org.junit.jupiter.api.Assertions.*;
import javafx.scene.shape.Circle;
import org.junit.jupiter.api.Test;

public class circleDisplayTest {

    @Test
    public void testCircleCSS() {
        Circle test = new Circle();
        test.getStyleClass().add("plaincircle");
        test.setId("redcircle");

        assertTrue(test.getStyleClass().contains("plaincircle"));
        assertEquals("redcircle", test.getId());
    }
}
