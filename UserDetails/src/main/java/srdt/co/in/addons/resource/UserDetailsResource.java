package srdt.co.in.addons.resource;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import srdt.co.in.addons.model.User;

@RestController
@RequestMapping("/userdetails")
public class UserDetailsResource {

	@Value("${baseUrl}")
	public String baseUrl;
	
	@Autowired
	public HttpHeaders headers;
	
	@Autowired
	public RestTemplate rest;
	
	@RequestMapping("/details")
	public ResponseEntity<User[]> getDetails() {
	// ResponseEntity<User[]> t =  rest.getForEntity(baseUrl + "/user/msg",  User[].class)	;
	 headers.setContentType(MediaType.APPLICATION_JSON);
	 HttpEntity<String> request = new HttpEntity<>(headers);
	 String url =baseUrl+ "/user/msg";
	 ResponseEntity<User[]> response = rest.exchange(url, HttpMethod.GET, request,User[].class);
	return response;
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> save(@RequestBody User user) {
	//User t = rest.postForObject(baseUrl+"/user/save" , user, User.class)	;
		String url = baseUrl+"/user/save";
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> request = new HttpEntity<User>(user,headers);
		ResponseEntity<User> t = rest.exchange(url, HttpMethod.POST, request, User.class);
	return t;
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateUser(@RequestBody User us) {
		// rest.put(baseUrl+"/user/update/" , us)	;
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<String> request = new HttpEntity(us, headers);
		 String url =baseUrl+"/user/update/";
		 ResponseEntity<String> response = rest.exchange(url, HttpMethod.PUT, request,  String.class);
		
		return response;
	}
	
	@PatchMapping("/patch")
	public User update(@RequestBody User user) {
		User t = rest.patchForObject(baseUrl+"/user/patch" , user,User.class)	;
		return t;
	}
}
