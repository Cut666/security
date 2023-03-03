package com.example.security_b1.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
//Annotation này được sử dụng để tự động tạo ra một constructor với các tham số (parameters) tương ứng với tất cả các trường (fields) trong lớp.
@AllArgsConstructor
//Annotation này được sử dụng để tự động tạo các phương thức getter cho các trường trong lớp,giúp ta truy cập và lấy giá trị của trường đó
@Getter
//được sử dụng để tự động tạo các phương thức setter cho các trường trong lớp, giúp ta cập nhật giá trị của trường đó một cách dễ dàng hơn.
@Setter
public class Product {
//    Khi một trường hoặc phương thức được đánh dấu là private, nó chỉ có thể được truy cập từ bên trong cùng một lớp, và không thể được truy cập từ bên ngoài lớp đó.
    private String name;
    private double price;
}

