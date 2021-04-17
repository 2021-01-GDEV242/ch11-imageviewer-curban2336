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
        RedTint rFilter = new RedTint("Red Tint");
        OFImage rImage = image;
        GreenTint gFilter = new GreenTint("Green Tint");
        OFImage gImage = image;
        BlueTint bFilter = new BlueTint("Blue Tint");
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
            }
        }
        for(int y = 0; y < (height/2); y++) {
            for(int x = 0; x < (width/2); x++) {
                Color gPixel = gImage.getPixel(x, y);
                gImage.setPixel(x,y+(height/2),gPixel);
            }
        }
        for(int y = 0; y < (height/2); y++) {
            for(int x = 0; x < (width/2); x++) {
                Color bPixel = bImage.getPixel(x, y);
                bImage.setPixel(x+(width/2),y+(height/2),bPixel);
            }
        }
        rFilter.apply(rImage);
        gFilter.apply(gImage);
        bFilter.apply(bImage);
    }
}