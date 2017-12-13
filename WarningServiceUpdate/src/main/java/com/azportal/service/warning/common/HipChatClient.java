/**
 * 
 */
package com.azportal.service.warning.common;

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

			this.hipChat = new HipChat(Utils.getServerProperties().getHipchatToken());

		} catch (FoxHttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int SendHipChatMessage(String message) {
		try {
			if (this.hipChat != null)
				this.hipChat.roomsApi().sendRoomNotification(Utils.getServerProperties().getHipchatRoom(),
						new Notification(null, null, MessageColor.RED, null, true, message, null));
		} catch (FoxHttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return 1;
	}
}
