package br.com.resources;

import org.glassfish.jersey.server.ResourceConfig;

public class RoupasApp extends ResourceConfig{
	
	public RoupasApp() {
		register(RoupasResource.class);
	}
}
