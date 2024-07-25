package com.juaracoding;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Author: Koswara\nProject ImageOCR Tesseract");
        String imagePath = "src/main/resources/invoices/invoice.png";
        String ocrResult = ImageOCR.performOCR(imagePath);
        System.out.println("Extracted Text: " + ocrResult);

        String invoiceNumber = ImageOCR.getInvoiceNumber(ocrResult);
        System.out.println("Invoice Number: "+invoiceNumber);
        double totalIDR = Double.parseDouble(ImageOCR.getTotalIDRValue(ocrResult).replace(".",""));
        System.out.println("Total IDR: " + totalIDR);
    }
}