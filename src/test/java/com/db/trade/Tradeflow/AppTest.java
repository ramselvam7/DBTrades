package com.db.trade.Tradeflow;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.db.trade.Tradeflow.model.TradeDetails;
import com.db.trade.Tradeflow.repository.TradeDao;
import com.db.trade.Tradeflow.service.TradeServiceImpl;

import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest  extends TestCase
{
   @Autowired
   private TradeDao tradeDao;   
   
   @Autowired
   private TradeServiceImpl tradeServiceImpl;

    @Test
	public void testSaveRetrieveTrade() throws ParseException
	{
    	TradeDetails tradeDetails = new TradeDetails();
		tradeDetails.setTradeID("T1");
		tradeDetails.setVersion(3);
		tradeDetails.setCounterPartyID("C-1");
		tradeDetails.setBookId("B1");
		tradeDetails.setCreatedDate(new Date());
		tradeDetails.setMaturityDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2025"));
		tradeDetails.setExpiredInd("N");
		tradeDao.save(tradeDetails);
		
		TradeDetails td = tradeDao.findByTradeID("T1");		
		
		assertNotNull(td);
		assertEquals(tradeDetails.getBookId(), td.getBookId());
	
	}  
    
    @Test
   	public void testVersion() throws ParseException
   	{
       	TradeDetails tradeDetails = new TradeDetails();
   		tradeDetails.setTradeID("T1");
   		tradeDetails.setVersion(3);
   		tradeDetails.setCounterPartyID("C-1");
   		tradeDetails.setBookId("B1");
   		tradeDetails.setCreatedDate(new Date());
   		tradeDetails.setMaturityDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2025"));
   		tradeDetails.setExpiredInd("N");
   		tradeDao.save(tradeDetails);
   		
	   		
   		TradeDetails tradeDetailsVersion = new TradeDetails();
   		tradeDetailsVersion.setTradeID("T1");
   		tradeDetailsVersion.setVersion(5);
   		tradeDetailsVersion.setCounterPartyID("C-1");
   		tradeDetailsVersion.setBookId("B1");
   		tradeDetailsVersion.setCreatedDate(new Date());
   		tradeDetailsVersion.setMaturityDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2025"));
   		tradeDetailsVersion.setExpiredInd("N");
   		
   		String result = tradeServiceImpl.persistUpdateTrade(tradeDetails);
   		
   		assertEquals(result, "Update");

   	}  
    
    @Test
   	public void testTradeMaturityDate() throws ParseException
   	{
       	TradeDetails tradeDetails = new TradeDetails();
   		tradeDetails.setTradeID("T5");
   		tradeDetails.setVersion(3);
   		tradeDetails.setCounterPartyID("C-1");
   		tradeDetails.setBookId("B1");
   		tradeDetails.setCreatedDate(new Date());
   		tradeDetails.setMaturityDate(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2025"));
   		tradeDetails.setExpiredInd("N");
   		
   		String result = tradeServiceImpl.persistUpdateTrade(tradeDetails);
   		
   		assertEquals(result, "Savesuccess");
	
   	}  
   
}
