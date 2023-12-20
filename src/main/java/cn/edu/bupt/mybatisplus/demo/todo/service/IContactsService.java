package cn.edu.bupt.mybatisplus.demo.todo.service;

import cn.edu.bupt.mybatisplus.demo.todo.entity.Contact;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface IContactsService extends IService<Contact> {
    // 根据条件查询列表
    List<Contact> listByCondition(String condition);
}
