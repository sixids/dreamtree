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

    // 왼쪽 아래(bottom, left), 오른쪽 위(top, right)
    @GetMapping("/stores/search")
    public List<StoresMainResponseDto> getStoresByLatAndLng(
            @RequestParam(value = "bounds") String bound,
            @RequestParam(value = "store_type", required = false, defaultValue = "none") String store_type
    ){
        String[] rect = bound.split(",");

        double bottom = Double.parseDouble(rect[0]);
        double left = Double.parseDouble(rect[1]);
        double top = Double.parseDouble(rect[2]);
        double right = Double.parseDouble(rect[3]);

        if("none".equals(store_type)){
            return storesService.getStoresByLatAndLng(top, bottom, left, right);
        }else{
            return storesService.getStoresByLatAndLngAndStore_type(top, bottom, left, right, store_type);
        }
    }


}
