package com.azouakan.mymsscbrewery.web.controller;

import com.azouakan.mymsscbrewery.services.BeerService;
import com.azouakan.mymsscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {


    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable  UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handelPost(@RequestBody BeerDto beerDto){
        BeerDto savedDto = beerService.saveNewBeer(beerDto);
        HttpHeaders headers = new HttpHeaders();
        headers.add("location","/api/v1/beer/" + savedDto.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping({"/{beerId}"})
    public ResponseEntity handleUpdate(@PathVariable UUID beerId, @RequestBody BeerDto beerDto){

        beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{beerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable UUID beerId){
        beerService.deleteBeerById(beerId);
    }
}
