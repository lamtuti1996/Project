package com.azportal.service.warning.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import com.azportal.service.warning.business.DBManager;
import com.azportal.service.warning.dao.TransactionDAO;
import com.azportal.service.warning.entity.WarningSerivceObj;
import com.azportal.service.warning.server.impl.PlatformImpl;

public class SendInfo {

	private static Logger logger = Logger.getLogger(SendInfo.class);
	public static final HipChatClient hipChatClient = new HipChatClient();
	public static final MailClient mailClient = new MailClient();

	// send err
	public static void sendErr(String timeRequest, long threadId, String emailAddress, String emailPassword,
			String ipAddress, String service) {

		String message = "";
		if ("ping".equals(service)) {
			message = " Ping to address: ";
		} else {
			message = " Request to address: ";
		}
		String content = "Thread " + threadId + message + ipAddress + " in time: " + timeRequest + " fail";
		// send to mail
		int checkMail = mailClient.sendMail(emailAddress, emailPassword, emailAddress, message, content);
		if (checkMail == 1) {
			System.out.println("Send Mail is successfuly");
			logger.info("Send Mail is successfuly");
		} else {
			System.out.println("Send Mail is successfuly");
			logger.info("Send Mail is Fail");
		}
		// send to hipchat

	/*	int checkHipChat = hipChatClient.SendHipChatMessage(content);
		if (checkHipChat == 1) {
			System.out.println("Send Hip Chat is successfuly");
			logger.info("Send Hip Chat is successfuly");
		} else {
			System.out.println("Send Hip Chat is successfuly");
			logger.info("Send Hip Chat is Fail");
		}*/

	}

	public static void insertDB(String xTimeRequest, long timeDiff, String ipAddress, String message, String status) {
		// insert DB

	//	dbManager = (DBManager) SpringUtils.getBean("DBManager");
		WarningSerivceObj ws = new WarningSerivceObj();
		Timestamp timeRequest = Utils.convertDate(xTimeRequest);

		ws.setMessage(message);
		ws.setAdressService(ipAddress);
		ws.setTimeRequest(timeRequest);
		ws.setTimeDiff(timeDiff);
		ws.setStatus(status);


		int check = Utils.getDBManager().insertRequest(ws);
		if (check >= 0) {
			System.out.println("Insert data in DB is successfuly");
			logger.info("Insert data in DB is successfuly");
		} else {
			System.out.println("Insert data  in DB is Fail");
			logger.info("Insert data in DB is Fail");
		}

	}

}
