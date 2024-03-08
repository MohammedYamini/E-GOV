import { Component, OnInit } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { ApiResponse, Reclamation } from 'app/reclamation.module';
import { FormsModule, NgForm } from '@angular/forms';
import { ReclamationService } from 'app/reclamation.service';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { MatDialog } from '@angular/material/dialog';
import { SuccessModalComponent } from './SuccessModalComponent.component';
import {Router} from "@angular/router"
@Component({
  selector: 'app-create-reclamation',
  templateUrl: './create-reclamation.component.html',
  styleUrls: ['./create-reclamation.component.css'],
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatDatepickerModule, FormsModule],
})
export class CreateReclamationComponent implements OnInit {

  reclamation: Reclamation = {
    id: undefined,
    matriculation_interior: undefined,
    matriculation_number: undefined,
    first_time_in_circulation: undefined,
    first_use_in_morocco: undefined,
    mutation: undefined,
    particular_vehicle: undefined,
    address: undefined,
    end_of_validity: undefined,
    type_of_usage: undefined,
    owner: undefined,
    payment_id: undefined
  }

  constructor(
    private ReclamationService: ReclamationService,
    private dialog: MatDialog,
    private router: Router
  ) {}

  ngOnInit(): void {

  }

  CreateReclamation(reclamationForm: NgForm): void {
    this.ReclamationService.createReclamation(this.reclamation).subscribe({
      next: (res: HttpResponse<ApiResponse>) => {
        console.log(res);
        reclamationForm.reset();
        const id_payment = res.body?.reclamation?.payment_id;
        const owenr = res.body?.reclamation?.owner;
        this.openSuccessModal(id_payment, owenr);
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
      },
    });
  }


  openSuccessModal(paymentId: String, owner: String): void {
    const dialogRef = this.dialog.open(SuccessModalComponent, {
      data: { paymentId, owner },
    });
    dialogRef.afterClosed().subscribe(() => {
      this.router.navigate(['/reclamation']);
    });
    setTimeout(() => {
      dialogRef.close();
    }, 3000);
  }
}
