import java.awt.Color;

/**
 * A filter deigned to show the levels of green in the image.
 * 
 * @author Christopher Urban.
 * @version 4-16-2021
 */
public class GreenFilter extends Filter
{
    /**
     * Constructor for objects of class GreenFilter.
     * @param name The name of the filter.
     */
    public GreenFilter(String name)
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
                int greenLevel = (pixel.getGreen());
                if(greenLevel >= 170) {
                    image.setPixel(x, y, Color.WHITE);
                }
                else if(greenLevel >= 100) {
                    image.setPixel(x, y, Color.lightGray);
                }
                else if(greenLevel >= 60) {
                    image.setPixel(x, y, Color.gray);
                }
                else if(greenLevel >= 40) {
                    image.setPixel(x, y, Color.darkGray);
                }
                else if(greenLevel == 0) {
                    image.setPixel(x, y, Color.BLACK);
                }
            }
        }
    }
}