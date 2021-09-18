import { HttpErrorResponse } from '@angular/common/http';
import { asLiteral } from '@angular/compiler/src/render3/view/util';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {

  employee : Employee = new Employee();

  constructor(private employeeService :EmployeeService,
    private router : Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.employeeService.addEmployee(this.employee).subscribe(
      (response : Employee)=>{
        this.employee = response;
        alert('Employee Added Successfully '+this.employee.firstName);
        this.gotoEmployeeList();
      },
      (error:HttpErrorResponse)=>{
        alert(error.message);
      }
    )
  }

  gotoEmployeeList(){
    this.router.navigate(["/employees"]);
  }

}
