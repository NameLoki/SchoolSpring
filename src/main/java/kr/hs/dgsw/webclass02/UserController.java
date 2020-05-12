package kr.hs.dgsw.webclass02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // @ResponsBody포함
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list() { // 리스트 호출
        return userService.list();
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User view(@PathVariable String id) { // 유저 호출
        return userService.view(id);
    }

    @PostMapping("/user")
    @ResponseBody
    public boolean add(@RequestBody User user) { // 유저 추가
        return userService.add(user);
    } // CURD Create Updata Read 

    @PutMapping("/user")
    @ResponseBody
    public User update(@RequestBody User user) { // 유저 정보 업데이트
        return userService.update(user);
    }


    @DeleteMapping("user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable String id) { //유저 삭제
        return userService.delete(id);
    }
}