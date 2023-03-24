import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Equipment } from './equipment';
import { environment } from 'src/environments/environment';

@Injectable({ providedIn: 'root' })
export class EquipmentService {
  private apiServerUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  public getEquipments(): Observable<Equipment[]> {
    return this.http.get<Equipment[]>(`${this.apiServerUrl}/pc_equipment/all`);
  }

  public addEquipment(equipment: Equipment): Observable<Equipment> {
    console.log(equipment);
    return this.http.post<Equipment>(
      `${this.apiServerUrl}/pc_equipment/add`,
      equipment
    );
  }

  public updateEquipment(equipment: Equipment): Observable<Equipment> {
    console.log(equipment);
    return this.http.put<Equipment>(
      `${this.apiServerUrl}/pc_equipment/update`,
      equipment
    );
  }

  public deleteEquipment(equipmentId: number): Observable<void> {
    return this.http.delete<void>(
      `${this.apiServerUrl}/pc_equipment/delete/${equipmentId}`
    );
  }
}
