
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class BatchInversions
{
    public ImageResource makeInversion(ImageResource inImage) {
        
        ImageResource outImage = new ImageResource(inImage.getWidth(), 
        inImage.getHeight());
        
        for(Pixel pixel : inImage.pixels()) {
            
            Pixel outPixel = outImage.getPixel(pixel.getX(), pixel.getY());
            
            int red = pixel.getRed();
            int green = pixel.getGreen();
            int blue = pixel.getBlue();
            
            int redX = 255 - red;
            int greenX = 255 - green;
            int blueX = 255 - blue;
            
            outPixel.setRed(redX);
            outPixel.setGreen(greenX);
            outPixel.setBlue(blueX);
            
        }
        
        return outImage;
        
    }
    
    public void saveGrayFiles() {
        
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String fileName = image.getFileName();
            String name = "inverted-" + fileName;
            ImageResource invertedImage = makeInversion(image);
            invertedImage.setFileName(name);
            invertedImage.save();
        }
        
        
    }
    
}
