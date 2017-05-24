package FileUpload.cl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.util.logging.*;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.http.Part;

@Named(value = "fileUpload")
@ViewScoped
public class FileUpload implements java.io.Serializable {

    private String image_show;
    private Part uploadedFile;
    private LocalDate my_date;

    public FileUpload() {
        this.my_date = LocalDate.now();
        this.image_show = "prof-pic.png";
    }

    public static BufferedImage ResizeImage(Image image, int width, int height) {

        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2d = bufferedImage.createGraphics();
        g2d.setComposite(AlphaComposite.Src);

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();

        return bufferedImage;

    }

    public void uploadMe() {
        try {

            String fileName = uploadedFile.getSubmittedFileName();
            int pos = fileName.lastIndexOf(".");

            if (pos > 0) {
                fileName = fileName.substring(0, pos);
            }
            BufferedImage img = ResizeImage(ImageIO.read(uploadedFile.getInputStream()), 160, 120);
            ImageIO.write(img, "png", new File("C:/x-images/images/" + fileName + ".png"));
            this.setImage_show(fileName + ".png");

        } catch (IOException ex) {
            Logger.getLogger(FileUpload.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public String getImage_show() {
        return image_show;
    }

    public void setImage_show(String image_show) {
        this.image_show = image_show;
    }

    public LocalDate getMy_date() {
        return my_date;
    }

    public void setMy_date(LocalDate my_date) {
        this.my_date = my_date;
    }

}
