package br.com.codepath.api.service;

import br.com.codepath.api.model.Streak;
import br.com.codepath.api.repository.StreakRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class StreakService {
    @Autowired
    private StreakRepository streakRepository;
    public List<Streak> findAll() {
        return streakRepository.findAll();
    }
    public Streak findById(Long id) {
        return streakRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public List<Streak> findAllByDays(Integer days) {
        return streakRepository.findAllByDays(days);
    }
    public void revokeDaysById(Long id){
        Streak thisStreak = streakRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        thisStreak.setDays(0);
        thisStreak.setLastDay(LocalDate.now());
        streakRepository.save(thisStreak);
    }
    public void setDaysByUserId(Long userId, Integer days) {
        Streak thisStreak = streakRepository.findByUserId(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        thisStreak.setDays(days);
        thisStreak.setLastDay(LocalDate.now());
        streakRepository.save(thisStreak);
    }
}