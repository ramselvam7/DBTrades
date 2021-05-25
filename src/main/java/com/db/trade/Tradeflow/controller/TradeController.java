package com.db.trade.Tradeflow.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.db.trade.Tradeflow.model.TradeDetails;
import com.db.trade.Tradeflow.service.TradeService;

@Controller
public class TradeController {
	
	@Autowired 
	TradeService tradeService;

	@RequestMapping("/")
	public String getTradeHome(TradeDetails trade) {

		return "TradeHome.jsp";

	}

	@RequestMapping("/addTrade")
	public String addTrade(@Valid TradeDetails trade) {

		return tradeService.persistUpdateTrade(trade);
	}
}
