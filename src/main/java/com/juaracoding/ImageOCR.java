package com.juaracoding;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageOCR {

    public static String performOCR(String imagePath) {
        // Initialize Tesseract instance
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/tessdata");  // path to tessdata directory
        tesseract.setLanguage("eng");       // language set to English

        try {
            // Convert image to grayscale
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            BufferedImage grayscaleImage = convertToGrayscale(originalImage);

            // Perform OCR on the grayscale image
            return tesseract.doOCR(grayscaleImage);
        } catch (TesseractException | IOException e) {
            e.printStackTrace();
            return "Error while reading the image";
        }
    }

    private static BufferedImage convertToGrayscale(BufferedImage originalImage) {
        BufferedImage grayscaleImage = new BufferedImage(
                originalImage.getWidth(), originalImage.getHeight(),
                BufferedImage.TYPE_BYTE_GRAY);

        Graphics g = grayscaleImage.getGraphics();
        g.drawImage(originalImage, 0, 0, null);
        g.dispose();

        return grayscaleImage;
    }

    public static String getTotalIDRValue(String ocrResult) {
        String totalIDRPattern = "TOTAL IDR (\\d{1,3}(?:\\.\\d{3})*)";
        Pattern pattern = Pattern.compile(totalIDRPattern);
        Matcher matcher = pattern.matcher(ocrResult);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "Total IDR not found";
        }
    }

    public static String getInvoiceNumber(String ocrResult) {
        // Regular expression pattern to find the invoice number
        // This pattern allows for optional spaces or newlines and is case-insensitive
        String invoicePattern = "INV-\\d+";

        // Compile the regular expression pattern
        Pattern pattern = Pattern.compile(invoicePattern);

        // Match the pattern in the provided text
        Matcher matcher = pattern.matcher(ocrResult);

        if (matcher.find()) {
            return matcher.group();
        } else {
            return "Invoice number not found";
        }
    }
}



