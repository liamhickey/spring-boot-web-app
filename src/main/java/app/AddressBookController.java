package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressBookController {
    @Autowired
    AddressBookRepository repo;

    @GetMapping("/addressBook")
    public String addressBookForm(Model model) {
        List<AddressBook> books = new ArrayList<>();
        repo.findAll().forEach(books::add);
        model.addAttribute("books", books);
        return "addressBook";
    }

    @GetMapping("/")
    public @ResponseBody String defaultForm() {
        return "Hello World";
    }
}
