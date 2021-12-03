package cn.hommin.demo.nestedtransaction.serivce;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import cn.hommin.demo.nestedtransaction.dao.entity.Four;
import cn.hommin.demo.nestedtransaction.dao.entity.One;
import cn.hommin.demo.nestedtransaction.dao.entity.Three;
import cn.hommin.demo.nestedtransaction.dao.entity.Two;
import cn.hommin.demo.nestedtransaction.dao.mapper.FourMapper;
import cn.hommin.demo.nestedtransaction.dao.mapper.OneMapper;
import cn.hommin.demo.nestedtransaction.dao.mapper.ThreeMapper;
import cn.hommin.demo.nestedtransaction.dao.mapper.TwoMapper;

@SpringBootTest
//@RunWith(SpringRunner.class)
@TestPropertySource("/application.yml")
class OuterNewServiceTest {

  @Autowired
  private OuterNewService outerService;

  @Autowired
  private OneMapper oneMapper;
  @Autowired
  private TwoMapper twoMapper;
  @Autowired
  private ThreeMapper threeMapper;
  @Autowired
  private FourMapper fourMapper;

  private List<Integer> list = new ArrayList(){{
    add(1);
  }};

  @BeforeEach
  public void setup() {
    oneMapper.delete(null);
    twoMapper.delete(null);
    threeMapper.delete(null);
    fourMapper.delete(null);
  }

  @AfterEach
  public void af(){
    System.out.println("-----------------one list print-----------------");
    List<One> ones = oneMapper.selectList(null);
    ones.forEach(System.out::println);
    System.out.println("-----------------two list print-----------------");
    List<Two> twos = twoMapper.selectList(null);
    twos.forEach(System.out::println);
    System.out.println("-----------------three list print-----------------");
    List<Three> threes = threeMapper.selectList(null);
    threes.forEach(System.out::println);
    System.out.println("-----------------four list print-----------------");
    List<Four> fours = fourMapper.selectList(null);
    fours.forEach(System.out::println);
    System.out.println("-----------------print end-----------------");
  }

  @Test
  void defaultAndTrueAndDefaultAndTrue() {
    outerService.newAndTrueAndDefaultAndTrue();
  }

  @Test
  void defaultAndTrueAndDefaultAndError() {
    outerService.newAndTrueAndDefaultAndError();
  }

  @Test
  void defaultAndTrueAndNewAndTrue() {
    outerService.newAndTrueAndNewAndTrue();
  }

  @Test
  void defaultAndTrueAndNewAndError() {
    outerService.newAndTrueAndNewAndError();
  }

  @Test
  void defaultAndErrorAndDefaultAndTrue() {
    outerService.newAndErrorAndDefaultAndTrue();
  }

  @Test
  void defaultAndErrorAndDefaultAndError() {
    outerService.newAndErrorAndDefaultAndError();
  }

  @Test
  void defaultAndErrorAndNewAndTrue() {
    outerService.newAndErrorAndNewAndTrue();
  }

  @Test
  void defaultAndErrorAndNewAndError() {
    outerService.newAndErrorAndNewAndError();
  }

  @Test
  void defaultAndTryAndDefaultAndTrue() {
    outerService.newAndTryAndDefaultAndTrue();
  }

  @Test
  void defaultAndTryAndDefaultAndError() {
    outerService.newAndTryAndDefaultAndError();
  }

  @Test
  void defaultAndTryAndNewAndTrue() {
    outerService.newAndTryAndNewAndTrue();
  }

  @Test
  void defaultAndTryAndNewAndError() {
    outerService.newAndTryAndNewAndError();
  }
}