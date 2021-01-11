import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/User';

@Component({
  selector: 'app-signform',
  templateUrl: './signform.component.html',
  styleUrls: ['./signform.component.scss']
})
export class SignformComponent implements OnInit {
user:User = new User();
  constructor() { }

  ngOnInit(): void {
  }

}
