package com.db.trade.Tradeflow.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
				if (td.getVersion() <= trade.getVersion()) {
					td.setBookId(trade.getBookId());
					td.setCounterPartyID(trade.getCounterPartyID());
					td.setVersion(trade.getVersion());
					td.setCreatedDate(new Date());
					if (trade.getMaturityDate().after(new Date())) {
						td.setExpiredInd("N");
					} else {
						td.setExpiredInd("Y");
					}
					tradeDao.save(td);
					return "Update.jsp";
				} else {
					return "VersionError.jsp";
				}

			} else {

				if (trade.getMaturityDate().after(new Date())) {
					trade.setCreatedDate(new Date());
					trade.setExpiredInd("Y");
					tradeDao.save(trade);
					return "Savesuccess.jsp";
				} else {
					return "DateError.jsp";
				}
			}

		}
		return "TradeError.jsp";

	}

}
