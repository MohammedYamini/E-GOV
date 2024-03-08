import { Component, ViewEncapsulation, OnInit } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { ReclamationService } from 'app/reclamation.service';
import { Reclamation } from 'app/reclamation.module';

@Component({
    selector: 'example',
    templateUrl: './example.component.html',
    encapsulation: ViewEncapsulation.None,
})
export class ExampleComponent implements OnInit {

    dataSource: Reclamation[] = [];

    displayedColumns: String[] = [
        'id',
        'matriculation_interior',
        'matriculation_number',
        'first_time_in_circulation',
        'first_use_in_morocco',
        'mutation',
        'particular_vehicle',
        'address',
        'end_of_validity',
        'type_of_usage',
        'owner',
        'payment_id',
    ]

    constructor(private ReclamationService: ReclamationService) {
        this.IndexReclamation()
    }

    ngOnInit(): void {

    }

    IndexReclamation(): void {
        this.ReclamationService.indexReclamation().subscribe({
            next: (res: any) => {
                const reclamations: Reclamation[] = res.reclamations;
                this.dataSource = reclamations.map(reclamation => {
                    if (typeof reclamation.first_time_in_circulation === 'string') {
                        reclamation.first_time_in_circulation = new Date(reclamation.first_time_in_circulation);
                    }
                    reclamation.first_time_in_circulation = this.formatDate(reclamation.first_time_in_circulation);

                    if (typeof reclamation.first_use_in_morocco === 'string') {
                        reclamation.first_use_in_morocco = new Date(reclamation.first_use_in_morocco);
                    }
                    reclamation.first_use_in_morocco = this.formatDate(reclamation.first_use_in_morocco);

                    if (typeof reclamation.mutation === 'string') {
                        reclamation.mutation = new Date(reclamation.mutation);
                    }
                    reclamation.mutation = this.formatDate(reclamation.mutation);

                    if (typeof reclamation.end_of_validity === 'string') {
                        reclamation.end_of_validity = new Date(reclamation.end_of_validity);
                    }
                    reclamation.end_of_validity = this.formatDate(reclamation.end_of_validity);
                    return reclamation;
                });

            },
            error: (err: HttpErrorResponse) => {
                console.log(err);
            },
        });
    }

    formatDate(date: Date | null): string {
        if (!date) {
            return '';
        }

        const parsedDate = typeof date === 'string' ? new Date(date) : date;

        if (isNaN(parsedDate.getTime())) {
            return '';
        }

        return `${parsedDate.getFullYear()}-${this.padZero(parsedDate.getMonth() + 1)}-${this.padZero(parsedDate.getDate())}`;
    }


    padZero(value: number): string {
        return value < 10 ? `0${value}` : `${value}`;
    }

}
