package com.teamProject.tripPlan.controller;

import com.teamProject.tripPlan.Recaptcha.VerifyRecaptcha;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ReCaptchaController {

    @ResponseBody
    @PostMapping(value = "VerifyRecaptcha")
    public ResponseEntity<?> VerifyRecaptcha(String recaptcha) throws IOException {
        VerifyRecaptcha.setSecretKey("6Lc8V3EqAAAAAGF4sXKTlA7ZPl2vt02dOjRY4iQr");
        return ResponseEntity.status(HttpStatus.OK).body(VerifyRecaptcha.verify(recaptcha));
    }

}
