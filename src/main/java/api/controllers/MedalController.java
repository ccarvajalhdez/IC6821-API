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
import api.pojos.Medal;
import api.views.GroupView;

@RestController
@RequestMapping("/api/v0/")
public final class MedalController {
	
	@Autowired
	private VisualizationService visualizationService;
	
	@RequestMapping(value = "medals/{username}", method = RequestMethod.GET)
	public ArrayList<Medal> selectMedals(HttpServletResponse response,
			@PathVariable("username") String userId) {
		GroupView groupView = new GroupView();
		try {
			List<Medal> medals = visualizationService.showMedals(userId);
			int status = 0;
			if (medals != null) {
				status = HttpServletResponse.SC_FOUND;
				groupView.setMedals(medals); }
			else {
				status = HttpServletResponse.SC_NOT_FOUND; }
			response.setStatus(status);
			return groupView.getMedals(); }
		catch(Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return groupView.getMedals(); } }
}