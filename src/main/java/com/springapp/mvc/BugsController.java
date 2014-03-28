package com.springapp.mvc;

import classes.Bug;
import classes.MemoryStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class BugsController {
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		return "index";
	}


    @RequestMapping(value = "/allbugs/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Bug getBug(@PathVariable int id) {
		return MemoryStorage.getBug(id);
	}

    @RequestMapping(value = "/allbugs", method = RequestMethod.GET)
    public @ResponseBody
    List<Bug> allBugs(ModelMap model) {
		return MemoryStorage.getAllBugs();
	}

    @RequestMapping(value = "/openbugs", method = RequestMethod.GET)
    public @ResponseBody
    List<Bug> allOpenBugs(ModelMap model) {
		return MemoryStorage.getOpenBugs();
	}

    @RequestMapping(value = "/getusers", method = RequestMethod.GET)
    public @ResponseBody
    List<String> getUsers(ModelMap model) {
		return MemoryStorage.getUsers();
	}


    @RequestMapping(value = "/createbug", method = RequestMethod.POST)
    public @ResponseBody
    void createBug(@RequestBody Bug bug) {
		MemoryStorage.createBug(bug);
	}

    @RequestMapping(value = "/updatebug", method = RequestMethod.POST)
    public @ResponseBody
    void updatebug(@RequestBody Bug bug) {
		MemoryStorage.updateBug(bug);

	}



}