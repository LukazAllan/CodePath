package br.com.codepath.api.controller;

import br.com.codepath.api.dto.aprender.AprenderRequestDTO;
import br.com.codepath.api.dto.aprender.AprenderResponseDTO;
import br.com.codepath.api.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/front")
@CrossOrigin(origins="*", allowedHeaders = "*")
public class FrontController {

   @Autowired
   FrontService frontService;
   
   @GetMapping()
   @ResponseStatus(HttpStatus.OK)
   public AprenderResponseDTO printAllUserInfo(@RequestBody AprenderRequestDTO request) {
      return frontService.printAllUserInfo(request.getUserId(), request.getCourseId());
   }
}
