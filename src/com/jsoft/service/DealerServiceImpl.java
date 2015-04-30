/**
 * 
 */
package com.jsoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.dao.DealerDAO;
import com.jsoft.model.Dealer;

/**
 * @author Sirimongkol
 *
 */
@Service("dealerService")
@Transactional
public class DealerServiceImpl implements DealerService {
	
	@Autowired
	private DealerDAO dealerDAO;
	
	@Override
	public Dealer find(Integer id) {
		// TODO Auto-generated method stub
		return dealerDAO.find(id);
	}

	@Override
	public void save(Dealer clazz) {
		// TODO Auto-generated method stub
		dealerDAO.save(clazz);
	}

	@Override
	public void update(Dealer clazz) {
		// TODO Auto-generated method stub
		dealerDAO.update(clazz);
	}

	@Override
	public void saveOrUpdate(Dealer clazz) {
		// TODO Auto-generated method stub
//		System.out.println("service impl is " + clazz);
		dealerDAO.saveOrUpdate(clazz);
	}

	@Override
	public List<Dealer> findAll() {
		// TODO Auto-generated method stub
		return dealerDAO.findAll();
	}

	@Override
	public Integer countAll() {
		// TODO Auto-generated method stub
		return dealerDAO.countAll();
	}

	@Override
	public void delete(Dealer clazz) {
		// TODO Auto-generated method stub
		dealerDAO.delete(clazz);
	}

	@Override
	public List<Dealer> getDealerByTerm(String dealerName) {
		// TODO Auto-generated method stub
		return dealerDAO.getDealerByTerm(dealerName);
	}

	@Override
	public List<Dealer> getDealerByTermLimit(String dealerName, int limit) {
		// TODO Auto-generated method stub
		return dealerDAO.getDealerByTermLimit(dealerName, limit);
	}

}
