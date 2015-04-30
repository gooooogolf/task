/**
 * 
 */
package com.jsoft.dao;

import java.util.List;

import com.jsoft.model.Stock;

/**
 * @author Sirimongkol
 *
 */
public interface StockDAO extends GenericDAO<Stock> {
	
	public List<Stock> searchStockByOrganizeId(String orgId);
	public List<Stock> searchStockByDealerId(String dealerId);
	public List<Stock> searchStockBySerialNumber(String serialNumber);
	public List<Stock> searchStockByStockYear(String stockYear);
	public List<Stock> searchStockFreeByStockYear(String stockYear);
	public List<String> getStockYear();
	
}
