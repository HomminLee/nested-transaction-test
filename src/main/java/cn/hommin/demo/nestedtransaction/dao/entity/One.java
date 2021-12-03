package cn.hommin.demo.nestedtransaction.dao.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author hommin
 */
@TableName("one")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class One {

  @TableId(value = "id", type = IdType.AUTO)
  private int id;

  @TableField(value = "content")
  private String content;

}
