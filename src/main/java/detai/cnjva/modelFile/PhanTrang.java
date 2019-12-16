package detai.cnjva.modelFile;

import java.util.ArrayList;

public class PhanTrang<E> {
		
	private int total_items, limit, page, currentPage, start,total_pages;

	private ArrayList<E> list;

	private ArrayList<Integer> listPage;
	
	public ArrayList<Integer> getListPage() {
		return listPage;
	}

	public void setListPage(ArrayList<Integer> listPage) {
		this.listPage = listPage;
	}

	public int getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(int total_pages) {
		this.total_pages = total_pages;
	}

	public ArrayList<E> getList() {
		return list;
	}

	public void setList(ArrayList<E> list) {
		this.list = list;
	}

	public int getTotal_items() {
		return total_items;
	}

	public void setTotal_items(int total_items) {
		this.total_items = total_items;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}
	public PhanTrang(ArrayList<E> arrayList,int page,int limit) {
		this.limit = limit;
		this.total_items = arrayList.size();
		this.total_pages = arrayList.size() % limit == 0 ?arrayList.size() / limit : (arrayList.size() / limit )+1;
		this.currentPage = page >= this.total_pages ? this.total_pages : page;
		this.start = (page - 1)*limit;
		ArrayList<E> listTemp = new ArrayList<>();
		int length;
		if(this.currentPage == this.total_pages)
		{
			length = arrayList.size();
		}
		else
			length = this.start + limit;
		for (int i = this.start; i < length; i++) {
			listTemp.add(arrayList.get(i));
		}
		this.list = listTemp;
		/////////////////
		ArrayList<Integer> listPageTemp = new ArrayList<>();
		for (int i = 0; i < this.total_pages; i++) {
			listPageTemp.add(i+1);
		}
		this.listPage = listPageTemp;
	}

}
