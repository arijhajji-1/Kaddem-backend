package com.example.demo.Service;

import com.example.demo.Entities.Experience;
import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.poi.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;


@Service
public class ExportExperienceService {
    public ByteArrayInputStream experiencesPDFRepot(List<Experience> experiences) {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();
            document.addTitle("Liste des experiences");
            com.itextpdf.text.Font font = com.itextpdf.text.FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
            Paragraph para = new Paragraph("Liste des experiences", font);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);
            PdfPTable table = new PdfPTable(7);

            Stream.of("idExperience", "type", "dateDebutExperience", "dateFinExperience", "descriptif", "TitreDuProfil", "lieu")
                    .forEach(headerTitle -> {
                        PdfPCell header = new PdfPCell();
                        com.itextpdf.text.Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
                        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        header.setHorizontalAlignment(Element.ALIGN_CENTER);
                        header.setBorderWidth(1);
                        header.setPhrase(new Phrase(headerTitle, headFont));
                        table.addCell(header);
                    });
            for (Experience experience : experiences) {
                PdfPCell idExperience = new PdfPCell(new Phrase(experience.getIdExperience() + ""));
                idExperience.setPaddingLeft(1);
                idExperience.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idExperience.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(idExperience);

                PdfPCell type = new PdfPCell(new Phrase(experience.getType()));
                type.setPaddingLeft(1);
                type.setVerticalAlignment(Element.ALIGN_MIDDLE);
                type.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(type);

                PdfPCell dateDebutExperience = new PdfPCell(new Phrase(experience.getDateDebutExperience() + ""));
                dateDebutExperience.setPaddingLeft(1);
                dateDebutExperience.setVerticalAlignment(Element.ALIGN_MIDDLE);
                dateDebutExperience.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(dateDebutExperience);

                PdfPCell dateFinExperience = new PdfPCell(new Phrase(experience.getDateFinExperience() + ""));
                dateFinExperience.setPaddingLeft(1);
                dateFinExperience.setVerticalAlignment(Element.ALIGN_MIDDLE);
                dateFinExperience.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(dateFinExperience);

                PdfPCell descriptif = new PdfPCell(new Phrase(experience.getDescriptif()));
                descriptif.setPaddingLeft(1);
                descriptif.setVerticalAlignment(Element.ALIGN_MIDDLE);
                descriptif.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(descriptif);

                PdfPCell TitreDuProfil = new PdfPCell(new Phrase(experience.getTitreDuProfil()));
                TitreDuProfil.setPaddingLeft(1);
                TitreDuProfil.setVerticalAlignment(Element.ALIGN_MIDDLE);
                TitreDuProfil.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(TitreDuProfil);

                PdfPCell lieu = new PdfPCell(new Phrase(experience.getLieu()));
                lieu.setPaddingLeft(1);
                lieu.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lieu.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.addCell(lieu);


            }
            document.add(table);
            document.close();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }




    public static ByteArrayInputStream experienceExcelReport(List<Experience> experiences) throws IOException {
        String[] columns = {"idExperience", "type", "dateDebutExperience", "dateFinExperience", "descriptif", "TitreDuProfil", "lieu"};
        try (Workbook workbook = new XSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper creationHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("experiences");
            sheet.autoSizeColumn(columns.length);

            org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();

            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle cellStyle = workbook.createCellStyle();
            cellStyle.setFont(headerFont);

            Row headerRow = sheet.createRow(0);
            for(int col = 0; col < columns.length; col++){
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(cellStyle);
            }
            CellStyle cellStyle1 = workbook.createCellStyle();
            cellStyle1.setDataFormat(creationHelper.createDataFormat().getFormat("#"));
            int rowIndex = 1;
            for (Experience experience: experiences){
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(experience.getIdExperience());
                row.createCell(1).setCellValue(experience.getType());
                row.createCell(2).setCellValue(experience.getDateDebutExperience());
                row.createCell(3).setCellValue(experience.getDateFinExperience());
                row.createCell(4).setCellValue(experience.getDescriptif());
                row.createCell(5).setCellValue(experience.getTitreDuProfil());
                row.createCell(6).setCellValue(experience.getLieu());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}
