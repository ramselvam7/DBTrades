package com.db.trade.Tradeflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.trade.Tradeflow.model.TradeDetails;

@Repository
public interface TradeDao extends JpaRepository<TradeDetails, Integer> {
	
	public TradeDetails findByTradeID(String tradeID);

}
