import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SharedDataService } from 'src/app/services/sharedData.service';

@Component({
  selector: 'app-drop',
  templateUrl: './relevance.component.html',
  styleUrls: ['./relevance.component.scss']
})
export class RelevanceComponent implements OnInit {

  bookListCount : any;
  bookRelevanceDetail !: FormGroup;
  relevance: any;
  constructor(
    private sharedDataService : SharedDataService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {

   
   console.log();
  
    console.log("relevance :" , this.relevance);
  }
  
  
}
