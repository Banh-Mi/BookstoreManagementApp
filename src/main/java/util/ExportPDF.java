package util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class ExportPDF {

    public static void exportPDF(JFrame frame, String fileName) {
        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Tạo hình ảnh từ JFrame
            BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            frame.paint(graphics);
            ImageIO.write(image, "png", new File("frame.png"));

            // Chuyển đổi hình ảnh thành tệp PDF
            BufferedImage awtImage = ImageIO.read(new File("frame.png"));
            PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, awtImage);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImageXObject, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());

            contentStream.close();
            document.save(new File(fileName));
            document.close();

            // Xóa tệp tạm thời
            File tempFile = new File("frame.png");
            tempFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
