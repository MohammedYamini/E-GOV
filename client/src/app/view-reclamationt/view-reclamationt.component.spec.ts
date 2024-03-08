import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewReclamationtComponent } from './view-reclamationt.component';

describe('ViewReclamationtComponent', () => {
  let component: ViewReclamationtComponent;
  let fixture: ComponentFixture<ViewReclamationtComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewReclamationtComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ViewReclamationtComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
