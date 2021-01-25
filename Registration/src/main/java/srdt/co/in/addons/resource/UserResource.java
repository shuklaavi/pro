package srdt.co.in.addons.resource;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import srdt.co.in.addons.model.User;
import srdt.co.in.addons.repo.UserRepo;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	public UserRepo repo; 
	
	@RequestMapping("/msg")
	public List<User> getmsg() {
		return repo.findAll();
	}
	
	@PostMapping("/save")
	public User save(@RequestBody User user) {
		User user2 = new User();
		user2.setId(user.getId());
		user2.setName(user.getName());
		return repo.save(user2);
	}
	@PutMapping("/update")
	public User updateUser(@RequestBody User us) {
		User t = repo.findById(us.getId()).get();
		if(t.getId() != null) {
			t.setName(us.getName());
			return repo.saveAndFlush(t);
		}
		return t;
	}
	
	@PatchMapping("/patch")
	public User patch(@RequestBody User us) {
		User t = repo.findById(us.getId()).get();
		if(t.getId() != null) {
			t.setName(us.getName());
			return repo.saveAndFlush(t);
		}
		return t;
	}
	
}
