import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RelevanceComponent } from './relevance.component';

describe('RelevanceComponent', () => {
  let component: RelevanceComponent;
  let fixture: ComponentFixture<RelevanceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RelevanceComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RelevanceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
