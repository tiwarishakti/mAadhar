import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { map } from 'rxjs/operators';
import { registerdata } from './registerdata.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class PostsComponent implements OnInit {
  fetchedPosts: registerdata[] = [];
  backendurl = 'http://localhost:3000/posts';
  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.fetchPosts();
  }

  onCreatePost(postData: { title: string; content: string }, form: NgForm) {
    this.http.post(this.backendurl, postData).subscribe((responseData) => {
      console.log(responseData);
      this.fetchPosts();
      form.reset();
    });
  }
  fetchPosts() {
    this.http
      .get(this.backendurl)
      .pipe(
        map((responseData) => {
          const postsArray: PostData[] = [];
          for (const key in responseData) {
            var x = { ...responseData[key] };
            postsArray.push(x);
          }
          return postsArray;
        })
      )
      .subscribe((posts) => {
        this.fetchedPosts = posts;
      });
  }