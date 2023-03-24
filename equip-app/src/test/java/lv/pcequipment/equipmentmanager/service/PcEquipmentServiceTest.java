package lv.pcequipment.equipmentmanager.service;

import lv.pcequipment.equipmentmanager.model.PcEquipment;
import lv.pcequipment.equipmentmanager.repo.PcEquipmentRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PcEquipmentServiceTest {

    @Mock
    private PcEquipmentRepo pcEquipmentRepo;
    private PcEquipmentService pcEquipmentService;

    @BeforeEach
    void setUp() {
        pcEquipmentService = new PcEquipmentService(pcEquipmentRepo);
    }

    @Test
    void canAddPcEquipment() {
        PcEquipment pcEquipment = new PcEquipment(22L,
                "Logitech", "Keyboard", false, "randomText");

        pcEquipmentService.addPcEquipment(pcEquipment);
        ArgumentCaptor<PcEquipment> pcEquipmentArgumentCaptor = ArgumentCaptor.forClass(PcEquipment.class);
        verify(pcEquipmentRepo).save(pcEquipmentArgumentCaptor.capture());

        PcEquipment capturedPcEquipment = pcEquipmentArgumentCaptor.getValue();

        assertThat(capturedPcEquipment).isEqualTo(pcEquipment);
    }

    @Test
    void canFindAllPcEquipment() {
        pcEquipmentService.findAllPcEquipment();
        verify(pcEquipmentRepo).findAllByOrderByIdAsc();
    }

    @Test
    void canUpdatePcEquipment() {
        PcEquipment pcEquipmentToUpdate = new PcEquipment(22l,
                "Logitech", "Keyboard", false, "randomText");


        pcEquipmentToUpdate.setModel("UpdatedModel");
        pcEquipmentToUpdate.setType("UpdateType");
        pcEquipmentToUpdate.setStatus(true);
        pcEquipmentToUpdate.setComment("UpdatedText");

        pcEquipmentService.updatePcEquipment(pcEquipmentToUpdate);

        verify(pcEquipmentRepo).save(pcEquipmentToUpdate);
    }

    @Test
    void canFindPcEquipmentById() {
        long idToFind = 22L;
        PcEquipment pcEquipmentToFind = new PcEquipment(idToFind,
                "Logitech", "Keyboard", false, "randomText");

        when(pcEquipmentRepo.findById(idToFind)).thenReturn(Optional.of(pcEquipmentToFind));
        PcEquipment foundPcEquipment = pcEquipmentService.findPcEquipmentById(idToFind);
        verify(pcEquipmentRepo).findById(idToFind);
        assertThat(foundPcEquipment).isEqualTo(pcEquipmentToFind);
    }

    @Test
    void canDeletePcEquipment() {
        long idToDelete = 22L;
        PcEquipment pcEquipmentToDelete = new PcEquipment(idToDelete,
                "Logitech", "Keyboard", false, "randomText");
        pcEquipmentService.deletePcEquipment(idToDelete);
        verify(pcEquipmentRepo).deleteById(idToDelete);
        ArgumentCaptor<Long> idArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(pcEquipmentRepo).deleteById(idArgumentCaptor.capture());
        assertThat(idArgumentCaptor.getValue()).isEqualTo(idToDelete);
    }
}