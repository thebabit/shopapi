package com.example.shopapi.Controller;
import com.example.shopapi.Entity.Items;
import com.example.shopapi.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/Item")
public class ItemController {

    private ItemService itemService;


    @Autowired
    public ItemController(ItemService employeeService) {
        this.itemService = employeeService;
    }



    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Items addNewEmployee(@RequestBody  Items items) {
        return itemService.addItems(items);
}


    @GetMapping("/Items")
    public List<Items> getAllItems() {
        return itemService.getall();
    }
}
