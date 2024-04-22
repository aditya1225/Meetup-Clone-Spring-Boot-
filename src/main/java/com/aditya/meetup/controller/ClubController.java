package com.aditya.meetup.controller;

import com.aditya.meetup.dto.ClubDto;
import com.aditya.meetup.model.Club;
import com.aditya.meetup.model.UserEntity;
import com.aditya.meetup.security.SecurityUtil;
import com.aditya.meetup.service.ClubService;
import com.aditya.meetup.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@NoArgsConstructor

public class ClubController {
    public ClubService clubService;
    private UserService userService;

    @Autowired
    public ClubController(ClubService clubService, UserService userService) {
        this.clubService = clubService;
        this.userService = userService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        UserEntity user= new UserEntity();
        List<ClubDto> clubs=clubService.findAllClubs();
        String username= SecurityUtil.getSessionUser();
        if(username!=null){
            user=userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/{clubId}")
    public String clubDetail(@PathVariable("clubId") Integer clubId, Model model){
        UserEntity user= new UserEntity();
        ClubDto clubDto=clubService.findById(clubId);
        model.addAttribute("club", clubDto);
        String username= SecurityUtil.getSessionUser();
        if(username!=null){
            user=userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("club", clubDto);
        return "clubs-detail";
    }

    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club=new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value="query") String query, Model model){
        List<ClubDto> club=clubService.searchClubs(query);
        model.addAttribute("club",club);
        return "clubs-list";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Integer clubId){
        clubService.delete(clubId);
        return "redirect:/clubs";
    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto,BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("club", clubDto);
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("clubs/{clubId}/edit")
    public String editClub(@PathVariable("clubId") Integer clubId, Model model){
        ClubDto club = clubService.findById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Integer clubId,
                             @Valid @ModelAttribute("club") ClubDto club,
                             BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("club", club);
            return "clubs-create";
        }
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }
}
