package com.flygram.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.flygram.Domain.AccountProfile;
import com.flygram.dao.AccountFollowshipDao;
import com.flygram.service.IAccountFollowshipService;
import com.flygram.service.IAccountProfileService;

@RunWith(SpringJUnit4ClassRunner.class)
public class AccountFollowshipControllerTest {

	@Mock
	private AccountFollowshipDao daoMock;

//	@InjectMocks
//	private IAccountFollowshipService serviceMock;

	@Autowired
	@InjectMocks
	private IAccountProfileService profileServiceMock;

	@Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void testFollow() {
		AccountProfile account = mock(AccountProfile.class);
        when(account.getAccountId()).thenReturn(Long.valueOf(1));

        // use mock in test....
        assertEquals(profileServiceMock.createAccountProfile(account).getAccountId(), 43);
        
//		when(account.getAccountId()).thenReturn(Long.valueOf(1));
//		when(profileServiceMock.createAccountProfile(account)).thenReturn(account);
//		Assert.assertEquals(true, true);

//		when(profileServiceMock.createAccountProfile(account)).thenReturn(new AccountProfile());

//		assertThat(profileServiceMock.createAccountProfile(account), is(notNullValue()));
	}

	@Test
	public void testUnFollow() {

	}

}
