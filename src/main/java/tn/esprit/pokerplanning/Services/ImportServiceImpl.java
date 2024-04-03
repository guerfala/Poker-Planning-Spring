package tn.esprit.pokerplanning.Services;

import org.springframework.stereotype.Service;
import tn.esprit.pokerplanning.Dto.ImportDataDTO;
import tn.esprit.pokerplanning.Repositories.TaskRepository;

import java.util.List;
import java.util.Map;

@Service
public class ImportServiceImpl implements ImportService {

    TaskRepository taskRepository;

    @Override
    public void processImportedData(ImportDataDTO importData) {
        // Perform operations based on imported data
        Long uploadId = importData.getUploadId();
        String fileName = importData.getFileName();
        List<Map<String, String>> rows = importData.getRows();

        // Example: Log the data
        System.out.println("Uploaded ID: " + uploadId);
        System.out.println("File Name: " + fileName);
        System.out.println("Rows:");
        rows.forEach(row -> System.out.println(row));

        // Additional processing logic here
    }
}
