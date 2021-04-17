import java.awt.Color;
/**
 * A filter deigned to increase the levels of Blue in the image.
 * 
 * @author Christopher Urban.
 * @version 4-16-2021
 */
public class BlueTint extends Filter
{
    /**
     * Constructor for objects of class BlueTint.
     * @param name The name of the filter.
     */
    public BlueTint(String name)
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
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int pixel = image.getRGB(x,y);
                Color color = new Color(pixel, true);
                int redValue = color.getRed();
                int blueValue = color.getBlue();
                int greenValue = color.getGreen();
                
                if(blueValue+40<=255){
                    blueValue += 40;
                }
                else
                {
                    greenValue -= 40;
                    redValue -= 40;
                }
                Color newColor = new Color(redValue, greenValue, blueValue);
                
                image.setRGB(x,y,newColor.getRGB());
            }
        }
    }
}