package com.webservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.webservice.common.Common;
import com.webservice.common.Constant;

import com.webservice.entity.OAMClientReceiver;

import com.webservice.model.Users;
import com.webservice.service.ClientService;
import com.webservice.service.UserService;

@RestController
public class OAMController {
	private static final Logger log = LoggerFactory.getLogger(OAMController.class);
	Common common = new Common();
	@Autowired
	UserService userService;

	/*@Value("${oam.username}")
	private String oamUserName;

	@Value("${oam.password}")
	private String oamPass;*/

	@GetMapping("/client/v1/list")
	/*public ResponseEntity requetHandleDetail(@RequestParam(required = false) String clientId,
			@RequestParam(required = false) String partnerId, @RequestParam(required = false) String from,
			@RequestParam(required = false) String to, @RequestParam(required = false) String telco,
			@RequestParam(required = false) String status, @RequestParam(required = false) String timestamp,
			@RequestParam(required = false) String username, @RequestParam(required = false) String passToken,
			@RequestParam(required = false) String rand) {*/
	public ResponseEntity<?> requetHandleDetail() {
		//OAMClientReceiver objectReceiver = new OAMClientReceiver(clientId, partnerId, from, to, telco, status,
		//		timestamp, username, passToken, rand);

		// if(validateOAM(objectReceiver)) {
		if (true) {
		//	String key = objectReceiver.getTimestamp() + "|" + objectReceiver.getRand() + "|" + oamUserName + "|"
		//			+ oamPass;

			//String passTokenSAH256 = common.SHA256(key);

			// if (passToken.equals(objectReceiver.getPassToken())) {
			if (true) {
				/*
				 * List<Client> list = clientService.findAddClient();
				 * 
				 * return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
				 */
				List<Users> list = userService.findAll();

				return new ResponseEntity<List<Users>>(list, HttpStatus.OK);

			} else {
				return ResponseEntity.status(Integer.parseInt(Constant.ERR_CODE_102)).body(Constant.ERR_MESS_102);
				// return responseErr(Constant.ERR_CODE_102, Constant.ERR_MESS_102);
			}

		} else {
			

	        ResponseEntity<String> responseEntity = new ResponseEntity<>(Constant.ERR_CODE_101+"|"+Constant.ERR_MESS_101,
	                                                                     HttpStatus.BAD_REQUEST);
	        return responseEntity;
	//	       return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	//return  ResponseEntity.status(Integer.parseInt(Constant.ERR_CODE_101)).body(Constant.ERR_MESS_101);
			// return responseErr(Constant.ERR_CODE_101, Constant.ERR_MESS_101);

		}

	}

	private boolean validateOAM(OAMClientReceiver objectReceiver) {
		if (objectReceiver.getTimestamp() == null || objectReceiver.getTimestamp() == Constant.STR_EMTY
				|| objectReceiver.getUsername() == null || objectReceiver.getUsername() == Constant.STR_EMTY
				|| objectReceiver.getPassToken() == null || objectReceiver.getPassToken() == Constant.STR_EMTY
				|| objectReceiver.getRand() == null || objectReceiver.getRand() == Constant.STR_EMTY) {
			return false;
		}
		return true;
	}

}
