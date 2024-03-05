package com.shopping.project.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.project.entity.Admin;
import com.shopping.project.entity.AdminAjaxData;
import com.shopping.project.service.AdminService;

@RestController
public class RestApiController {

	@Autowired
	private AdminService adminService;

	@GetMapping("/admin/retrive")
	public AdminAjaxData retriveData(@RequestParam int draw, @RequestParam int start, @RequestParam int length,
			@RequestParam(value = "search[value]") String search) {

		Page<Admin> admin = adminService.getPaginateAdmin(start / length, length, search);
		AdminAjaxData data = new AdminAjaxData();
		data.setDraw(draw);
		data.setRecordsTotal(admin.getTotalElements());
		data.setRecordsFiltered(admin.getTotalElements());
		data.setData(admin.getContent());

		return data;
	}
}
