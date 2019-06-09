package com.example.ClientMeneger.controllers;

import com.example.ClientMeneger.model.*;
import com.example.ClientMeneger.repositoryes.CallRepo;
import com.example.ClientMeneger.services.CallService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/calls")
public class CallController {

    private CallService callService;

    public CallController(CallService callService) {
        this.callService = callService;
    }

    @GetMapping
    private List<CallRepo.CallStatisticsByCity> getStatisticsByCity() {
        return callService.getCallStatisticByCity();
    }

    @PostMapping
    private Call createCall(@Valid @RequestBody CallDTO callDTO) {
        return callService.createCall(callDTO);
    }

    @GetMapping("/{clientId}/longest_call")
    public Call getLongestCall(@PathVariable BigInteger clientId,
                               @RequestParam("start") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate start,
                               @RequestParam("end") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {

        return callService.getLongestCall(clientId,start, end);
    }
}

