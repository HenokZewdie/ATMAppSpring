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
    WithdrawalRepository withdrawalRepository;
    Customer customer = new Customer();
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

    }

    @RequestMapping(value = "/withdrawal", method = RequestMethod.GET)
    public String withdraw(Model model){
        model.addAttribute(new Customer());
        return "withdrawal";
    }

    @RequestMapping(value = "/withdrawal", method = RequestMethod.POST)
    public String processWithdraw(@ModelAttribute Customer customer, Model model){
        customer.setDate(new Date());
        customer.getAccountNo();
        customer.getBalance();
        customer.setBalance(customer.getBalance()-customer.getAmount());

        return "redirect:/displayWith";
    }
    @RequestMapping(value = "/displayWith", method = RequestMethod.GET)
    public String WithdrawaltoSend(@ModelAttribute Customer customer, Model model){

        withdrawalRepository.save(customer);
        Iterable<Customer> withdrawal = customerRepository.findAll();
        model.addAttribute("withdra", withdrawal);
        return "profile";

    }

    @RequestMapping(value = "/deposit", method = RequestMethod.GET)
    public String deposit(Model model){
        model.addAttribute(new Customer());
        return "/deposit";
    }
}
