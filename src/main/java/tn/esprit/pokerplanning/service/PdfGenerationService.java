package tn.esprit.pokerplanning.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;
import tn.esprit.pokerplanning.Entities.Pack;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
@Service
public class PdfGenerationService {
    public byte[] generatePdf(List<Pack> packs) throws IOException {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Add table borders
                float margin = 0;
                float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
                float yStart = page.getMediaBox().getHeight() - margin;
                float yEnd = margin;
                float tableHeight = yStart - yEnd;
                float cellHeight = 20; // Adjust cell height as needed
                float cellMargin = 5f;

                // Draw table borders
                drawTableBorders(contentStream, margin, yStart, tableWidth, tableHeight, cellHeight, cellMargin, packs.size());

                // Add table headers and data
                addTableContent(contentStream, packs, margin, yStart, tableWidth, cellHeight);
            }

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.save(byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
    }

    private void drawTableBorders(PDPageContentStream contentStream, float xStart, float yStart, float tableWidth,
                                  float tableHeight, float cellHeight, float cellMargin, int numOfRows) throws IOException {
        float nextY = yStart;
        for (int i = 0; i <= numOfRows+1; i++) {
            contentStream.moveTo(xStart, nextY);
            contentStream.lineTo(xStart + tableWidth, nextY);
            contentStream.stroke();
            nextY -= cellHeight + cellMargin;
        }

        float nextX = xStart;
        for (int i = 0; i <= 3; i++) { // Assuming 5 columns in the table
            contentStream.moveTo(nextX, yStart);
            contentStream.lineTo(nextX, yStart - tableHeight);
            contentStream.stroke();
            nextX += tableWidth / 5; // Divide by the number of columns
        }
    }

    private void addTableContent(PDPageContentStream contentStream, List<Pack> packs, float xStart, float yStart,
                                 float tableWidth, float cellHeight) throws IOException {
        float yPosition = yStart - 15; // Adjust vertical position as needed
        float columnWidth = tableWidth / 5; // Assuming 5 columns in the table, adjust as needed
        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
        writeText(contentStream, xStart, yPosition, "Pack ID");
        writeText(contentStream, xStart + columnWidth, yPosition, "Pack Name");
        writeText(contentStream, xStart + 2 * columnWidth, yPosition, "Number of Cards");
        writeText(contentStream, xStart + 3 * columnWidth, yPosition, "Pack Description");
        yPosition -= cellHeight;

        contentStream.setFont(PDType1Font.HELVETICA, 12);
        for (Pack pack : packs) {
            writeText(contentStream, xStart, yPosition, String.valueOf(pack.getPackId()));
            writeText(contentStream, xStart + columnWidth, yPosition, pack.getPackName());
            writeText(contentStream, xStart + 2 * columnWidth, yPosition, String.valueOf(pack.getNbCards()));
            writeText(contentStream, xStart + 3 * columnWidth, yPosition, pack.getPackDescription());
            yPosition -= cellHeight;
        }
    }

    private void writeText(PDPageContentStream contentStream, float x, float y, String text) throws IOException {
        contentStream.beginText();
        contentStream.newLineAtOffset(x, y);
        contentStream.showText(text);
        contentStream.endText();
    }
}
