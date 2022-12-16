package com.example.demo.Service;

import com.example.demo.Entities.DetailEquipe;
import com.example.demo.Entities.Equipe;
import com.example.demo.Repository.IEquipeRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class EquipeImpl implements IEquipeService{
    @Autowired
    IEquipeRepository equipeRepository ;


    @Override
    public List<Equipe> retrieveAllEquipes() {
        return (List<Equipe>) equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe equipe) {

        equipe.setLogo("../../assets/"+equipe.getLogo().substring(12));

       // = "../../assets/"+equipe.getLogo().substr(12);


        return equipeRepository.save(equipe);
    }

    @Override
    public Equipe updateEquipe(Equipe e) {

        e.setLogo("../../assets/"+e.getLogo().substring(12));

        return equipeRepository.save(e);
    }

    @Override
    public Equipe retrieveEquipe(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get() ;
    }

    @Override
    public Equipe updateByIdEquipe(Equipe e, Integer ideq) {
        e.setIdEquipe(ideq);
        return equipeRepository.save(e);


    }


    ////////////////////
    @Override
    public DetailEquipe retriveEquipeById(Integer idEquipe) {
        return equipeRepository.findById(idEquipe).get().getDetaileq();
    }

    @Override
    public String supprimer(Integer id) {
        equipeRepository.deleteById(id);
        return "equipe supprimé";
    }



    @Override
    public void assignEquipeToDetail(Integer equipeId, DetailEquipe detail) {
        Equipe e = equipeRepository.findById(equipeId).get();
        e.setDetaileq(detail);
        equipeRepository.save(e);
    }


    ////////////////////



    //////////recherche/////////////////////

    @Override
    public Page<Equipe> findAllByNomEquipeContaining(String nomEquipe, Pageable pageable) {
        return equipeRepository.findAllByNomEquipeContaining(nomEquipe, pageable);





    }


    /////////////pagination//////////////////
    @Override
    public Page<Equipe> lire(Pageable pageable) {
        return (Page<Equipe>) equipeRepository.findAll(pageable);
    }




    /////////////exporter to excel//////////////////

    public  ByteArrayInputStream experienceExcelReport(List<Equipe> equipes) throws IOException {
        String[] columns = {"idEquipe", "nomEquipe", "niveau", "mail", "nbrDesMembresMax"};
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            CreationHelper creationHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("Equipes");
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
            for (Equipe equipe:equipes ){
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(equipe.getIdEquipe());
                row.createCell(1).setCellValue(equipe.getNomEquipe());
                row.createCell(2).setCellValue(equipe.getNiveau().toString());
                row.createCell(3).setCellValue(equipe.getMail());
                row.createCell(4).setCellValue(equipe.getNbrDesMembresMax());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }






}
