//khai báo địa chỉ package
package com.example.security_b1.controller;
//"import" được sử dụng để khai báo rằng chương trình đang sử dụng một class được định nghĩa trong một package khác.
import com.example.security_b1.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

//được sử dụng để đánh dấu rằng một class sẽ được sử dụng để xử lý các yêu cầu HTTP đến từ client và trả về kết quả tương ứng.
@RestController

//Đây là một annotation trong Spring Framework của Java, được sử dụng để ánh xạ một phương thức xử lý yêu cầu HTTP tới một URL cụ thể.
@RequestMapping("/api")

//"public" là một access modifier (phạm vi truy cập) trong Java, chỉ định rằng class có thể được truy cập từ bất kỳ đâu trong chương trình.
//        "class" là một từ khóa trong Java, chỉ định rằng đây là một định nghĩa class.
public class APIController {
//    thường dùng để lấy dữ liệu
    @GetMapping("/products")
//    ta đang khai báo rằng phương thức đó sẽ trả về một danh sách các đối tượng của lớp Product.
//    "getProducts()" tên phương thức
    public List<Product> getProducts(){
//để tạo ra 1 đối tượng kiểu danh sách product
//"ArrayList<>()" sử dụng constructor mặc định của lớp ArrayList để tạo ra một đối tượng ArrayList mới, có thể lưu trữ các phần tử
        List<Product> result = new ArrayList<>();
//được sử dụng để thêm một đối tượng sản phẩm mới vào danh sách (list) các sản phẩm đã được khởi tạo trước đó.
//new Product() tạo một đối tượng mới
//.add để thêm đối tượng mới vào danh sách
//        dấu (.) được dùng để gọi phương thức add
        result.add(new Product("sách", 15000));
        result.add(new Product("vở", 5000));
        result.add(new Product("sổ", 20000));
//        trả về đối tượng result
        return result;
    }

}
