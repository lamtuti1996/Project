/**
 * 
 */
package com.azplay.azpotal.azgate.sc.util;

import com.azplay.azpotal.azgate.sc.app.Server;

import ch.viascom.groundwork.foxhttp.exception.FoxHttpException;
import ch.viascom.hipchat.api.HipChat;
import ch.viascom.hipchat.api.models.Notification;
import ch.viascom.hipchat.api.models.message.MessageColor;

/**
 * @author thang
 *
 */
public class HipChatClient {
	
	private HipChat hipChat = null;
	
	public HipChatClient() {
		try {
			this.hipChat = new HipChat(Server.serverConfig.getHipchatToken());
		} catch (FoxHttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void SendHipChatMessage(String message) {
		try {
			if (this.hipChat != null)
				this.hipChat.roomsApi().sendRoomNotification(Server.serverConfig.getHipchatRoom(), new Notification(null, null, MessageColor.RED, null, true, message, null));
		} catch (FoxHttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
