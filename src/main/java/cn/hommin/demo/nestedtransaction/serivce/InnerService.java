package cn.hommin.demo.nestedtransaction.serivce;

import cn.hommin.demo.nestedtransaction.dao.entity.One;
import cn.hommin.demo.nestedtransaction.dao.entity.Two;
import cn.hommin.demo.nestedtransaction.dao.mapper.OneMapper;
import cn.hommin.demo.nestedtransaction.dao.mapper.TwoMapper;
import lombok.extern.java.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hommin
 */
@Log
@Component
public class InnerService {

  @Autowired
  private OneMapper oneMapper;
  @Autowired
  private TwoMapper twoMapper;

  @Transactional
  public void defaultAndTrue(){
    oneMapper.insert(new One(1, "defaultAndTrue"));
    twoMapper.insert(new Two(1, "defaultAndTrue"));
  }

  @Transactional
  public void defaultAndError(){
    oneMapper.insert(new One(1, "defaultAndError"));
    int i = 1/0;
    twoMapper.insert(new Two(1, "defaultAndError"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndTrue(){
    oneMapper.insert(new One(1, "newAndTrue"));
    twoMapper.insert(new Two(1, "newAndTrue"));
  }

  @Transactional(propagation = Propagation.REQUIRES_NEW)
  public void newAndError(){
    oneMapper.insert(new One(1, "newAndError"));
    int i = 1/0;
    twoMapper.insert(new Two(1, "newAndError"));
  }


}
