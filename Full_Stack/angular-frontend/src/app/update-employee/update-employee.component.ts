import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {
  id : number = null!;
  employee : Employee = new Employee();
  constructor(private employeeService : EmployeeService,
    private rout : ActivatedRoute , private router : Router) { }

  ngOnInit(): void {
    this.id = this.rout.snapshot.params['id'];
    this.employeeService.getEmployeeById(this.id).subscribe(
      (response : Employee)=>{
        this.employee = response;
      }, 
      (error : HttpErrorResponse) => {
        console.log(error.message);
      }
    );
  }

  onSubmit(){
 
    this.employeeService.updateEmployee(this.employee).subscribe(
      (response : Employee)=>{
        alert('Employee Updated Successfully '+response.firstName);
        this.gotoEmployeeList();
      },
      (error : HttpErrorResponse)=>{
        console.log("Error Occured "+error.message);
      }
    );
  }

  gotoEmployeeList(){
    this.router.navigate(["/employees"]);
  }

}
