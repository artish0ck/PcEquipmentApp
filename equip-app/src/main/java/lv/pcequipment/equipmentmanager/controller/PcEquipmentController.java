package lv.pcequipment.equipmentmanager.controller;

import lv.pcequipment.equipmentmanager.model.PcEquipment;
import lv.pcequipment.equipmentmanager.service.PcEquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pc_equipment")
public class PcEquipmentController {
    private final PcEquipmentService pcEquipmentService;

    public PcEquipmentController(PcEquipmentService pcEquipmentService) {
        this.pcEquipmentService = pcEquipmentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PcEquipment>> getAllPcEquipment() {
        List<PcEquipment> pcEquipmentList = pcEquipmentService.findAllPcEquipment();
        return new ResponseEntity<>(pcEquipmentList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PcEquipment> getPcEquipmentById(@PathVariable("id") Long id) {
        PcEquipment pcEquipment = pcEquipmentService.findPcEquipmentById(id);
        return new ResponseEntity<>(pcEquipment, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PcEquipment> addPcEquipment(@RequestBody PcEquipment pcEquipment) {
        PcEquipment newPcEquipment = pcEquipmentService.addPcEquipment(pcEquipment);
        return new ResponseEntity<>(newPcEquipment, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PcEquipment> updatePcEquipment(@RequestBody PcEquipment pcEquipment) {
        PcEquipment updatePcEquipment = pcEquipmentService.updatePcEquipment(pcEquipment);
        return new ResponseEntity<>(updatePcEquipment, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePcEquipment(@PathVariable("id") Long id) {
        pcEquipmentService.deletePcEquipment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
