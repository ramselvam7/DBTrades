package com.db.trade.Tradeflow.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.db.trade.Tradeflow.constants.TradeConstants;
import com.db.trade.Tradeflow.model.TradeDetails;
import com.db.trade.Tradeflow.service.TradeService;

@Controller
public class TradeController {
	
	@Autowired 
	TradeService tradeService;

	@RequestMapping("/")
	public String getTradeHome(TradeDetails trade) {

		return TradeConstants.TRADE_HOME;

	}

	@RequestMapping("/addTrade")
	public String addTrade(@Valid TradeDetails trade,BindingResult result, Model model){
		if(result.hasErrors()){
			return TradeConstants.TRADE_FIELD_ERROR;
        }
		return tradeService.persistUpdateTrade(trade);
        
	}
}
