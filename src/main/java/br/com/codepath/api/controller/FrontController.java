package br.com.codepath.api.controller;

import br.com.codepath.api.dto.aprender.AprenderResponseDTO;
import br.com.codepath.api.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/front")
public class FrontController {

   @Autowired
   FrontService frontService;
   @GetMapping("/user/{userId}/course/{courseId}")
   @ResponseStatus(HttpStatus.OK)
   public AprenderResponseDTO printAllUserInfo(Long userId, Integer courseId){
        return frontService.printAllUserInfo(userId,courseId);
   }
}
