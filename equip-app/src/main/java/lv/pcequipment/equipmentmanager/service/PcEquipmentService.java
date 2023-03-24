package lv.pcequipment.equipmentmanager.service;

import lv.pcequipment.equipmentmanager.exception.EquipmentNotFoundException;
import lv.pcequipment.equipmentmanager.model.PcEquipment;
import lv.pcequipment.equipmentmanager.repo.PcEquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PcEquipmentService {
    private final PcEquipmentRepo pcEquipmentRepo;

    @Autowired
    public PcEquipmentService(PcEquipmentRepo pcEquipmentRepo) {
        this.pcEquipmentRepo = pcEquipmentRepo;
    }

    public PcEquipment addPcEquipment(PcEquipment pcEquipment) {
        pcEquipment.setCreatedDate(new Date());
        return pcEquipmentRepo.save(pcEquipment);
    }

    public List<PcEquipment> findAllPcEquipment() {

        return pcEquipmentRepo.findAllByOrderByIdAsc();
    }

    public PcEquipment updatePcEquipment(PcEquipment pcEquipment) {
        return pcEquipmentRepo.save(pcEquipment);
    }

    public PcEquipment findPcEquipmentById(Long id) {
        return pcEquipmentRepo.findById(id).orElseThrow(() ->
                new EquipmentNotFoundException("Equipment by id " + id + "was not found"));
    }

    public void deletePcEquipment(Long id) {
        pcEquipmentRepo.deleteById(id);
    }
}
