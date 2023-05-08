package pl.rafalprogramuje.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.rafalprogramuje.hotel.entity.Guest;
import pl.rafalprogramuje.hotel.repository.GuestRepository;
import pl.rafalprogramuje.hotel.repository.RoomRepository;

import java.util.List;

@Controller
public class GuestController {

    @Autowired
    private GuestRepository repo;

    @GetMapping("/showGuests")
    public ModelAndView showGuests() {
        ModelAndView mav = new ModelAndView("list-guests");
        List<Guest> guests = repo.findAll();
        mav.addObject("guests", guests);
        return mav;

    }

    @GetMapping("/addGuestForm")
    public ModelAndView addGuest() {
        ModelAndView mav = new ModelAndView("add-guest-form");
        Guest newGuest = new Guest();
        mav.addObject("guest", newGuest);
        return mav;
    }

    @PostMapping("/saveGuest")
    public String saveGuest(@ModelAttribute Guest guest) {
        repo.save(guest);
        return "redirect:/showGuests";
    }

    @GetMapping("/showGuestUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long guestId){
        ModelAndView mav = new ModelAndView("add-guest-form");
        Guest guest = repo.findById(guestId).get();
        mav.addObject("guest", guest);
        return mav;
    }

    @GetMapping("/deleteGuest")
    public String deleteGuest(@RequestParam Long guestId) {
        repo.deleteById(guestId);
        return "redirect:/showGuests";
    }




}
