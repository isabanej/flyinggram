package com.flygram.query;

import java.time.LocalDateTime;
import java.util.List;

import com.flygram.Domain.AccountProfile;

public class FlygramQueryRunner {

	public static void main(String[] args) {
		TestDataForClaude data = new TestDataForClaude();
		int k = 3;
		List<AccountProfile> list1 = FlygramQuery.findTopXAccountWithManyPost.apply(data.listOfPost, k);
		System.out.println("Top " + k + " Account with many post");
		for (AccountProfile p : list1)
			System.out.println(p.getAccountId() + ". " + p.getUser().getFullName());

		List<AccountProfile> list2 = FlygramQuery.findTopXNewUsers.apply(data.listOfProfile, k);
		System.out.println("Top " + k + " New Created Account");
		for (AccountProfile p : list2)
			System.out.println(p.getAccountId() + ". " + p.getUser().getFullName());

		List<AccountProfile> list3 = FlygramQuery.findTopXAccountWithManyLikes.apply(data.listOfPost, k);
		System.out.println("Top " + k + " Account With many Likes");
		for (AccountProfile p : list3)
			System.out.println(p.getAccountId() + ". " + p.getUser().getFullName());

//		LocalDateTime startDate = LocalDateTime.of(2019, 10, 12, 00, 00, 00);
//		LocalDateTime endDate = LocalDateTime.of(2019, 10, 22, 00, 00, 00);
		LocalDateTime startDate = LocalDateTime.of(2019, 11, 12, 00, 00, 00);
		LocalDateTime endDate = LocalDateTime.of(2019, 8, 30, 00, 00, 00);
		double average = FlygramQuery.findAverageOfAccountCreatedPerDayInAPeriodX.apply(data.listOfProfile, startDate,
				endDate);
		System.out.println("The Average Account Created between " + startDate + " and " + endDate + " is: " + average);

	}

}
