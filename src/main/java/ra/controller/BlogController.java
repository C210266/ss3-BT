package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ra.model.dto.BlogDto;
import ra.model.service.IBlogService;
import ra.model.service.ICateService;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICateService cateService;

    @GetMapping
    public String list(Model model, @RequestParam(defaultValue = "") String title, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size, @RequestParam(defaultValue = "title") String sort, @RequestParam(defaultValue = "asc") String by) {
        model.addAttribute("blogs", blogService.findAll(title, page, size, sort, by));
        model.addAttribute("title", title);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable Long id) {
        return new ModelAndView("detail", "blog", blogService.findById(id));
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("blog", new BlogDto());
        model.addAttribute("listCate", cateService.findAll());
        return "add";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        return new ModelAndView("edit", "blog", blogService.findById(id));
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        blogService.delete(id);
        return "redirect:/";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute BlogDto blogDto) {
        blogService.save(blogDto);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BlogDto blogDto) {
        blogService.save(blogDto);
        return "redirect:/";
    }
}
