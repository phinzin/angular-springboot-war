import { Injectable } from '@angular/core';
import { Book } from './book';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class BookServiceService {
  private booksUrl: string;
  constructor(private http: HttpClient) { 
    this.booksUrl = 'http://localhost:8080/app/api/books';
  }

  public findAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.booksUrl);
  }

  public save(user: Book) {
    return this.http.post<Book>(this.booksUrl, user);
  }
}
