// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PDFGenerator.java

package classes;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;

public class PDFGenerator
{
    public PDFGenerator(String document, String fileRute, String header, String info, String footer, String imageRute)
    {
        boldFont = new Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 17F, 1);
        normalFont = new Font(com.itextpdf.text.Font.FontFamily.COURIER, 13F, 0);
        italicFont = new Font(com.itextpdf.text.Font.FontFamily.COURIER, 13F, 2);
        this.document = document;
        this.fileRute = fileRute;
        this.header = header;
        this.info = info;
        this.footer = footer;
        this.imageRute = imageRute;
        createPDF();
    }

    
    private Paragraph getHeader(String text)
    {
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk();
        paragraph.setAlignment(1);
        chunk.append(text);
        chunk.setFont(boldFont);
        paragraph.add(chunk);
        return paragraph;
    }

    private Paragraph getInfo(String text)
    {
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk();
        paragraph.setAlignment(0);
        chunk.append(text);
        chunk.setFont(normalFont);
        paragraph.add(chunk);
        return paragraph;
    }

    private Paragraph getFooter(String text)
    {
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk();
        paragraph.setAlignment(2);
        chunk.append(text);
        chunk.setFont(italicFont);
        paragraph.add(chunk);
        return paragraph;
    }

    public void createPDF()
    {
        try
        {
            Image image = null;
            Document document = new Document(PageSize.A5, 36F, 36F, 10F, 10F);
            PdfWriter pdf = PdfWriter.getInstance(document, new FileOutputStream(fileRute));
            document.open();
            document.add(getHeader(header));
            ImageIcon img = new ImageIcon(getClass().getResource("/profileDefaultImage.png"));
            image = Image.getInstance(getClass().getResource("/icon-logo.png"));
            image.scaleAbsolute(110F, 110F);
            image.setAbsolutePosition(305F, 490F);
            image.setAlignment(4);
            document.add(image);
            document.add(new Paragraph("\n\n"));
            document.add(getInfo(info));
            Paragraph p = new Paragraph();
            document.close();
        }
        catch(Exception exception) { }
    }

    String document;
    String fileRute;
    String header;
    String info;
    String footer;
    String imageRute;
    private Font boldFont;
    private Font normalFont;
    private Font italicFont;
}
