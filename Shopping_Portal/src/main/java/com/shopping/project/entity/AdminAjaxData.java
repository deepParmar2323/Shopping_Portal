package com.shopping.project.entity;

import java.util.List;

public class AdminAjaxData {

	private int draw;
	private Long recordsTotal;
	private Long recordsFiltered;
	private List<Admin> data;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public List<Admin> getData() {
		return data;
	}

	public Long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public Long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(Long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public void setData(List<Admin> data) {
		this.data = data;
	}

}
