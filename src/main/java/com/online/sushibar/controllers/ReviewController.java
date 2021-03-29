package com.online.sushibar.controllers;


import com.online.sushibar.entity.ReviewForFood;
import com.online.sushibar.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    @GetMapping
    public String showRiviews(Model model) {
        List<ReviewForFood> all = reviewRepository.findAll();
        model.addAttribute("all", all);
        return "productscomments";
    }
}