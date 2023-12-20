package cn.edu.bupt.mybatisplus.demo.todo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;



@Data
@TableName("contacts")
public class Contact {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String avatarPath;  // 头像路径
    private String name;
    private String email;
    private String phone;
}