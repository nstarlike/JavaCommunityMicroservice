package nstarlike.jcm.email.service;

import nstarlike.jcm.user.dto.UserEvent;

public interface EmailService {
	public void sendSimpleMessage(UserEvent userEvent);
}
