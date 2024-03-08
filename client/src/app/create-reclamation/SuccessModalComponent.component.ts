import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatIconModule } from '@angular/material/icon';  // Add this import

@Component({
    selector: 'app-success-modal',
    template: `
        <div style="margin: 3em 2em; text-align: center;">
            <mat-icon class="success-icon">check_circle_outline</mat-icon>
            <p>Reclamation created successfully! <b>Name : {{data.owner}}</b> and <b>Payment ID: {{ data.paymentId }}</b> </p>
        </div>
    `,
    styleUrls: ['./create-reclamation.component.css'],
})
export class SuccessModalComponent {
    constructor(@Inject(MAT_DIALOG_DATA) public data: { paymentId: string, owner: String }) { }
}
