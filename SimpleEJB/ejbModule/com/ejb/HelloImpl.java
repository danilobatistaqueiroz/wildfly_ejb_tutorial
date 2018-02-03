package com.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

@Stateless
@LocalBean 
public class HelloImpl implements HelloRemote {
	public String write(String text) {
		return "vixi:" + text;
	}
}
