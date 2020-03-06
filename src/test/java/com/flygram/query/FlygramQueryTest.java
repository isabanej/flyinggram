package com.flygram.query;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.EAccountPrivacy;
import com.flygram.Domain.Post;

class FlygramQueryTest {

	TestDataForClaude data = new TestDataForClaude();
	FlygramQuery query = new FlygramQuery();

	@Test
	void findTopXAccountWithManyPostTest() {
		List<AccountProfile> expected = new ArrayList<>();
		expected.add(data.account1);
		expected.add(data.account3);
		Assert.assertEquals(expected, FlygramQuery.findTopXAccountWithManyPost.apply(data.listOfPost, 2));
	}

	@Test
	void findTopXAccountWithManyLikesTest() {		
		AccountProfile expected = data.account5;
		Assert.assertTrue(FlygramQuery.findTopXAccountWithManyLikes.apply(data.listOfPost, 3).contains(expected));
	}

	@Test
	void findAccountCreatedInAPeriodXTest() {
		LocalDateTime startDate = LocalDateTime.of(2019, 10, 12, 00, 00, 00);
		LocalDateTime endDate = LocalDateTime.of(2019, 10, 22, 00, 00, 00);
		List<AccountProfile> expected = data.listOfProfile;
		Assert.assertEquals(expected,
				FlygramQuery.findAccountCreatedInAPeriodX.apply(data.listOfProfile, startDate, endDate));
	}

	@Test
	void findAverageOfAccountCreatedPerDayInAPeriodXTest() {
		LocalDateTime startDate = LocalDateTime.of(2019, 10, 12, 00, 00, 00);
		LocalDateTime endDate = LocalDateTime.of(2019, 10, 22, 00, 00, 00);
		Double expected = 0.6;
		Assert.assertEquals(expected,
				FlygramQuery.findAverageOfAccountCreatedPerDayInAPeriodX.apply(data.listOfProfile, startDate, endDate));
	}

	@Test
	void findAverageOfAccountCreatedPerDayInAPeriodXTestNegative1() {
		LocalDateTime startDate = LocalDateTime.of(2019, 11, 12, 00, 00, 00);
		LocalDateTime endDate = LocalDateTime.of(2019, 12, 20, 00, 00, 00);
		FlygramQuery.findAverageOfAccountCreatedPerDayInAPeriodX.apply(data.listOfProfile, startDate, endDate);
		Double expected = 0.0;
		Assert.assertEquals(expected,
				FlygramQuery.findAverageOfAccountCreatedPerDayInAPeriodX.apply(data.listOfProfile, startDate, endDate));

	}

	@Test
	void findAverageOfAccountCreatedPerDayInAPeriodXTestNegative2() {
		LocalDateTime startDate = LocalDateTime.of(2019, 11, 12, 00, 00, 00);
		LocalDateTime endDate = LocalDateTime.of(2019, 8, 30, 00, 00, 00);
		FlygramQuery.findAverageOfAccountCreatedPerDayInAPeriodX.apply(data.listOfProfile, startDate, endDate);
		Double expected = -0.0;
		Assert.assertEquals(expected,
				FlygramQuery.findAverageOfAccountCreatedPerDayInAPeriodX.apply(data.listOfProfile, startDate, endDate));

	}

	// TEST FOR JADO
	TestDataForJado testData1 = new TestDataForJado();

	@Test
	public void oldestPostTest() {
		Assert.assertEquals(testData1.expectedOldestPost, FlygramQuery.findTopOldestPost.apply(testData1.postList, 2));
	}

	@Test
	public void findTopCommenterTest() {
		Assert.assertEquals(testData1.expectedTopCommenters,
				FlygramQuery.findTopCommenter.apply(testData1.allAccountsProfile, 1));
	}

	@Test
	public void expectedTopUsedWordsTest() {
		Assert.assertEquals(testData1.expectedTopUsedWords,
				FlygramQuery.topUsedCommentWords.apply(testData1.commentList, 2));
	}

	// TEST FOR DIDIER
	TestDataForDidier testData2 = new TestDataForDidier();

	@Test
	public void topXLikedPostTest() {
		Post expected = testData2.post1;
		Assert.assertTrue(FlygramQuery.topXLikedPost.apply(testData2.postList, 1).contains(expected));
	}

	@Test
	public void topKOldestUsersTest() {
		List<AccountProfile> expected = new ArrayList<>();
		expected.add(testData2.acc1);
		Assert.assertEquals(expected, FlygramQuery.topKOldestUsers.apply(testData2.listAccount, 1));
	}

	@Test
	public void countByGenderDistributionAndPrivacyTest() {
		Long expected = 2L;
		Assert.assertEquals(expected, FlygramQuery.countByGenderDistributionAndPrivacy.apply(testData2.listAccount,
				EAccountPrivacy.PUBLIC, "M"));
	}

	@Test
	public void countByGenderDistributionAndPrivacyTest2() {
		Long expected = 0L;
		Assert.assertEquals(expected, FlygramQuery.countByGenderDistributionAndPrivacy.apply(testData2.listAccount,
				EAccountPrivacy.PUBLIC, "F"));
	}

	@Test
	public void countByGenderDistributionAndPrivacyTest3() {
		Long expected = 0L;
		Assert.assertEquals(expected, FlygramQuery.countByGenderDistributionAndPrivacy.apply(testData2.listAccount,
				EAccountPrivacy.PRIVATE, "M"));
	}

	// TEST FOR JANVIER
	TestDataForJanvier testData3 = new TestDataForJanvier();

	@Test
	public void followingListTopPostersTest() {
		List<AccountProfile> expected = new ArrayList<>();
		expected.add(testData3.ac1);
		Assert.assertEquals(expected, FlygramQuery.topPostersInfollowingList.apply(testData3.ac5, 1));
	}

	@Test
	public void followingListTopPostersTest2() {
		List<AccountProfile> expected = new ArrayList<>();
		expected.add(testData3.ac1);
		Assert.assertEquals(expected, FlygramQuery.topPostersInfollowingList.apply(testData3.ac5, 1));
	}

	@Test
	public void followingListTopPostersTest3() {
		List<AccountProfile> expected = new ArrayList<>();
		expected.add(testData3.ac1);
		Assert.assertEquals(expected, FlygramQuery.topPostersInfollowingList.apply(testData3.ac5, 1));
	}

	@Test
	public void topKnewestpostTest() {
		List<Post> expected = new ArrayList<>();
		expected.add(testData3.p4);
		Assert.assertEquals(expected, FlygramQuery.topKnewestpost.apply(testData3.post2, 1));
	}

	@Test
	public void topKnewestpostTest2() {
		List<Post> expected = new ArrayList<>();
		Assert.assertEquals(expected, FlygramQuery.topKnewestpost.apply(testData3.post3, 1));
	}

	@Test
	public void accountsWithManyVideoPostsTest() {
		List<AccountProfile> expected = new ArrayList<>();
		expected.add(testData3.ac2);
		Assert.assertEquals(expected, FlygramQuery.accountsWithManyVideoPosts.apply(testData3.accountList, 2));
	}

	// TEST FOR ERIC
	TestDataForEric testData4 = new TestDataForEric();

	@Test
	void findTopXNewUsersTest() {
		List<AccountProfile> expected = new ArrayList<>();
		expected.add(data.listOfProfile.get(5));
		Assert.assertEquals(expected, FlygramQuery.findTopXNewUsers.apply(data.listOfProfile, 1));
	}

	@Test
	public void findTopXfollowedAccountTest() {
		List<AccountProfile> expected = new ArrayList<>();
		expected.add(testData4.a2);
		Assert.assertEquals(expected, FlygramQuery.findTopXfollowedAccount.apply(testData4.accounts, 1));
	}

	@Test
	public void findListOfFollowersTest() {
		List<AccountProfile> expected = new ArrayList<>();
		expected.add(testData4.a3);
		expected.add(testData4.a1);
		Assert.assertEquals(expected, FlygramQuery.findListOfFollowers.apply(testData4.a2));
	}

}
