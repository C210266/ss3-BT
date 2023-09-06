package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.entity.Category;
import ra.model.service.ICateService;

@Controller
public class CateController {
    @Autowired
    private ICateService cateService;

//    @GetMapping
//    public String listCate(Model model) {
//        model.addAttribute("listCate", cateService.findAll());
//        return "list";
//    }

    @GetMapping("/addCate")
    public ModelAndView addCate() {
        return new ModelAndView("add", "newCate", new Category());
    }
    @PostMapping("/addCate")
    public String doCate(@ModelAttribute Category newCate){
        cateService.save(newCate);
        return "redirect:/";
    }
}
