package com.db.trade.Tradeflow.service;

import java.util.Date;

import javax.transaction.Transactional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.db.trade.Tradeflow.constants.TradeConstants;
import com.db.trade.Tradeflow.model.TradeDetails;
import com.db.trade.Tradeflow.repository.TradeDao;

@Service
@Transactional
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeDao tradeDao;

	public String persistUpdateTrade(TradeDetails trade) {

		String tradeID = trade.getTradeID();

		if (StringUtils.isNotBlank(tradeID) && StringUtils.isNotBlank(trade.getBookId())
				&& StringUtils.isNotBlank(trade.getCounterPartyID()) && null != trade.getMaturityDate()) {
			TradeDetails td = tradeDao.findByTradeID(tradeID);
			if (null != td) {
				//check if higher version of same trade is present already
				if (td.getVersion() <= trade.getVersion()) {
					td.setBookId(trade.getBookId());
					td.setCounterPartyID(trade.getCounterPartyID());
					td.setVersion(trade.getVersion());
					td.setCreatedDate(new Date());
					//check if maturity date is greater than today's date
					if (trade.getMaturityDate().after(new Date())) {
						td.setExpiredInd(TradeConstants.N);
					} else {
						td.setExpiredInd(TradeConstants.Y);
					}
					tradeDao.save(td);
					return TradeConstants.TRADE_UPDATE;
				} else {
					return TradeConstants.TRADE_VERSION_ERROR;
				}

			} else {
				//check if maturity date is greater than today's date	
				if (trade.getMaturityDate().after(new Date())) {
					trade.setCreatedDate(new Date());
					trade.setExpiredInd(TradeConstants.N);
					tradeDao.save(trade);
					return TradeConstants.TRADE_SAVED;
				} else {
					return TradeConstants.TRADE_DATE_ERROR;
				}
			}

		}
		return TradeConstants.TRADE_FIELD_ERROR;

	}

}
