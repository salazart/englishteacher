package com.sz.et;

import java.util.List;

import com.sz.et.dao.impl.FbUserService;
import com.sz.et.interfaces.IHibernateDao;
import com.sz.et.models.FbUser;
import com.sz.et.utils.HibernateUtil;

public class FbUserServiceTest {

	public static void main(String[] args) {
		FbUser fbUser = new FbUser("001", "Alex", "380971234567");
		FbUser fbUser1 = new FbUser("002", "Alexx", "380971234527");
		
		IHibernateDao<FbUser> fbUserService = new FbUserService(HibernateUtil.getInstance().getSessionFactory());
//		fbUser = fbUserService.save(fbUser);
//		fbUser1 = fbUserService.save(fbUser1);
//		fbUser = fbUserService.save(fbUser);
		
		List<FbUser> fbUsers = fbUserService.getAll();
		System.out.println(fbUsers.size());
		fbUsers.forEach(System.out::println);
		
		HibernateUtil.release();
	}
}
