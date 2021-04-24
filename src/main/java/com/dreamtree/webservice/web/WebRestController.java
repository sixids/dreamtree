package com.dreamtree.webservice.web;

import com.dreamtree.webservice.dto.posts.PostsMainResponseDto;
import com.dreamtree.webservice.dto.posts.PostsSaveRequestDto;
import com.dreamtree.webservice.dto.stores.StoresMainResponseDto;
import com.dreamtree.webservice.service.PostsService;
import com.dreamtree.webservice.service.StoresService;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {

    private PostsService postsService;
    private StoresService storesService;
    private Environment env;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }

    @GetMapping("/stores")
    public List<StoresMainResponseDto> getStores(){
        return storesService.findAllDesc();
    }

    @GetMapping("/stores/{id}")
    public StoresMainResponseDto getStoreByStore_id(@PathVariable(value="id") int id) {
        return storesService.getStoreByStore_id(id);
    }

    @GetMapping("/stores/search")
    public List<StoresMainResponseDto> getStoresByLatAndLng(
            @RequestParam(value = "top") double top,
            @RequestParam(value = "bottom") double bottom,
            @RequestParam(value = "left") double left,
            @RequestParam(value = "right") double right,
            @RequestParam(value = "store_type", required = false, defaultValue = "none") String store_type
    ){
        if("none".equals(store_type)){
            return storesService.getStoresByLatAndLng(top, bottom, left, right);
        }else{
            return storesService.getStoresByLatAndLngAndStore_type(top, bottom, left, right, store_type);
        }
    }
}
