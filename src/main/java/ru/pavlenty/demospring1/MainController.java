package ru.pavlenty.demospring1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller

public class MainController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path="/")
    public String index() {
        return "index";
    }

   /* @PostMapping(path="/add")
    public @ResponseBody
    String addNewUser (@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }
*/

    @GetMapping(path="/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="Ivan") String name, User user) {
        user.setName(name);
        return "greeting";
    }

    @GetMapping(value = "/add")
    public @ResponseBody
    Map addNewUser (@RequestParam String name, @RequestParam String email) {
        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        //return "Saved";
        return Collections.singletonMap("result", "Saved");
    }


}