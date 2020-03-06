package com.flygram.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.flygram.Domain.AccountProfile;
import com.flygram.service.IAccountProfileService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

	@Autowired
	IAccountProfileService helloService;

    @Test
    public void testGet() {
    	AccountProfile account = mock(AccountProfile.class);
    	when(account.getAccountId()).thenReturn(Long.valueOf(1));
        assertEquals(account, helloService.createAccountProfile(account));
    }
    
}
