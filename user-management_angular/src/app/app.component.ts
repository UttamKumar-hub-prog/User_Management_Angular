import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UserService } from './user.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'user-management';
  constructor(private readonly us: UserService) {}

  users: any;
  formHeader: string = 'Add user';
  id : any;
  name :  any;
  email : any;
  showForm = false;

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.us.fetchUser().subscribe(
      (data) => {
        this.users = data;
      },
      (error) => {
        console.log('Error this page');
      }
    );
  }

  deleteUser(id: number) {
    this.us.deleteUser(id).subscribe((res) => {
      console.log('deleted Succesfully : ' + id);
      this.getUsers();
    });
  }

  openForm(data: any = null) {
    this.clearForm()
    this.showForm = true;
    if (data) {
      this.name = data.name;
      this.email = data.email;
      this.id = data.id;
      this.formHeader = 'Edit User';
    } else {
      this.id = null;
      this.formHeader = 'Add User';
    }
  }

  closeForm() {
    this.showForm = false;
    this.clearForm();
  }
  clearForm() {
    this.name = null;
    this.email = null;
  }

  saveUser() {
    this.showForm=false;
    let body={
      id:this.id,
      name: this.name,
      email: this.email
    }
    if(this.id){
      body['id']=this.id;
      this.us.putMobile(this.id,body).subscribe(
        (res)=>{
          this.getUsers();
          this.closeForm();
        }
      );
    }
    else{
      this.us.postMobile(body).subscribe(
        (res)=>{
          this.getUsers();
          this.closeForm();
        }
      );
    }
  }
}
