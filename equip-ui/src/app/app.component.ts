import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Equipment } from './equipment';
import { EquipmentService } from './equipment.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  public equipments: Equipment[] = [];
  public editEquipment: Equipment | undefined;
  public deleteEquipment: Equipment | undefined;

  constructor(private equipmentService: EquipmentService) {}
  ngOnInit() {
    this.getEquipments();
  }

  public getEquipments(): void {
    this.equipmentService.getEquipments().subscribe({
      next: (response: Equipment[]) => {
        this.equipments = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public onAddEquipment(addForm: NgForm): void {
    document.getElementById('add-employee-form-close-button')?.click();

    this.equipmentService.addEquipment(addForm.value).subscribe({
      next: (response: Equipment) => {
        console.log(response);
        this.getEquipments();
        addForm.reset();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public onUpdateEquipment(equipment: Equipment): void {
    console.log(equipment.createdDate);
    this.equipmentService.updateEquipment(equipment).subscribe({
      next: (response: Equipment) => {
        console.log(response);
        this.getEquipments();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public onDeleteEquipment(equipmentId: number): void {
    this.equipmentService.deleteEquipment(equipmentId).subscribe({
      next: (response: void) => {
        this.getEquipments();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      },
    });
  }

  public onOpenModal(mode: string, equipment?: Equipment): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEquipment');
    }
    if (mode === 'edit') {
      this.editEquipment = equipment;
      button.setAttribute('data-target', '#updateEquipment');
    }
    if (mode === 'delete') {
      this.deleteEquipment = equipment;
      button.setAttribute('data-target', '#deleteEquipment');
    }
    container?.appendChild(button);
    button.click();
  }
}
