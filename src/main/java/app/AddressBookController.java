package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressBookController {
    @Autowired
    BuddyInfoRepository buddyInfoRepository;

    @GetMapping("/")
    public String addressBookForm(Model model) {
        List<AddressBook> books = new ArrayList<>();
        AddressBook addressBook = AddressBook.getInstance();
        books.add(addressBook);
        model.addAttribute("books", books);
        return "print";
    }

    @GetMapping("/addBuddy")
    public String addBuddyForm(Model model) {
        return "addBuddy";
    }

    @PostMapping("/addBuddy")
    public void submitBuddy(Model model, @Valid @ModelAttribute("buddy") BuddyInfo buddy, BindingResult result) {
        if (result.hasErrors()){
            // do something
        }
        else {  // there are no errors
            AddressBook.getInstance().addBuddy(buddy);
            buddyInfoRepository.save(buddy);
        }
    }

    @PostMapping("/addressBook")
    public BuddyInfo submitBuddySPA(Model model, @ModelAttribute("buddy") BuddyInfo buddy, BindingResult result) {
        return buddyInfoRepository.save(buddy);
    }

    @GetMapping("/addressBook")
    public String SPAForm(Model model) {
        return "SPA";
    }
}
