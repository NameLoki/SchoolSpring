package kr.hs.dgsw.webclass02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter, setter 등 함수 자동 추가
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id; // 유저 아이디
    private String name; // 유저 이름
    private String email; // 유저 이메일
}