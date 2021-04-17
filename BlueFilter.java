import java.awt.Color;

/**
 * A filter deigned to show the levels of blue in the image.
 * 
 * @author Christopher Urban.
 * @version 4-16-2021
 */
public class BlueFilter extends Filter
{
    /**
     * Constructor for objects of class BlueFilter.
     * @param name The name of the filter.
     */
    public BlueFilter(String name)
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
                int blueLevel = (pixel.getBlue());
                if(blueLevel >= 170) {
                    image.setPixel(x, y, Color.WHITE);
                }
                else if(blueLevel >= 100) {
                    image.setPixel(x, y, Color.lightGray);
                }
                else if(blueLevel >= 60) {
                    image.setPixel(x, y, Color.gray);
                }
                else if(blueLevel >= 40) {
                    image.setPixel(x, y, Color.darkGray);
                }
                else if(blueLevel == 0) {
                    image.setPixel(x, y, Color.BLACK);
                }
            }
        }
    }
}