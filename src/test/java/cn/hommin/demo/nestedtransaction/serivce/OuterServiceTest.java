package cn.hommin.demo.nestedtransaction.serivce;

import cn.hommin.demo.nestedtransaction.dao.entity.Four;
import cn.hommin.demo.nestedtransaction.dao.entity.One;
import cn.hommin.demo.nestedtransaction.dao.entity.Three;
import cn.hommin.demo.nestedtransaction.dao.entity.Two;
import cn.hommin.demo.nestedtransaction.dao.mapper.FourMapper;
import cn.hommin.demo.nestedtransaction.dao.mapper.OneMapper;
import cn.hommin.demo.nestedtransaction.dao.mapper.ThreeMapper;
import cn.hommin.demo.nestedtransaction.dao.mapper.TwoMapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
//@RunWith(SpringRunner.class)
@TestPropertySource("/application.yml")
class OuterServiceTest {

  @Autowired
  private OuterService outerService;

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
    outerService.defaultAndTrueAndDefaultAndTrue();
  }

  @Test
  void defaultAndTrueAndDefaultAndError() {
    outerService.defaultAndTrueAndDefaultAndError();
  }

  @Test
  void defaultAndTrueAndNewAndTrue() {
    outerService.defaultAndTrueAndNewAndTrue();
  }

  @Test
  void defaultAndTrueAndNewAndError() {
    outerService.defaultAndTrueAndNewAndError();
  }

  @Test
  void defaultAndErrorAndDefaultAndTrue() {
    outerService.defaultAndErrorAndDefaultAndTrue();
  }

  @Test
  void defaultAndErrorAndDefaultAndError() {
    outerService.defaultAndErrorAndDefaultAndError();
  }

  @Test
  void defaultAndErrorAndNewAndTrue() {
    outerService.defaultAndErrorAndNewAndTrue();
  }

  @Test
  void defaultAndErrorAndNewAndError() {
    outerService.defaultAndErrorAndNewAndError();
  }

  @Test
  void defaultAndTryAndDefaultAndTrue() {
    outerService.defaultAndTryAndDefaultAndTrue();
  }

  @Test
  void defaultAndTryAndDefaultAndError() {
    outerService.defaultAndTryAndDefaultAndError();
  }

  @Test
  void defaultAndTryAndNewAndTrue() {
    outerService.defaultAndTryAndNewAndTrue();
  }

  @Test
  void defaultAndTryAndNewAndError() {
    outerService.defaultAndTryAndNewAndError();
  }
}