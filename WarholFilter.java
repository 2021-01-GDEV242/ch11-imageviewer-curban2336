import java.awt.Color;

/**
 * A filter to create a Warhol type image out of the image provided.
 * 
 * @author Christopher Urban.
 * @version 4-16-2021
 */
public class WarholFilter extends Filter
{
    /**
     * Constructor for objects of class WarholFilter.
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
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
        OFImage rImage = image;
        OFImage gImage = image;
        OFImage bImage = image;
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pixel = image.getPixel(x, y);
                image.setPixel(x/2,y/2,pixel);
            }
        }
        for(int y = 0; y < (height/2); y++) {
            for(int x = 0; x < (width/2); x++) {
                Color rPixel = rImage.getPixel(x, y);
                rImage.setPixel(x+(width/2),y,rPixel);
                int pixel = rImage.getRGB(x+(width/2),y);
                Color color = new Color(pixel, true);
                int redValue = color.getRed();
                int blueValue = color.getBlue();
                int greenValue = color.getGreen();
                
                if(redValue+40<=255){
                    redValue += 40;
                }
                else
                {
                    blueValue -= 40;
                    greenValue -= 40;
                }
                Color newColor = new Color(redValue, greenValue, blueValue);
                
                rImage.setRGB(x+(width/2),y,newColor.getRGB());
            }
        }
        for(int y = 0; y < (height/2); y++) {
            for(int x = 0; x < (width/2); x++) {
                Color gPixel = gImage.getPixel(x, y);
                gImage.setPixel(x,y+(height/2),gPixel);
                int pixel = gImage.getRGB(x,y+(height/2));
                Color color = new Color(pixel, true);
                int redValue = color.getRed();
                int blueValue = color.getBlue();
                int greenValue = color.getGreen();
                
                if(greenValue+40<=255){
                    greenValue += 40;
                }
                else
                {
                    blueValue -= 40;
                    redValue -= 40;
                }
                Color newColor = new Color(redValue, greenValue, blueValue);
                
                rImage.setRGB(x,y+(height/2),newColor.getRGB());
            }
        }
        for(int y = 0; y < (height/2); y++) {
            for(int x = 0; x < (width/2); x++) {
                Color bPixel = bImage.getPixel(x, y);
                bImage.setPixel(x+(width/2),y+(height/2),bPixel);
                int pixel = bImage.getRGB(x,y+(height/2));
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
                
                rImage.setRGB(x+(width/2),y+(height/2),newColor.getRGB());
            }
        }
    }
}