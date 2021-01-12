import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { BookListService } from 'src/app/services/bookList.service';
import { SharedDataService } from 'src/app/services/sharedData.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  bookList: any[] = [];
  bookListCount: any;
  ascendingPriceBookList: any;
  descendingPricebookList: any;
  relevanceValue: any;
  constructor(
    private bookListService: BookListService,
    private router: Router,
    private sharedDataService: SharedDataService,
    private toastr: ToastrService
  ) {

  }

  ngOnInit(): void {
    this.getBookListData();
    this.getBookListCount();
  }
  getBookListData() {
    this.bookListService.getAllBooksList().subscribe(response => {
      this.bookList = response.data;
      console.log("response BookList", this.bookList);
    });
  }

  getBookListCount() {
    this.bookListService.getAllBooksListCount().subscribe(response => {
      this.bookListCount = response.data;
    })
  }

  getListOfBookByRelevance(event: any) {
    console.log("relevance value: ", event.value);
    this.relevanceValue = event.value
    this.ascendingPriceBookList = this.sortByRelevance[0];
    this.descendingPricebookList = this.sortByRelevance[1];


    if (this.relevanceValue == this.ascendingPriceBookList) {
      this.bookListService.getAllBooksListCountAscendingOrder().subscribe(response => {
        if (response.statusCode == 200) {
          this.toastr.success(response.message);
          this.bookList = response.data;
        } else {
          this.toastr.error(response.message);
        }
      })
    } else if (this.relevanceValue == this.descendingPricebookList) {
      this.bookListService.getAllBooksListCountDescendingOrder().subscribe(response => {
        if (response.statusCode == 200) {
          this.toastr.success(response.message);
          this.bookList = response.data;
        } else {
          this.toastr.error(response.message);
        }
      })
    }

  }

  sortByRelevance: string[] = [
    'Price: Low to High', 'Price: High to Low', 'Newest Arrivals'
  ]




}
