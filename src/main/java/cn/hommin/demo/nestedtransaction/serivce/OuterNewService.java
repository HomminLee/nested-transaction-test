package cn.hommin.demo.nestedtransaction.serivce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
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
public class OuterNewService {

  @Autowired
  private ThreeMapper threeMapper;
  @Autowired
  private FourMapper fourMapper;
  @Autowired
  private InnerService innerService;


  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndTrueAndDefaultAndTrue() {
    threeMapper.insert(new Three(1, "newAndTrueAndDefaultAndTrue"));
    innerService.defaultAndTrue();
    fourMapper.insert(new Four(1, "newAndTrueAndDefaultAndTrue"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndTrueAndDefaultAndError() {
    threeMapper.insert(new Three(1, "newAndTrueAndDefaultAndError"));
    innerService.defaultAndError();
    fourMapper.insert(new Four(1, "newAndTrueAndDefaultAndError"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndTrueAndNewAndTrue() {
    threeMapper.insert(new Three(1, "newAndTrueAndNewAndTrue"));
    innerService.newAndTrue();
    fourMapper.insert(new Four(1, "newAndTrueAndNewAndTrue"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndTrueAndNewAndError() {
    threeMapper.insert(new Three(1, "newAndTrueAndNewAndError"));
    innerService.newAndError();
    fourMapper.insert(new Four(1, "newAndTrueAndNewAndError"));
  }




  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndErrorAndDefaultAndTrue() {
    threeMapper.insert(new Three(1, "newAndErrorAndDefaultAndTrue"));
    innerService.defaultAndTrue();
    int i = 1 / 0;
    fourMapper.insert(new Four(1, "newAndErrorAndDefaultAndTrue"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndErrorAndDefaultAndError() {
    threeMapper.insert(new Three(1, "newAndErrorAndDefaultAndError"));
    innerService.defaultAndError();
    int i = 1 / 0;
    fourMapper.insert(new Four(1, "newAndErrorAndDefaultAndError"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndErrorAndNewAndTrue() {
    threeMapper.insert(new Three(1, "newAndErrorAndNewAndTrue"));
    innerService.newAndTrue();
    int i = 1 / 0;
    fourMapper.insert(new Four(1, "newAndErrorAndNewAndTrue"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndErrorAndNewAndError() {
    threeMapper.insert(new Three(1, "newAndErrorAndNewAndError"));
    innerService.newAndError();
    int i = 1 / 0;
    fourMapper.insert(new Four(1, "newAndErrorAndNewAndError"));
  }


  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndTryAndDefaultAndTrue() {
    threeMapper.insert(new Three(1, "newAndTryAndDefaultAndTrue"));
    try {
      innerService.defaultAndTrue();
    } catch (Exception e) {
      log.info("catch innerService exception, e={}", e.getMessage());
    }
    fourMapper.insert(new Four(1, "newAndTryAndDefaultAndTrue"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndTryAndDefaultAndError() {
    threeMapper.insert(new Three(1, "newAndTryAndDefaultAndError"));
    try {
      innerService.defaultAndError();
    } catch (Exception e) {
      log.info("catch innerService exception, e={}", e.getMessage());
    }
    fourMapper.insert(new Four(1, "newAndTryAndDefaultAndError"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndTryAndNewAndTrue() {
    threeMapper.insert(new Three(1, "newAndTryAndNewAndTrue"));
    try {
      innerService.newAndTrue();
    } catch (Exception e) {
      log.info("catch innerService exception, e={}", e.getMessage());
    }
    fourMapper.insert(new Four(1, "newAndTryAndNewAndTrue"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndTryAndNewAndError() {
    threeMapper.insert(new Three(1, "newAndTryAndNewAndError"));
    try {
      innerService.newAndError();
    } catch (Exception e) {
      log.info("catch innerService exception, e={}", e.getMessage());
    }
    fourMapper.insert(new Four(1, "newAndTryAndNewAndError"));
  }
  
}
