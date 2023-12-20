package cn.edu.bupt.mybatisplus.demo.todo.controller;

import cn.edu.bupt.mybatisplus.demo.todo.entity.Contact;
import cn.edu.bupt.mybatisplus.demo.todo.service.IContactsService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/")
public class ContactsController {

    @Getter
    @Value("${img-upload-path}")
    private String imgUploadPath;

    IContactsService contactsService;

    @Autowired
    public ContactsController(IContactsService contactsService) {
        this.contactsService = contactsService;
    }
    @GetMapping()
    String list(Model model) {
        List<Contact> contacts = contactsService.list();
        model.addAttribute("contacts", contacts);
        return "list_page";
    }

    @GetMapping("/add")
    String addForm() {
        return "add_page";
    }

    @PostMapping("/add")
    String add(@RequestPart MultipartFile avatar, @ModelAttribute Contact contact) {
        addContactAvatar(avatar, contact);
        contactsService.save(contact);
        return "redirect:/";
    }

    @GetMapping("/delete")
    String delete(@RequestParam int id) {
        contactsService.removeById(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    String editForm(Model model, @RequestParam int id) {
        Contact contact = contactsService.getById(id);
        model.addAttribute("contact", contact);
        return "edit_page";
    }

    @PostMapping("/edit")
    String edit(@ModelAttribute Contact contact, @RequestPart MultipartFile avatar) {
        addContactAvatar(avatar, contact);
        contactsService.updateById(contact);
        return "redirect:/";
    }
    @GetMapping("/search")
    String search(Model model, @RequestParam String keyword) {
        List<Contact> contacts = contactsService.listByCondition(keyword);
        model.addAttribute("contacts", contacts);
        return "list_page";
    }
    private boolean addContactAvatar(MultipartFile avatar, Contact contact) {
        if(!avatar.isEmpty()) {
            String avatarName = avatar.getOriginalFilename();
            String avatarPath = imgUploadPath + avatarName;
            try {
                avatar.transferTo(new java.io.File(avatarPath));
                contact.setAvatarPath(avatarName);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}

