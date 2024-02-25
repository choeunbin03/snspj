package com.snspj.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="/setting")
public class SettingController {
	@RequestMapping(value = "/settingDetail", method = RequestMethod.GET)
	public String goSettingDetail(Locale locale, Model model) {
		return "/setting/settingDetail";
	}
}
