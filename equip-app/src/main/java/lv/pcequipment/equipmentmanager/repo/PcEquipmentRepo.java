package lv.pcequipment.equipmentmanager.repo;

import lv.pcequipment.equipmentmanager.model.PcEquipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PcEquipmentRepo extends JpaRepository<PcEquipment, Long> {
    List<PcEquipment> findAllByOrderByIdAsc();
}
