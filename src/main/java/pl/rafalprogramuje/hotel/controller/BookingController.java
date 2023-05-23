package pl.rafalprogramuje.hotel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.rafalprogramuje.hotel.entity.Booking;
import pl.rafalprogramuje.hotel.entity.Guest;
import pl.rafalprogramuje.hotel.entity.Room;
import pl.rafalprogramuje.hotel.service.BookingService;

import java.time.LocalDate;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;



    @GetMapping({"/showBookings", "/"})
    public ModelAndView showBookings() {
        ModelAndView mav = new ModelAndView("list-bookings");
        List<Booking> bookings = bookingService.getBookingRepository().findAll();
        mav.addObject("bookings", bookings);
        return mav;
    }

    @GetMapping("/addBookingForm")
    public ModelAndView addBooking(Model model) {
        List<Guest> guestList = bookingService.getGuestRepository().findAll();
        List<Room> roomList = bookingService.getRoomRepository().findAll();
        model.addAttribute("guestList", guestList);
        model.addAttribute("roomList", roomList);
        model.addAttribute("localDate", LocalDate.now());

        ModelAndView mav = new ModelAndView("add-booking-form");
        Booking newBooking = new Booking();
        mav.addObject("booking", newBooking);
        return mav;
    }

    @PostMapping("/saveBooking")
    public String saveBooking(@ModelAttribute Booking booking) {
        booking.setRoom(bookingService.getRoomRepository().findById(booking.getRoomId()).get());
        booking.setGuest(bookingService.getGuestRepository().findById(booking.getGuestId()).get());
        booking.setPrice();
        bookingService.getBookingRepository().save(booking);
                
        return "redirect:/showBookings";
    }



    @GetMapping("/showBookingUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long bookingId, Model model){
        List<Guest> guestList = bookingService.getGuestRepository().findAll();
        List<Room> roomList = bookingService.getRoomRepository().findAll();
        model.addAttribute("guestList", guestList);
        model.addAttribute("roomList", roomList);
        ModelAndView mav = new ModelAndView("add-booking-form");
        Booking booking = bookingService.getBookingRepository().findById(bookingId).get();
        mav.addObject("booking", booking);
        return mav;
    }

    @GetMapping("/deleteBooking")
    public String deleteBooking(@RequestParam Long bookingId) {
        bookingService.getBookingRepository().deleteById(bookingId);
        return "redirect:/showBookings";
    }


}
