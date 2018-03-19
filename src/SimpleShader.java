
import algebra.*;
import java.awt.*;

/**
 * Simple shader that just copy the interpolated color to the screen.
 * @author: cdehais
 * @author Axel Grau
 * @author Grégoire Boiron <gregoire.boiron@gmail.com>
 */
public class SimpleShader extends Shader {

    public SimpleShader (GraphicsWrapper screen) {
        super (screen);
    }

    public void shade (Fragment fragment) {
        //System.out.println (fragment.getX () + "," + fragment.getY ());
        //System.out.println ("color " + fragment.getColor ());
        screen.setPixel (fragment.getX (), fragment.getY (), fragment.getColor ());
    }
}

