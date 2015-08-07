package com.netbuilder.jms;

import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.Connection;

@Stateless
@ManagedBean(value="Sender")
public class Sender {

	@Inject
	private Connection connection;
	
}
