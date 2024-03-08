import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ReclamationService } from 'app/reclamation.service';

@Component({
    selector: 'app-view-reclamationt',
    templateUrl: './view-reclamationt.component.html',
    styleUrls: ['./view-reclamationt.component.scss']
})
export class ViewReclamationComponent implements OnInit {
    reclamation_id: number;
    reclamation_details: any;

    constructor(
        private route: ActivatedRoute,
        private reclamationService: ReclamationService
    ) { }

    ngOnInit(): void {
        this.route.params.subscribe((params) => {
            this.reclamation_id = +params['id'];
            this.ReclamationDetails();
        });
    }

    ReclamationDetails(): void {
        this.reclamationService.ViewReclamation(this.reclamation_id).subscribe({
            next: (res) => {
                this.reclamation_details = res.body.reclamation;

            },
            error: (err) => {
                console.error(err);
            },
        });
    }
}
