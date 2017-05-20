package com.newcoming.greenhouse.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class HomeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	public String index() throws Exception {
		return "index";
	}

	public String top() throws Exception {
		return "top";
	}

	public String left() throws Exception {
		return "left";
	}

	public String right() throws Exception {
		return "right";
	}
}
