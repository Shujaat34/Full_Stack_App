import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees : Employee[] = [];
  constructor(private employeeService : EmployeeService, private router : Router) { }

  ngOnInit(): void {
   this.getEmployees();
  }

  private getEmployees() : void{
    this.employeeService.getEmployeesList().subscribe(
      (response: Employee[]) => {
        this.employees = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  deleteEmployee(id : number){
    this.employeeService.deleteEmployee(id).subscribe((response : Object)=>{
      alert('Employee Deleted Successfully');
      this.getEmployees();
    },(error : HttpErrorResponse)=>{
      alert(error.message);
    });
  }

  employeeDetails(id : number){
    this.router.navigate(['employee-details',id]);
  }

  updateEmployee(id : number){
    //Page Call
    this.router.navigate(['update-employee',id]);
  }

}
