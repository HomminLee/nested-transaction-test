package cn.hommin.demo.nestedtransaction.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hommin
 */
@TableName("two")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Two {

  @TableId(value = "id", type = IdType.AUTO)
  private int id;

  @TableField(value = "content")
  private String content;

}
