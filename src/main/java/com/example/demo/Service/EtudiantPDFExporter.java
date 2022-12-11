package com.example.demo.Service;

import com.example.demo.Entities.Etudiant;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class EtudiantPDFExporter {
    private List<Etudiant> listUsers;

    public EtudiantPDFExporter(List<Etudiant> listUsers) {
        this.listUsers = listUsers;
    }

    private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);

        com.lowagie.text.Font font = FontFactory.getFont(FontFactory.HELVETICA);
        ((com.lowagie.text.Font) font).setColor(Color.WHITE);

        cell.setPhrase(new Phrase("Nom", font));

        table.addCell(cell);

        cell.setPhrase(new Phrase("Prenom", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Date de Naissance", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Option", font));
        table.addCell(cell);

    }

    private void writeTableData(PdfPTable table) {
        for (Etudiant user : listUsers) {
            table.addCell(String.valueOf(user.getNom()));
            table.addCell(user.getPrenom());
            table.addCell(String.valueOf(user.getDateNaissance()));
            table.addCell(String.valueOf(user.getOption()));
        }
    }

    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("List of Etudiants", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(4);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table);
        writeTableData(table);

        document.add(table);

        document.close();

    }
}
