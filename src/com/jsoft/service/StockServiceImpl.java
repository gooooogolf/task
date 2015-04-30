package com.jsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.dao.StockDAO;
import com.jsoft.model.Stock;

@Service("stockService")
@Transactional
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDAO stockDAO;
	
	@Override
	public List<Stock> searchStockByOrganizeId(String orgId) {
		// TODO Auto-generated method stub
		return stockDAO.searchStockByOrganizeId(orgId);
	}

	@Override
	public List<Stock> searchStockByDealerId(String dealerId) {
		// TODO Auto-generated method stub
		return stockDAO.searchStockByDealerId(dealerId);
	}

	@Override
	public List<Stock> searchStockBySerialNumber(String serialNumber) {
		// TODO Auto-generated method stub
		return stockDAO.searchStockBySerialNumber(serialNumber);
	}

	@Override
	public List<Stock> searchStockByStockYear(String stockYear) {
		// TODO Auto-generated method stub
		return stockDAO.searchStockByStockYear(stockYear);
	}

	@Override
	public Stock find(Integer id) {
		// TODO Auto-generated method stub
		return stockDAO.find(id);
	}

	@Override
	public void save(Stock clazz) {
		// TODO Auto-generated method stub
		stockDAO.save(clazz);
	}

	@Override
	public void update(Stock clazz) {
		// TODO Auto-generated method stub
		stockDAO.update(clazz);
	}

	@Override
	public void saveOrUpdate(Stock clazz) {
		// TODO Auto-generated method stub
		stockDAO.saveOrUpdate(clazz);
	}

	@Override
	public List<Stock> findAll() {
		// TODO Auto-generated method stub
		return stockDAO.findAll();
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return stockDAO.countAll();
	}

	@Override
	public void delete(Stock clazz) {
		// TODO Auto-generated method stub
		stockDAO.delete(clazz);
	}

	@Override
	public List<Stock> searchStockFreeByStockYear(String stockYear) {
		// TODO Auto-generated method stub
		return stockDAO.searchStockFreeByStockYear(stockYear);
	}

	@Override
	public List<String> getStockYear() {
		// TODO Auto-generated method stub
		return stockDAO.getStockYear();
	}

}
