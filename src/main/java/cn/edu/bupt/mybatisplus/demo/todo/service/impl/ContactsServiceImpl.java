package cn.edu.bupt.mybatisplus.demo.todo.service.impl;


import cn.edu.bupt.mybatisplus.demo.todo.entity.Contact;
import cn.edu.bupt.mybatisplus.demo.todo.mapper.ContactsMapper;
import cn.edu.bupt.mybatisplus.demo.todo.service.IContactsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl extends ServiceImpl<ContactsMapper, Contact> implements IContactsService {
    @Override
    public List<Contact> listByCondition(String condition) {
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", condition).or().like("email", condition).or().like("phone", condition);
        return baseMapper.selectList(queryWrapper);
    }

}
