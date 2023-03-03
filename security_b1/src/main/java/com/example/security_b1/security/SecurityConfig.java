package com.example.security_b1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//@Configuration là một Annotation (chú thích) trong Spring Framework được sử dụng để đánh dấu một lớp và chỉ định rằng lớp đó là một configuration class (lớp cấu hình) trong Spring. Các configuration class được sử dụng để cung cấp các thông tin cấu hình cho Spring
@Configuration

@EnableWebSecurity
// là một Annotation trong Spring Security được sử dụng để kích hoạt tính năng bảo mật trên ứng dụng web
//         nó sẽ được tạo ra như là một FilterChainProxy, và các filter được thêm vào filter chain để xử lý các yêu cầu HTTP tới ứng dụng.
//         Các filter này được sử dụng để xác thực (authentication) và phân quyền (authorization) các yêu cầu HTTP, và đảm bảo rằng chỉ có người dùng có quyền được truy cập
public class SecurityConfig {
//    @Bean là một annotation được sử dụng để xác định một phương thức trong một lớp là một bean, tức là một đối tượng được quản lý bởi Spring IoC Container. Khi một bean được đăng ký với container, nó có thể được sử dụng trong toàn bộ ứng dụng, và các bean khác có thể tùy biến và sử dụng nó.
    @Bean
//    UserDetailsService là một interface trong Spring Security, được sử dụng để cung cấp thông tin về người dùng (username, password, authorities) cho quá trình xác thực (authentication) và phân quyền (authorization).
    public UserDetailsService userDetailsService(){
//var là một từ khóa (keyword) được giới thiệu từ Java 10, được sử dụng để khai báo biến một cách ngắn gọn và tự động suy kiểu (type inference). Khi sử dụng var để khai báo biến, Java Compiler sẽ tự động suy ra kiểu dữ liệu của biến đó dựa trên giá trị được gán vào biến.
//.withUsername() là một phương thức trong lớp User.UserBuilder của Spring Security, được sử dụng để thiết lập tên người dùng (username) cho đối tượng UserDetails khi tạo mới.
//.authorities() là một phương thức được sử dụng để thiết lập danh sách các quyền (authorities) của người dùng
        var user1 = User.withUsername("thaipham").password("123").authorities("read").build();
        var user2 = User.withUsername("thaipham2").password("123456").authorities("read").build();
//        InMemoryUserDetailsManager là một lớp trong Spring Security được sử dụng để lưu trữ thông tin người dùng trong bộ nhớ của ứng dụng. Lớp này cung cấp các phương thức để tạo mới và truy vấn thông tin người dùng.
        return new InMemoryUserDetailsManager(user1,user2);
    }
    @Bean
//    PasswordEncoder là một interface trong Spring Security được sử dụng để mã hóa mật khẩu của người dùng để lưu trữ trong cơ sở dữ liệu hoặc sử dụng để xác thực người dùng khi đăng nhập.
    public PasswordEncoder passwordEncoder(){
//        NoOpPasswordEncoder là một implement của interface PasswordEncoder, nhưng nó không mã hóa mật khẩu của người dùng và không bảo đảm tính an toàn, mật khẩu của người dùng sẽ được lưu trữ dưới dạng văn bản thuần, mà không được mã hóa.
//getInstance() là một method trong Java để trả về một instance của một lớp được định nghĩa bởi lớp cụ thể đó. Method này được sử dụng khi bạn muốn tạo ra một đối tượng từ một lớp, nhưng không muốn tạo ra nhiều đối tượng khác nhau trong quá trình thực thi của chương trình.
        return NoOpPasswordEncoder.getInstance();
    }
}
