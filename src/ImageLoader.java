import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

/**
 * Returns a BufferedImage instance of the image at
 * the specified path.
 *
 * @param  path  a path to the image.
 * @return       the image with the specified path.
 */

public class ImageLoader {
	public static BufferedImage readImage(String path) {
		BufferedImage img = null;
		try {
				img = ImageIO.read(new File(path));
		} catch (IOException e) {
				System.err.println("Error: Could not read image " + path);
				System.exit(1);
		}
		return img;
	}

}
