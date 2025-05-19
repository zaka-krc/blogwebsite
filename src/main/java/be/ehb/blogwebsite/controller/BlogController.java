package be.ehb.blogwebsite.controller;

import be.ehb.blogwebsite.model.BlogPost;
import be.ehb.blogwebsite.model.BlogPostDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {

    private BlogPostDAO blogPostDAO;

    @Autowired
    public BlogController(BlogPostDAO blogPostDAO) {
        this.blogPostDAO = blogPostDAO;
    }
    //alle request mapping in de controller moeten een modelmap meegeven
    @ModelAttribute("blogForForm")
    private BlogPost createBlogPost() {
        return new BlogPost();
    }

    @GetMapping({"/", "/index"})
    public String openIndex(ModelMap modelMap) {
        modelMap.put("all_blogs", blogPostDAO.findAll());
        return "index";
    }

    @PostMapping("/index")
    public String saveFormulier(@ModelAttribute("blogForForm") @Valid BlogPost newBlogPost,
                                BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            blogPostDAO.save(newBlogPost);
            return "redirect:index";
        }
    return "index";
    }
}
