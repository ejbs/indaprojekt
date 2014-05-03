public class ImageLoader {
        public static BufferedImage readImage(String path) {
                BufferedImage img = null;
                try {
                        img = ImageIO.read(new File(path));
                } catch (IOException e) {
                        System.err.println("Error: Could not read image +"path);
                        System.exit(1);
                }
                return img;
        }
        
}
