package api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.interfaces.VisualizationService;
import api.pojos.Notification;
import api.views.GroupView;
import api.views.NotificationView;

@RestController
@RequestMapping("/api/v0/")
public final class NotificationController {
	
	@Autowired
	private VisualizationService visualizationService;
	
	@RequestMapping(value = "notifications/{username}", method = RequestMethod.GET)
	public ArrayList<NotificationView> selectNotifications(HttpServletResponse response,
			@PathVariable("username") String userId) {
		GroupView groupView = new GroupView();
		try {
			List<Notification> notifications = visualizationService.showUserNotifications(userId);
			int status = 0;
			if (notifications != null) {
				status = HttpServletResponse.SC_FOUND;
				groupView.setNotifications(notifications); }
			else {
				status = HttpServletResponse.SC_NOT_FOUND; }
			response.setStatus(status);
			return groupView.getNotifications(); }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return groupView.getNotifications(); } }
}