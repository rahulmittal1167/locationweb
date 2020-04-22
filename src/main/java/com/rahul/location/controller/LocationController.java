package com.rahul.location.controller;


import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rahul.location.entities.Location;
import com.rahul.location.repository.LocationRepository;
import com.rahul.location.service.LocationService;
import com.rahul.location.util.EmailUtil;
import com.rahul.location.util.ReportUtil;



@Controller
public class LocationController {
	
	@Autowired
	LocationService service;
	
	@Autowired
	LocationRepository repository;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	EmailUtil emailUtil;
	
	@RequestMapping("/showCreated")
	public String showCreate()
	{
		System.out.println(" In Show Create");
		return "createLocation"; 
		
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		System.out.println("Hello1");
	
		Location locationSaved = service.saveLocation(location);
		System.out.println("Hello2");
		String msg= "Location saved with id"+ locationSaved.getId();
		modelMap.addAttribute("msg", msg);
		
		emailUtil.sendEmail("rahulmittal1533214@gmail.com", "Location Saved", "Location is saved successfully");
		
		return "createLocation";
	}
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelMap)
	{
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("deleteLocation")
	public String deleteLocation(@RequestParam("id") int id,ModelMap modelMap)
	{
		Location locationById = service.getLocationById(id);
		service.deleteLocation(locationById);
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}

	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id") int id,ModelMap modelMap)
	{
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap)
	{
		service.updateLocation(location);
		List<Location> allLocations = service.getAllLocations();
		modelMap.addAttribute("locations",allLocations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport()
	{
		
		/* It will return as the web application root,
		 *  when our application run on servicer it will take the path(relative)
		 *  and then we use that path to store our image,
		 *  so that jsp can point to it and read it send it back to user
		 */
		String path = context.getRealPath("/");    
		List<Object[]>  data = repository.findByTypeAndTypeCount();
		reportUtil.generatePieChart(path, data);
		return "report";
	
	}
}
