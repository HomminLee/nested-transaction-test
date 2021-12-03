package cn.hommin.demo.nestedtransaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages={"cn.hommin.demo.nestedtransaction.dao.mapper"})
public class NestedTransactionTestApplication {

  public static void main(String[] args) {
    SpringApplication.run(NestedTransactionTestApplication.class, args);
  }

}
