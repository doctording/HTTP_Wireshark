package user;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.bean.User;
import com.dao.UserDao;
import com.daoImpl.UserDaoImpl;
import com.utils.JSonUtil;

public class UserTest {

	@Test
	public void testGet() {
		UserDao userDao = new UserDaoImpl();
		List<User> list = userDao.user_getAll();
		System.out.println(list);

	}

	@Test
	public void testGetByUserIDAndPassword() {
		UserDao userDao = new UserDaoImpl();
		User u = userDao.user_getByUserIDAndPassword("00001", "123456");
		if(u!=null)
			System.out.println(u);
		else
			System.out.println("wu");
		List<Object> list = new ArrayList<Object>();
		list.add(u);
		list.add(u);
		/*list.add("abcc");
		String s = JSONObject.toJSONString(list);
		System.out.println(s);*/
		String s  = new JSonUtil().listToJson2(list,"list");
		System.out.println(s);
	}
	
}