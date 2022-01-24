import { Injectable } from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpHeaders,
  HttpErrorResponse
} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import { AuthentificationService } from './auth.service';
import {catchError, retry} from "rxjs/operators";
import {Router} from "@angular/router";

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {

  constructor(private authenticationService: AuthentificationService,private router:Router) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.authenticationService.isUserLoggedIn() && req.url.indexOf('basicauth') === -1) {
      const authReq = req.clone({
        headers: new HttpHeaders({
          'Content-Type': 'application/json',//multipart/form-data; boundary=----WebKitFormBoundaryJ6Q2VG5TMUfGoSqg => error code 400 imageFile nto found+ Demands doesnt work!.
          'Authorization': `${sessionStorage.getItem('acces_token')}`
        })
      });
      //do an if to change header?
      return next.handle(authReq)
          .pipe(

              retry(1),

              catchError((error: HttpErrorResponse) => {

                let errorMessage = '';

                if (error.error instanceof ErrorEvent) {

                  // client-side error

                  errorMessage = `Error: ${error.error.message}`;

                } else {

                  // server-side error
                    errorMessage = `Error Code: ${error.status}`
                }

                window.alert(errorMessage);

                return throwError(errorMessage);

              }));
    } else {
      return next.handle(req)
          .pipe(

          retry(1),

          catchError((error: HttpErrorResponse) => {

            let errorMessage = '';

            if (error.error instanceof ErrorEvent) {

              // client-side error

              errorMessage = `Error: ${error.error.message}`;

            } else {

              // server-side error

              errorMessage = `Error Code: ${error.status}`;

            }

            window.alert(errorMessage);

            return throwError(errorMessage);

          }));;
    }
  }
}
