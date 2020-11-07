package aplikacja;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.RankingElement;

public class PDFCreator {

    private BaseFont helveticaFont;
    private Font titleFont, textFont, textBoldFont;
    private String date;

    private ArrayList<RankingElement> rankingData;

    public PDFCreator(ArrayList<RankingElement> rankingData) {
        this.rankingData = rankingData;

        try {
            helveticaFont = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1250, BaseFont.EMBEDDED);
            titleFont = new Font(helveticaFont, 24, Font.BOLD);
            textFont = new Font(helveticaFont, 12);
            textBoldFont = new Font(helveticaFont, 12, Font.BOLD);

        } catch (DocumentException ex) {
            Logger.getLogger(PDFCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        date = (LocalDateTime.now().getDayOfMonth() + "-" + LocalDateTime.now().getMonthValue() + "-" + LocalDateTime.now().getYear());

    }

    public void createRanking(String path) {

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path + ".pdf"));
            document.open();

            document.addTitle("Ranking czytelnictwa");
            Paragraph paragraph = new Paragraph();

            paragraph.add(new Paragraph("Ranking czytelnictwa na dzień " + date, titleFont));

            addEmptyLine(paragraph, 2);
            paragraph.setFont(textFont);

            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);

            PdfPCell c1 = new PdfPCell(new Phrase("Numer ID", textBoldFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Imię", textBoldFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Nazwisko", textBoldFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);

            c1 = new PdfPCell(new Phrase("Liczba książek", textBoldFont));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
            table.setHeaderRows(1);

            for (int i = 0; i < rankingData.size(); i++) {

                PdfPCell cell1 = new PdfPCell(new Phrase(rankingData.get(i).getId() + ""));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell cell2 = new PdfPCell(new Phrase(rankingData.get(i).getFirstname()));
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell cell3 = new PdfPCell(new Phrase(rankingData.get(i).getLastname()));
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);

                PdfPCell cell4 = new PdfPCell(new Phrase(rankingData.get(i).getCount() + ""));
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
            }

            paragraph.add(table);

            document.add(paragraph);

            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}
