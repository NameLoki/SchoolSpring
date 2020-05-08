package kr.hs.dgsw.webclass01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private List<User> userList;

    public UserServiceImpl() { // 임시 데이터 추가
        userList = new ArrayList<>();
        userList.add(new User("user1", "홍길동", "test1@dgsw.hs.kr"));
        userList.add(new User("user2", "이순신", "test2@dgsw.hs.kr"));
        userList.add(new User("user3", "무명인", "test3@dgsw.hs.kr"));
    }

	@Override
	public List<User> list() { // 유저리스트 반환
		return userList;
	}

	@Override
	public User view(String id) { // 유저 아이디로 탐색후 반환
        User user = userList.stream().filter(found -> found.getId().equals(id))
        .findAny()
        .orElse(null);
		return user;
	}

	@Override
	public boolean add(User user) { // 유저 정보 추가
        User found = view(user.getId());
        if(found == null) {
            return userList.add(user);
        }
		return false;
	}

	@Override
	public User update(User user) { // 유저 정보 업데이트
        User found = view(user.getId());
        if(found != null) {
            found.setName(user.getName());
            found.setEmail(user.getEmail());
        }

		return found;
	}

	@Override
	public boolean delete(String id) { // 유저 삭제
        User found = view(id);
		return userList.remove(found);
	}
}