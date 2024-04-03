package tn.esprit.pokerplanning.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprit.pokerplanning.Dto.UserDTO;
import tn.esprit.pokerplanning.Dto.MetadataDTO;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ImportDataDTO {
    private Long uploadId;
    private String fileName;
    private UserDTO user;
    private MetadataDTO metadata;
    private List<Map<String, String>> rows;
}
