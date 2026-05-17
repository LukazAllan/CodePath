package br.com.codepath.api.controller;

import br.com.codepath.api.dto.request.DoByIdRequestDTO;
import br.com.codepath.api.dto.request.SetDaysByUserIdDTO;
import br.com.codepath.api.model.Streak;
import br.com.codepath.api.service.StreakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/streak")
public class StreakController {

    @Autowired
    private StreakService streakService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Streak> findAll() {
        return streakService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Streak findById(@PathVariable Long id) {
        return streakService.findById(id);
    }

    @PostMapping("/revoke")
    @ResponseStatus(HttpStatus.OK)
    public void revokeDaysById(@RequestBody DoByIdRequestDTO request){
        streakService.revokeDaysById(request.getId());
    }

    @PostMapping("/days")
    @ResponseStatus(HttpStatus.OK)
    public void setDaysByUserId(@RequestBody SetDaysByUserIdDTO request) {
        streakService.setDaysByUserId(request.getUserId(), request.getDays());
    }

    @GetMapping("/days/{days}")
    @ResponseStatus(HttpStatus.OK)
    public List<Streak> findAllByDays(@PathVariable Integer days) {
        return streakService.findAllByDays(days);
    }
}
