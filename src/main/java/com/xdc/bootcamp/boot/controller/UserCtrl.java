package com.xdc.bootcamp.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xdc.bootcamp.boot.entity.User;
import com.xdc.bootcamp.boot.model.StatusListInfo;
import com.xdc.bootcamp.boot.model.UserInfo;
import com.xdc.bootcamp.boot.security.RestCorsServletResponse;
import com.xdc.bootcamp.boot.service.UserService;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/rest")
public class UserCtrl {

	@Autowired
	UserService userService;
	
	@Autowired
	StatusListInfo statusListInfo;
	
	@RequestMapping(value = "/user/list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody StatusListInfo getAll(HttpServletRequest request,
			HttpServletResponse response){
		RestCorsServletResponse.setResponse(response);
		
		List<UserInfo> userInfos = new ArrayList<>();
		List<User> users = userService.getAll(request);
		
		for (User user : users) {
			UserInfo userInfo = new UserInfo();
			userInfo.setPassword(user.getPassword());
			userInfo.setPersonId(user.getPerson().getId());
			userInfo.setUserId(user.getId());
			userInfo.setUsername(user.getUsername());
			userInfos.add(userInfo);
		}
		
		statusListInfo.setList(userInfos);
		statusListInfo.setMessage("Succesful");
		statusListInfo.setStatus(true);
		statusListInfo.setTotal(userService.getTotal(request));
		
		return statusListInfo;
	}
}
