import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl = environment.baseUrl;

  constructor(private http : HttpClient ) { }

  public getEmployeesList(): Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.baseUrl}/api/employees`);
  }

  public addEmployee(employee : Employee) : Observable<Employee>{
    return this.http.post<Employee>(`${this.baseUrl}/api/employees`,employee);
  }

  public updateEmployee(employee : Employee) :Observable<Employee>{
    return this.http.put<Employee>(`${this.baseUrl}/api/employees`,employee);
  }

  public deleteEmployee(id : number) : Observable<Object>{
    return this.http.delete<Object>(`${this.baseUrl}/api/employees/${id}`);
  }

  public getEmployeeById(id : number) : Observable<Employee>{
    return this.http.get<Employee>(`${this.baseUrl}/api/employees/${id}`);
  }



}
