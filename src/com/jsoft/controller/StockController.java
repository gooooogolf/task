/**
 * 
 */
package com.jsoft.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jsoft.controller.editors.DealerEditor;
import com.jsoft.controller.editors.OrganizationEditor;
import com.jsoft.controller.editors.UserEditor;
import com.jsoft.model.Dealer;
import com.jsoft.model.Organization;
import com.jsoft.model.Stock;
import com.jsoft.model.User;
import com.jsoft.service.DealerService;
import com.jsoft.service.OrganizationService;
import com.jsoft.service.StockService;
import com.jsoft.service.UserService;

/**
 * @author Sirimongkol
 *
 */
@Controller
@RequestMapping({"/stock", "/stocks"})
public class StockController {
	
	@Autowired
	private StockService stockService;
	@Autowired
	private OrganizationService organizationService;
	@Autowired
	private DealerService dealerService;
	@Autowired
	private UserService userService;

	
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("dd/MM/yyyy"), true));
    	binder.registerCustomEditor(Organization.class, new OrganizationEditor(organizationService));
    	binder.registerCustomEditor(Dealer.class, new DealerEditor(dealerService));
        binder.registerCustomEditor(User.class, new UserEditor(userService));
    }
	
	@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String searchStockByStockYear(@RequestParam(required = false) String stockYear, Model model) {	
//		stockYear = (stockYear == null ? DateTime.yyyy_TH() : stockYear);
//		List<String> years = new ArrayList<String>();
//		int divYear = Integer.parseInt(DateTime.yyyy_TH()) - 4;
//		for (int i = 0; i < 5; i++) {
//			years.add(String.valueOf(divYear));
//			divYear++;
//		}
		
		List<String> years =  stockService.getStockYear();
		stockYear = (stockYear == null ? years.get(years.size() - 1) : stockYear);
		
		List<Stock> stocks = stockService.searchStockByStockYear(stockYear);
		
		model.addAttribute("stocks", stocks);
		model.addAttribute("years", years);
		model.addAttribute("stockYear", stockYear);
        return "stocks/list";
    }
	
	
	@RequestMapping(value = "/organization", method = RequestMethod.GET)
    public String getStocksByOrgId(@RequestParam("orgId") String orgId, Model model) {
		
		Organization organization = organizationService.getOrganizationByOrgId(orgId);
		model.addAttribute("organization", organization);
		
		List<Stock> stocks = stockService.searchStockByOrganizeId(orgId);
		model.addAttribute("stocks", stocks);
		
        return "stocks/organization";
    }
	
	@RequestMapping(value = "/dealer", method = RequestMethod.GET)
    public String getStocksByDealerId(@RequestParam("dealerId") String dealerId, Model model) {
		
		model.addAttribute("dealer", dealerService.find(Integer.parseInt(dealerId)));
		
		List<Stock> stocks = stockService.searchStockByDealerId(dealerId);
		model.addAttribute("stocks", stocks);
		
        return "stocks/dealer";
    }
	
	@RequestMapping(value = "/organization-for-update", method = {RequestMethod.GET, RequestMethod.POST})
    public String getStocksByOrgIdForUpdate(@RequestParam("orgId") String orgId, @RequestParam(required = false) String stockYear, Model model) {

//		stockYear = (stockYear == null ? DateTime.yyyy_TH() : stockYear);	
//		List<String> years = new ArrayList<String>();
//		int divYear = Integer.parseInt(DateTime.yyyy_TH()) - 4;
//		for (int i = 0; i < 5; i++) {
//			years.add(String.valueOf(divYear));
//			divYear++;
//		}
		List<String> years =  stockService.getStockYear();
		stockYear = (stockYear == null ? years.get(years.size() - 1) : stockYear);
		
		List<Stock> stocks = stockService.searchStockFreeByStockYear(stockYear);
		Organization organization = organizationService.getOrganizationByOrgId(orgId);
		
		model.addAttribute("organization", organization);
		model.addAttribute("stocks", stocks);
		model.addAttribute("years", years);
		model.addAttribute("stockYear", stockYear);
        return "stocks/organization-for-update";
    }
	
	@RequestMapping(value = "/dealer-for-update", method = {RequestMethod.GET, RequestMethod.POST})
    public String getStocksByDealerIdForUpdate(@RequestParam("dealerId") String dealerId, @RequestParam(required = false) String stockYear, Model model) {

//		stockYear = (stockYear == null ? DateTime.yyyy_TH() : stockYear);
		
//		List<String> years = new ArrayList<String>();
//		int divYear = Integer.parseInt(DateTime.yyyy_TH()) - 4;
//		for (int i = 0; i < 5; i++) {
//			years.add(String.valueOf(divYear));
//			divYear++;
//		}
		List<String> years =  stockService.getStockYear();
		stockYear = (stockYear == null ? years.get(years.size() - 1) : stockYear);
		
		List<Stock> stocks = stockService.searchStockFreeByStockYear(stockYear);
	
		model.addAttribute("dealer", dealerService.find(Integer.parseInt(dealerId)));
		
		model.addAttribute("stocks", stocks);
		model.addAttribute("years", years);
		model.addAttribute("stockYear", stockYear);
        return "stocks/dealer-for-update";
    }
	
	@RequestMapping(value = "/organization-new", method = RequestMethod.POST)
    public String createStocksByOrgIdAndIds(@RequestParam("orgId") String orgId, @RequestParam("ids") String ids, Model model) {
		try {
			String [] __ids = (ids != null) ? ids.split(",") : null;
			
			List<Stock> stocks = new ArrayList<Stock>();
					
			if (__ids != null) {
				for (String id:__ids) {
					stocks.add(stockService.find(Integer.parseInt(id)));
				}
				model.addAttribute("stockYear", stocks.get(0).getStockYear());
			}
		
			model.addAttribute("ids", ids);
			model.addAttribute("stocks", stocks);
			
			Organization organization = organizationService.getOrganizationByOrgId(orgId);
			model.addAttribute("organization", organization);
			
			return "stocks/organization-new";
		} catch (Exception e) {
//			return "redirect:/stocks/organization?orgId=" + orgId;
			return "redirect:/stocks/organization-for-update?orgId=" + orgId;
		}
		
    }
	
	@RequestMapping(value = "/dealer-new", method = RequestMethod.POST)
    public String createStocksByDealerIdAndIds(@RequestParam("dealerId") String dealerId, @RequestParam("ids") String ids, Model model) {
		try {
			String [] __ids = (ids != null) ? ids.split(",") : null;
			
			List<Stock> stocks = new ArrayList<Stock>();
					
			if (__ids != null) {
				for (String id:__ids) {
					stocks.add(stockService.find(Integer.parseInt(id)));
				}
				model.addAttribute("stockYear", stocks.get(0).getStockYear());
			}
		
			model.addAttribute("ids", ids);
			model.addAttribute("stocks", stocks);
			
			model.addAttribute("dealer", dealerService.find(Integer.parseInt(dealerId)));
			
			return "stocks/dealer-new";
		} catch (Exception e) {
//			return "redirect:/stocks/dealer?dealerId=" + dealerId;
			return "redirect:/stocks/dealer-for-update?dealerId=" + dealerId;
		}

    }
	
	@RequestMapping(value = "/organization-save", method = RequestMethod.POST)
    public String saveStocksByOrgIdAndIds(@RequestParam("orgId") String orgId, 
    		@RequestParam("ids") String ids,
    		@RequestParam("userModify") String userModify,
    		@RequestParam(required = false) String licenseRequest, 
    		@RequestParam(required = false) String licenseNumber, 
    		@RequestParam(required = false) String description, 
    		Model model, HttpServletRequest request) {
		
		Organization organization = organizationService.getOrganizationByOrgId(orgId);
		model.addAttribute("organization", organization);
		
		User user = userService.get(userModify);
		
		String [] __ids = (ids != null) ? ids.split(",") : null;
		
		Stock stock = null;
		if (__ids != null) {
			for (String id:__ids) {
				stock = stockService.find(Integer.parseInt(id));
				stock.setLicenseRequest(licenseRequest);
				stock.setLicenseNumber(licenseNumber);
				stock.setReceiver(request.getParameter("receiver_" + id));
				stock.setAmp(request.getParameter("amp_" + id));
				stock.setOrganization(organization);
				stock.setUserModify(user);
				stock.setEffectiveDate(new Date());
				if(description != null) {
					stock.setDescription(description);
				}
				stockService.saveOrUpdate(stock);
			}
		}
	
		model.addAttribute("stocks", stockService.searchStockByOrganizeId(orgId));
		
		return "redirect:/stocks/organization?orgId=" + orgId;
    }
	
	@RequestMapping(value = "/dealer-save", method = RequestMethod.POST)
    public String saveStocksByDealerIdAndIds(@RequestParam("dealerId") String dealerId, 
    		@RequestParam("ids") String ids,
    		@RequestParam("userModify") String userModify,
    		@RequestParam(required = false) String licenseRequest, 
    		@RequestParam(required = false) String licenseNumber, 
    		@RequestParam(required = false) String description, 
    		Model model, HttpServletRequest request) {
		
		Dealer dealer = dealerService.find(Integer.parseInt(dealerId));
		model.addAttribute("dealer", dealerService.find(Integer.parseInt(dealerId)));
		
		User user = userService.get(userModify);
		
		String [] __ids = (ids != null) ? ids.split(",") : null;
		
		Stock stock = null;
		if (__ids != null) {
			for (String id:__ids) {
				stock = stockService.find(Integer.parseInt(id));
				stock.setLicenseRequest(licenseRequest);
				stock.setLicenseNumber(licenseNumber);
				stock.setReceiver(request.getParameter("receiver_" + id));
				stock.setAmp(request.getParameter("amp_" + id));
				stock.setDealer(dealer);
				stock.setUserModify(user);
				stock.setEffectiveDate(new Date());
				if(description != null) {
					stock.setDescription(description);
				}
				stockService.saveOrUpdate(stock);
			}
		}
	
		model.addAttribute("stocks", stockService.searchStockByDealerId(dealerId));
		
		return "redirect:/stocks/dealer?dealerId=" + dealerId;
    }
	
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String view(@RequestParam("id") int id, @RequestParam(required = false) String stockYear, Model model) {	
		Stock stock = stockService.find(id);
		model.addAttribute("stockYear", stockYear);
		model.addAttribute("stock", stock);
        return "stocks/view";
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("stock") Stock stock) {
		stock.setEffectiveDate(new Date());
		stockService.update(stock);			
		return "redirect:/stock?stockYear=" + stock.getStockYear() + "#" + stock.getSerialNumber();	
    }
	
	@RequestMapping(value = "/organization/delete", method = RequestMethod.DELETE)
    public String deleteByOrg(@RequestParam("orgId") String orgId, @RequestParam("stockId") int stockId) {
		Stock stock = stockService.find(stockId);
		stock.setEffectiveDate(new Date());
		stock.setLicenseNumber(null);
		stock.setLicenseRequest(null);
		stock.setAmp(null);
		stock.setReceiver(null);
		stock.setDealer(null);
		stock.setOrganization(null);
		stock.setDescription(null);
		stockService.update(stock);			
		return "redirect:/stock/organization?orgId=" + orgId;	
    }
	
	@RequestMapping(value = "/dealer/delete", method = RequestMethod.DELETE)
    public String deleteByDealer(@RequestParam("dealerId") String dealerId, @RequestParam("stockId") int stockId) {
		Stock stock = stockService.find(stockId);
		stock.setEffectiveDate(new Date());
		stock.setLicenseNumber(null);
		stock.setLicenseRequest(null);
		stock.setAmp(null);
		stock.setReceiver(null);
		stock.setDealer(null);
		stock.setOrganization(null);
		stock.setDescription(null);
		stockService.update(stock);			
		return "redirect:/stock/dealer?dealerId=" + dealerId;	
    }
}
