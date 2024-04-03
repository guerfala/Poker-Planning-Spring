package tn.esprit.pokerplanning.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.pokerplanning.Dto.ImportDataDTO;
import tn.esprit.pokerplanning.Services.ImportService;

@Qualifier
@RestController
public class ImportController {

    private final ImportService importService;

    @Autowired
    public ImportController(ImportService importService) {
        this.importService = importService;
    }

    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestBody ImportDataDTO importData) {
        importService.processImportedData(importData);
        return ResponseEntity.ok("Data imported successfully");
    }
}

