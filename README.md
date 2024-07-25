# Java Tesseract OCR Invoice Extractor

## Overview

This project demonstrates the use of Java and Tesseract OCR to extract text from invoice images and subsequently extract specific information such as the invoice number using pattern matching.

## Features

- **Optical Character Recognition (OCR)**: Uses Tesseract OCR to convert images of invoices into text.
- **Pattern Matching**: Utilizes regex in Java to find and extract invoice-related information from the parsed text.

## Prerequisites

### Software Requirements

- **Java Development Kit (JDK) 17**
- **Tesseract OCR**: A free OCR engine. You can download it from [here](https://github.com/tesseract-ocr/tesseract).

### Libraries

- **Tess4J**: A Java wrapper for Tesseract OCR, which provides access to Tesseract functionalities through Java. Add Tess4J to your project using Maven:

```xml
<dependency>
    <groupId>net.sourceforge.tess4j</groupId>
    <artifactId>tess4j</artifactId>
    <version>5.12.0</version>
</dependency>
```

## Getting Started

### Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/koswara-dev/tesseract-ocr-invoice-extractor.git
   cd tesseract-ocr-invoice-extractor
   ```

2. **Set Up Tesseract**
    - Install Tesseract on your machine.
    - Ensure Tesseract is added to your system's PATH environment variable.

3. **Configure Tess4J**
    - Update the `tessdata` path in your Java project to point to the Tesseract data files.

```java
tesseract.setDatapath("src/main/resources/tessdata");
```

## Buy me a coffe

If you like this project and want to support its further development, buy me a coffee!

[![Buy Me a Coffee](https://www.buymeacoffee.com/assets/img/guidelines/download-assets-sm-1.svg)](https://www.buymeacoffee.com/kudajengke404)