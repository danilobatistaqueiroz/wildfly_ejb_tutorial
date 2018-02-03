package com.ejb;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
	public String write(String text);
}
