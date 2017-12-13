/**
 * 
 */
package com.azplay.azpotal.azgate.sc.config;

import java.io.IOException;
import java.util.Properties;

import com.azplay.azpotal.azgate.sc.common.Common;

/**
 * @author thang
 *
 */
public class ServerConfig {
	private String partnerPass;
	
	private String telcoCodes;

	private String partnerId;
	
	private String shootCode;
	
	private String azPortalUserName;
	
	private String azPortalPass;
	
	private String urlPartner;
	
	private String ahpUsername;
	
	private String ahpPassword;
	
	private String oamPass;
	
	private String oamUsername;
	
	private int port;
	
	private String hipchatToken;
	
	private String hipchatRoom;

	public ServerConfig() {
		Properties prop = new Properties();
		try {
			prop.load(Common.class.getClassLoader().getResourceAsStream("config.properties"));
			partnerId = prop.getProperty("partnerId.azgate");
			partnerPass = prop.getProperty("partner.password");
			telcoCodes = prop.getProperty("telco.code");
			ahpUsername = prop.getProperty("ahp.username");
			ahpPassword = prop.getProperty("ahp.password");
			shootCode = prop.getProperty("partner.shootCode");
			azPortalUserName = prop.getProperty("azportal.username");
			azPortalPass = prop.getProperty("azportal.pass");
			urlPartner = prop.getProperty("partner.url");
			port = Integer.valueOf(prop.getProperty("port"));
			oamPass = prop.getProperty("oam.password");
			oamUsername = prop.getProperty("oam.username");
			hipchatToken = prop.getProperty("hipchat.token");
			hipchatRoom = prop.getProperty("hipchat.room");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the partnerPass
	 */
	public String getPartnerPass() {
		return partnerPass;
	}

	/**
	 * @param partnerPass the partnerPass to set
	 */
	public void setPartnerPass(String partnerPass) {
		this.partnerPass = partnerPass;
	}

	/**
	 * @return the telcoCodes
	 */
	public String getTelcoCodes() {
		return telcoCodes;
	}

	/**
	 * @param telcoCodes the telcoCodes to set
	 */
	public void setTelcoCodes(String telcoCodes) {
		this.telcoCodes = telcoCodes;
	}

	/**
	 * @return the partnerId
	 */
	public String getPartnerId() {
		return partnerId;
	}

	/**
	 * @param partnerId the partnerId to set
	 */
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @return the shootCode
	 */
	public String getShootCode() {
		return shootCode;
	}

	/**
	 * @param shootCode the shootCode to set
	 */
	public void setShootCode(String shootCode) {
		this.shootCode = shootCode;
	}

	/**
	 * @return the azPortalUserName
	 */
	public String getAzPortalUserName() {
		return azPortalUserName;
	}

	/**
	 * @param azPortalUserName the azPortalUserName to set
	 */
	public void setAzPortalUserName(String azPortalUserName) {
		this.azPortalUserName = azPortalUserName;
	}

	/**
	 * @return the azPortalPass
	 */
	public String getAzPortalPass() {
		return azPortalPass;
	}

	/**
	 * @param azPortalPass the azPortalPass to set
	 */
	public void setAzPortalPass(String azPortalPass) {
		this.azPortalPass = azPortalPass;
	}

	/**
	 * @return the urlPartner
	 */
	public String getUrlPartner() {
		return urlPartner;
	}

	/**
	 * @param urlPartner the urlPartner to set
	 */
	public void setUrlPartner(String urlPartner) {
		this.urlPartner = urlPartner;
	}

	/**
	 * @return the ahpUsername
	 */
	public String getAhpUsername() {
		return ahpUsername;
	}

	/**
	 * @param ahpUsername the ahpUsername to set
	 */
	public void setAhpUsername(String ahpUsername) {
		this.ahpUsername = ahpUsername;
	}

	/**
	 * @return the ahpPassword
	 */
	public String getAhpPassword() {
		return ahpPassword;
	}

	/**
	 * @param ahpPassword the ahpPassword to set
	 */
	public void setAhpPassword(String ahpPassword) {
		this.ahpPassword = ahpPassword;
	}

	/**
	 * @return the oamPass
	 */
	public String getOamPass() {
		return oamPass;
	}

	/**
	 * @param oamPass the oamPass to set
	 */
	public void setOamPass(String oamPass) {
		this.oamPass = oamPass;
	}

	/**
	 * @return the oamUsername
	 */
	public String getOamUsername() {
		return oamUsername;
	}

	/**
	 * @param oamUsername the oamUsername to set
	 */
	public void setOamUsername(String oamUsername) {
		this.oamUsername = oamUsername;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the hipchatToken
	 */
	public String getHipchatToken() {
		return hipchatToken;
	}

	/**
	 * @param hipchatToken the hipchatToken to set
	 */
	public void setHipchatToken(String hipchatToken) {
		this.hipchatToken = hipchatToken;
	}

	/**
	 * @return the hipchatRoom
	 */
	public String getHipchatRoom() {
		return hipchatRoom;
	}

	/**
	 * @param hipchatRoom the hipchatRoom to set
	 */
	public void setHipchatRoom(String hipchatRoom) {
		this.hipchatRoom = hipchatRoom;
	}
}
