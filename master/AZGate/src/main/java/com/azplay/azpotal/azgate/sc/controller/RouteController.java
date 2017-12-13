/**
 * 
 */
package com.azplay.azpotal.azgate.sc.controller;
import com.azplay.azpotal.azgate.sc.db.DatabaseConnector;
import com.azplay.azpotal.azgate.sc.util.JsonTransformer;

import spark.Service;

/**
 * @author thang
 *
 */
public class RouteController {
	
	public RouteController(DatabaseConnector dc, Service azgateService) {
		if (azgateService != null) {
			System.out.println("Start init route....");
			MOController mo = new MOController(dc);
			MTController mt = new MTController(dc);
			OAMController oam = new OAMController(dc);
//			azgateService.initExceptionHandler((e) -> System.out.println("Uh-oh"));

			azgateService.path("/sc", () -> {
				azgateService.before("/*", (q, a) -> System.out.println("Did recv api call"));
				azgateService.path("/v1", () -> {
					azgateService.get("/mo",     mo.handleRequest);
					azgateService.get("/mt",     mt.handleRequest, new JsonTransformer());
				});
				
				azgateService.path("/oam", () -> {
					azgateService.get("/oam_azgate_list_transaction", oam.handleRequestDetail, new JsonTransformer());
					azgateService.get("/oam_azgate_list_transaction_group_by_status", oam.handleRequestGroup, new JsonTransformer());
				});
			}); 
			
			azgateService.get("/ping", (req, res) -> "pong");
		}
		
	}
}
