package com.usa.fedaral.gov.ssa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.usa.fedaral.gov.ssa.model.SsnModel;
import com.usa.fedaral.gov.ssa.model.StatesModel;
import com.usa.fedaral.gov.ssa.service.SsaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SSAWebAppTest {
	@Autowired
	SsaService service;

	@Test
	public void getStateNamesTest1() {
		//List<StatesModel> model = new ArrayList();
		//model = service.getStatesList();
		List<StatesModel> model = service.getStatesList();
		System.out.println(model.size());
		// assertNull(model);
		// assertSame(3, model.size());
		assertEquals(3, model.size());
	}
	
	@Test
	public void getAllSsnRecords() {
		List<SsnModel> ssnModel = service.getAllSsnRecords();
		assertNotNull(ssnModel);
	}
	
	

}
