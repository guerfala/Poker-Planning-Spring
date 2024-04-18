package tn.esprit.pokerplaning.Controllers.packCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.pokerplaning.Entities.packCard.Pack;
import tn.esprit.pokerplaning.Services.packCard.PackService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RequestMapping("/packs")
@RestController
public class PackController {
    @Autowired
    private PackService service;
    @PostMapping("/addPack")
    public Pack addPack (@RequestBody Pack Pack){
        return service.savePack(Pack);
    }
    @PostMapping("/addsPack")
    public List<Pack> addPack (@RequestBody List <Pack> Pack){
        return service.savePack(Pack);
    }
    @GetMapping("/Pack")
    public List<Pack>findAll(){
        return service.getPack();
    }
    @GetMapping("/Packid/{id}")
    public Pack findPackById(@PathVariable Long id){
        return service.getPackById(id);
    }
    @GetMapping("/Pack/{name}")
    public Pack findPackByName(@PathVariable String name){
        return service.getPackByName(name);
    }

    @PutMapping("/updatePack/{id}")
    public Pack updatePack (@RequestBody Pack pack,@PathVariable Long id)
    {
        pack.setPackId(id);
        return service.updatePack(pack);
    }

    @DeleteMapping("/Pack/{id}")
    public ResponseEntity<Map<String, Boolean>> deletepack(@PathVariable Long id){
        Pack pack = service.getPackById(id);
            service.deletePack(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return  ResponseEntity.ok(response);

    }

}
