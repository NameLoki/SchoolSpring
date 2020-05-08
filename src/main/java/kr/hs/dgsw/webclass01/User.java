package kr.hs.dgsw.webclass01;

import lombok.Getter;
import lombok.Setter;

@Data // getter, setter 등 함수 자동 추가
public class User {
    private String id; // 유저 아이디
    private String name; // 유저 이름
    private String email; // 유저 이메일

    public User(String id, String name, String email) { //초기화용 생성자
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User() {}
}