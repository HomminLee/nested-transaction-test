package cn.hommin.demo.nestedtransaction.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import cn.hommin.demo.nestedtransaction.dao.mapper.FourMapper;
import cn.hommin.demo.nestedtransaction.dao.mapper.ThreeMapper;
import cn.hommin.demo.nestedtransaction.dao.entity.Four;
import cn.hommin.demo.nestedtransaction.dao.entity.Three;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hommin
 */
@Slf4j
@Component
public class OuterService {

  @Autowired
  private ThreeMapper threeMapper;
  @Autowired
  private FourMapper fourMapper;
  @Autowired
  private InnerService innerService;


  @Transactional
  public void defaultAndTrueAndDefaultAndTrue() {
    threeMapper.insert(new Three(1, "defaultAndTrueAndDefaultAndTrue"));
    innerService.defaultAndTrue();
    fourMapper.insert(new Four(1, "defaultAndTrueAndDefaultAndTrue"));
  }

  @Transactional
  public void defaultAndTrueAndDefaultAndError() {
    threeMapper.insert(new Three(1, "defaultAndTrueAndDefaultAndError"));
    innerService.defaultAndError();
    fourMapper.insert(new Four(1, "defaultAndTrueAndDefaultAndError"));
  }

  @Transactional
  public void defaultAndTrueAndNewAndTrue() {
    threeMapper.insert(new Three(1, "defaultAndTrueAndNewAndTrue"));
    innerService.newAndTrue();
    fourMapper.insert(new Four(1, "defaultAndTrueAndNewAndTrue"));
  }

  @Transactional
  public void defaultAndTrueAndNewAndError() {
    threeMapper.insert(new Three(1, "defaultAndTrueAndNewAndError"));
    innerService.newAndError();
    fourMapper.insert(new Four(1, "defaultAndTrueAndNewAndError"));
  }





  @Transactional
  public void defaultAndErrorAndDefaultAndTrue() {
    threeMapper.insert(new Three(1, "defaultAndErrorAndDefaultAndTrue"));
    innerService.defaultAndTrue();
    int i = 1 / 0;
    fourMapper.insert(new Four(1, "defaultAndErrorAndDefaultAndTrue"));
  }

  @Transactional
  public void defaultAndErrorAndDefaultAndError() {
    threeMapper.insert(new Three(1, "defaultAndErrorAndDefaultAndError"));
    innerService.defaultAndError();
    int i = 1 / 0;
    fourMapper.insert(new Four(1, "defaultAndErrorAndDefaultAndError"));
  }

  @Transactional
  public void defaultAndErrorAndNewAndTrue() {
    threeMapper.insert(new Three(1, "defaultAndErrorAndNewAndTrue"));
    innerService.newAndTrue();
    int i = 1 / 0;
    fourMapper.insert(new Four(1, "defaultAndErrorAndNewAndTrue"));
  }

  @Transactional
  public void defaultAndErrorAndNewAndError() {
    threeMapper.insert(new Three(1, "defaultAndErrorAndNewAndError"));
    innerService.newAndError();
    int i = 1 / 0;
    fourMapper.insert(new Four(1, "defaultAndErrorAndNewAndError"));
  }


  @Transactional
  public void defaultAndTryAndDefaultAndTrue() {
    threeMapper.insert(new Three(1, "defaultAndTryAndDefaultAndTrue"));
    try {
      innerService.defaultAndTrue();
    } catch (Exception e) {
      log.info("catch innerService exception, e={}", e.getMessage());
    }
    fourMapper.insert(new Four(1, "defaultAndTryAndDefaultAndTrue"));
  }

  @Transactional
  public void defaultAndTryAndDefaultAndError() {
    threeMapper.insert(new Three(1, "defaultAndTryAndDefaultAndError"));
    try {
      innerService.defaultAndError();
    } catch (Exception e) {
      log.info("catch innerService exception, e={}", e.getMessage());
    }
    fourMapper.insert(new Four(1, "defaultAndTryAndDefaultAndError"));
  }

  @Transactional
  public void defaultAndTryAndNewAndTrue() {
    threeMapper.insert(new Three(1, "defaultAndTryAndNewAndTrue"));
    try {
      innerService.newAndTrue();
    } catch (Exception e) {
      log.info("catch innerService exception, e={}", e.getMessage());
    }
    fourMapper.insert(new Four(1, "defaultAndTryAndNewAndTrue"));
  }

  @Transactional
  public void defaultAndTryAndNewAndError() {
    threeMapper.insert(new Three(1, "defaultAndTryAndNewAndError"));
    try {
      innerService.newAndError();
    } catch (Exception e) {
      log.info("catch innerService exception, e={}", e.getMessage());
    }
    fourMapper.insert(new Four(1, "defaultAndTryAndNewAndError"));
  }

}
