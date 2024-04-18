package tn.esprit.pokerplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pokerplanning.Entities.Pack;
import tn.esprit.pokerplanning.service.PackService;
import tn.esprit.pokerplanning.service.PdfGenerationService;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/pdf")

public class PdfController {
    @Autowired

    private PdfGenerationService pdfGenerationService;
    @Autowired
    private PackService packService; // Assuming you have a service to retrieve packs data

    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf() throws IOException {
        List<Pack> packs = packService.getPack(); // Retrieve packs data from database or any source
        byte[] pdfBytes = pdfGenerationService.generatePdf(packs);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_PDF).body(pdfBytes);
    }
}
