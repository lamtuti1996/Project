/**
 * 
 */
package com.azportal.service.warning.http.imp;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;

import com.azportal.service.warning.common.Utils;
import com.azportal.service.warning.http.HTTPService;
import com.azportal.service.warning.http.HTTPServiceConfig;

/**
 * @author ThangDQ
 *
 */
public class HTTPServiceImpl implements HTTPService {
	private Server server = null;

	public HTTPServiceImpl() {
		URI baseUri = UriBuilder.fromUri(Utils.getServerProperties().getUrl())
				.port(Utils.getServerProperties().getPort()).build();
		HTTPServiceConfig app = new HTTPServiceConfig();
		this.server = JettyHttpContainerFactory.createServer(baseUri, app);

	}

	public void startHTTPService() throws Exception {
		// TODO Auto-generated method stub
		server.start();
		server.join();
	}

	public void stopHTTPService() throws Exception {
		// TODO Auto-generated method stub
		server.stop();
	}

}
