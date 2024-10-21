package com.email.EmailAPI.controller;

import com.email.EmailAPI.model.EmailRequest;
import com.email.EmailAPI.service.EmailService;
import org.apache.catalina.valves.rewrite.ResolverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    public String Welcome(){
        return "This is Email API";
    }

    //api to send  email
    @PostMapping("/sendEmail")
    public ResponseEntity<?> sendEmail(@RequestBody EmailRequest  request){
        // this.emailService.sendAttach();
        System.out.println(request);
        boolean result= this.emailService.sendAttach(request.getMessage(),request.getSubject(),request.getTo());

        if(result){
            return  ResponseEntity.ok("Email sent Successfully");
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email not Sent, Please try again");
        }
    }
}
