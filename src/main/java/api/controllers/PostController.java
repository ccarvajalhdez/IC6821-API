package api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.models.CommentPost;
import api.models.Publication;
import api.services.UserFunctionsServiceMock;

@RestController
public final class PostController {
	
	@RequestMapping(
			value = "/api/v0/users/posts",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addPost(@RequestBody Publication publication) {
		try {
			new UserFunctionsServiceMock().publish(publication.getPublisher(),
					publication.getDescription(), publication.getCode(), publication.getLanguage());
			return new ResponseEntity<String>("", HttpStatus.CREATED); }
		catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST); } }
	
	
	@RequestMapping(
			value = "/api/v0/users/posts/{id}/comments",
			method = RequestMethod.PUT,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> commentPost(@PathVariable("id") int id, @RequestBody CommentPost commentPost) {
		try {
			new UserFunctionsServiceMock().commentPublication(id, commentPost.getUsername(), commentPost.getComment());
			return new ResponseEntity<String>("", HttpStatus.CREATED); }
		catch (Exception e) {
			return new ResponseEntity<String>("", HttpStatus.BAD_REQUEST); } }

}
