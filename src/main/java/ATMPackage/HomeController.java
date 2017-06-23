package ATMPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by student on 6/23/17.
 */
@Controller
public class HomeController {
    @Autowired
    CustomerRepository customerRepository;

    /*REGISTER*/

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toGet(Model model){
        model.addAttribute(new Customer());
        return "/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String process(@ModelAttribute Customer customer){
        customer.setDate(new Date());
        customer.setBalance(customer.getInitialDeposit());
        customerRepository.save(customer);
        return "redirect:/display";
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String toSend(@ModelAttribute Customer customer, Model model){

        Iterable<Customer> values = customerRepository.findAll();
        model.addAttribute("values", values);
        return "profile";
        /*if(values!=null){
            model.addAttribute("values", values);
            return "profile";
        }
        else*/



    }
}
