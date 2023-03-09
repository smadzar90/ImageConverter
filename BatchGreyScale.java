import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class BatchGreyScale
{
    
    public ImageResource makeGray(ImageResource inImage) {
        
        ImageResource outImage = new ImageResource(inImage.getWidth(), 
        inImage.getHeight());
        
        for(Pixel pixel : inImage.pixels()) {
            
            Pixel outPixel = outImage.getPixel(pixel.getX(), pixel.getY());
            
            int red = pixel.getRed();
            int green = pixel.getGreen();
            int blue = pixel.getBlue();
            
            int avarage = (red + green + blue) / 3;
            
            outPixel.setRed(avarage);
            outPixel.setGreen(avarage);
            outPixel.setBlue(avarage);
            
        }
        
        return outImage;
        
    }
    
    public void saveGrayFiles() {
        
        DirectoryResource dr = new DirectoryResource();
        
        for(File f : dr.selectedFiles()) {
            ImageResource image = new ImageResource(f);
            String fileName = image.getFileName();
            String name = "gray-" + fileName;
            ImageResource grayScale = makeGray(image);
            grayScale.setFileName(name);
            grayScale.save();
        }
        
        
    }
}
