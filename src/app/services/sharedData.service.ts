import { Injectable } from "@angular/core";
import { BehaviorSubject, Subject } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class SharedDataService {
    bookListCount: any;

    constructor() { }

    public dataDetails: any = [];
    public dataDetails1: any = [];
    public subject = new Subject<any>();

    private messageSource = new BehaviorSubject(this.dataDetails);
    private relevanceSource = new BehaviorSubject(this.dataDetails1);
    

    currentMessage = this.messageSource.asObservable();
    changeMessage(message: string) {
        this.messageSource.next(message);
    }

    currentRelevance = this.relevanceSource.asObservable();
    changeRelevance(message : string){
        this.relevanceSource.next(message);
    }
}