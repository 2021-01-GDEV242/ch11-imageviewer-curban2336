import java.awt.Color;

/**
 * A filter deigned to show all the levels of red in the image.
 * 
 * @author Christopher Urban.
 * @version 4-16-2021
 */
public class RedFilter extends Filter
{
    /**
     * Constructor for objects of class RedFilter.
     * @param name The name of the filter.
     */
    public RedFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
        Color lightGray = new Color (170,170,170);
        Color gray = new Color (100,100,100);
        Color darkGray = new Color (60,60,60);
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);
                int redLevel = (pixel.getRed());
                if(redLevel >= 170) {
                    image.setPixel(x, y, Color.WHITE);
                }
                else if(redLevel >= 100) {
                    image.setPixel(x, y, Color.lightGray);
                }
                else if(redLevel >= 60) {
                    image.setPixel(x, y, Color.gray);
                }
                else if(redLevel >= 40) {
                    image.setPixel(x, y, Color.darkGray);
                }
                else if(redLevel == 0) {
                    image.setPixel(x, y, Color.BLACK);
                }
            }
        }
    }
}