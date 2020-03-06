package com.flygram.query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.EAccountPrivacy;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.PostLike;

public class Main {

	public static void main(String[] args) {
		menus();
	}

	public static void menus() {
		Scanner sc = new Scanner(System.in);
		int choice = 0, k;
		do {
			// Claude Data
			TestDataForClaude claudeData = new TestDataForClaude();
			List<Post> claudePostList = claudeData.listOfPost;
			List<AccountProfile> claudeAccountProfileList = claudeData.listOfProfile;

			// Didier Data
			TestDataForDidier didierData = new TestDataForDidier();

			List<Post> didierPostList = didierData.postList;
			List<PostLike> didierPostLikeList = didierData.postLikeList;
			List<AccountProfile> didierAccountProfileList = didierData.listAccount;

			// Eric Data
			TestDataForEric ericData = new TestDataForEric();

			List<AccountProfile> ericAccountProfile = ericData.accounts;

			// Jado Data
			TestDataForJado jadoData = new TestDataForJado();

			List<AccountProfile> jadoAccountProfileList = jadoData.allAccountsProfile;
			List<Post> jadoPostList = jadoData.postList;
			List<PostComment> jadoPostCommentList = jadoData.commentList;

			// Emino Data
			TestDataForJanvier eminoData = new TestDataForJanvier();
			List<AccountProfile> eminoAccountProfileList = eminoData.accountList;
			List<Post> eminoPostList = eminoData.post1;
			List<Post> eminoPostList2 = eminoData.post2;
			System.out.println(
					"\n\n1. Find Top x Account With Many Posts\n2. Find Top x Account With Many Likes\n3. Find Account created in a give Period of time\n4. Find Average of Created Accounts in a given Period per day\n5. Find Top X Oldest Posts\n6. Find Top X Commenter\n7. Find Top X Used Words in Comments\n8. Find Top X Liked Posts\n9. Find Top X Oldest Users\n10. Count By Gender Distribution and Privacy\n11. Get Top X Posters from Whom I Follow\n12. Find Top X Newest Posts\n13. Find X Accounts With Many Video Posts\n14. Find Top X Followed Accounts\n15. Find Top X New Users\n16. Find List of Followers for a Particular Account\n0. Exit\n\n");
			System.out.print("Make Choice...");
			choice = sc.nextInt();
			int day1, month1, year1, hour1, minute1, second1;
			int day2, month2, year2, hour2, minute2, second2;
			switch (choice) {
			case 1:
				System.out.print("Number of Post Limits...");
				k = sc.nextInt();
				System.out.println("\n" + k + " Accounts with Many Posts\n--------------\n");
				for (AccountProfile acc : FlygramQuery.findTopXAccountWithManyPost.apply(claudePostList, k)) {
					System.out.println(acc.getUser().getFullName());
				}
				break;
			case 2:
				System.out.print("Enter Limit...");
				k = sc.nextInt();
				System.out.println("\n" + k + " Accounts with Many Likes\n---------------------------------\n");
				for (AccountProfile acc : FlygramQuery.findTopXAccountWithManyLikes.apply(claudePostList, k)) {
					System.out.println(acc.getUser().getFullName());
				}

				break;
			case 3:
				System.out.print("Enter Period1 (DD MM Year Hour Minutes Seconds): ");
				day1 = sc.nextInt();
				month1 = sc.nextInt();
				year1 = sc.nextInt();
				hour1 = sc.nextInt();
				minute1 = sc.nextInt();
				second1 = sc.nextInt();
				LocalDateTime period1 = LocalDateTime.of(year1, month1, day1, hour1, minute1, second1);
				System.out.print("Enter Period2 (DD MM Year Hour Minutes Seconds): ");
				day2 = sc.nextInt();
				month2 = sc.nextInt();
				year2 = sc.nextInt();
				hour2 = sc.nextInt();
				minute2 = sc.nextInt();
				second2 = sc.nextInt();

				LocalDateTime period2 = LocalDateTime.of(year2, month2, day2, hour2, minute2, second2);
				System.out.println("\n Accounts Created between " + period1 + " and " + period2
						+ "\n------------------------------------\n");
				for (AccountProfile acc : FlygramQuery.findAccountCreatedInAPeriodX.apply(claudeAccountProfileList,
						period1, period2)) {
					System.out.println(acc.getUser().getFullName());
				}
				break;

			case 4:

				System.out.print("Enter Period1 (DD MM Year Hour Minutes Seconds): ");
				day1 = sc.nextInt();
				month1 = sc.nextInt();
				year1 = sc.nextInt();
				hour1 = sc.nextInt();
				minute1 = sc.nextInt();
				second1 = sc.nextInt();
				LocalDateTime p1 = LocalDateTime.of(year1, month1, day1, hour1, minute1, second1);
				System.out.print("Enter Period2 (DD MM Year Hour Minutes Seconds): ");
				day2 = sc.nextInt();
				month2 = sc.nextInt();
				year2 = sc.nextInt();
				hour2 = sc.nextInt();
				minute2 = sc.nextInt();
				second2 = sc.nextInt();

				LocalDateTime p2 = LocalDateTime.of(year2, month2, day2, hour2, minute2, second2);
				System.out.println("\nThe Average is... " + FlygramQuery.findAverageOfAccountCreatedPerDayInAPeriodX
						.apply(claudeAccountProfileList, p1, p2));
				break;

			case 5:
				System.out.print("Enter the limit...");
				k = sc.nextInt();
				System.out.println("\n" + k + " Oldest Posts\n--------------\n");
				for (Post p : FlygramQuery.findTopOldestPost.apply(jadoPostList, k)) {
					System.out.println("Post No: " + p.getId() + " Owner: " + p.getAccount().getUser().getFullName()
							+ " Created on: " + p.getPostDate());
				}
				break;

			case 6:
				System.out.print("Enter the limit...");
				k = sc.nextInt();
				System.out.println("\n" + k + " Greatest Commenters\n--------------\n");
				for (AccountProfile acc : FlygramQuery.findTopCommenter.apply(jadoAccountProfileList, k)) {
					System.out.println(acc.getUser().getFullName());
				}
				break;
			case 7:
				System.out.print("Enter the limit...");
				k = sc.nextInt();
				System.out.println("\n" + k + " Mostly Used words in comment\n------------------------\n");
				for (String s : FlygramQuery.topUsedCommentWords.apply(jadoPostCommentList, k)) {
					System.out.println(s);
				}
				break;

			case 8:
				System.out.print("Enter the limit...");
				k = sc.nextInt();
				System.out.println("\nTop " + k + " Liked Posts\n--------------\n");
				for (Post p : FlygramQuery.topXLikedPost.apply(didierPostList, k)) {
					System.out.println("Post Id: " + p.getId() + " Owner: " + p.getAccount().getUser().getFullName());
				}
				break;
			case 9:
				System.out.print("Enter the limit...");
				k = sc.nextInt();
				System.out.println("\n" + k + " Oldest Users\n--------------\n");
				for (AccountProfile user : FlygramQuery.topKOldestUsers.apply(didierAccountProfileList, k)) {
					System.out.println(user.getUser().getFullName());
				}
				break;

			case 10:
				System.out.print("Enter the gender(M/F)...");
				String gender = sc.next();
				System.out.println(
						"Choose Account Privacy\n-------------------\n1. Private\n2. Public\n\tMake Choice....");
				int pc = sc.nextInt();
				EAccountPrivacy accP = null;
				switch (pc) {
				case 1:
					accP = EAccountPrivacy.PRIVATE;
					break;
				case 2:
					accP = EAccountPrivacy.PUBLIC;
					break;
				default:
					System.out.println("***Invalid choice***");
					break;
				}

				System.out.println("\nNumber: " + FlygramQuery.countByGenderDistributionAndPrivacy
						.apply(didierAccountProfileList, accP, gender));
				break;
			case 11:
				System.out.println("Choose Your Account:\n---------------\n");

				for (AccountProfile acc : eminoAccountProfileList) {
					System.out.println(acc.getAccountId() + " " + acc.getUser().getFullName());
				}
				int n = sc.nextInt();
				AccountProfile accTarget = new AccountProfile();
				for (AccountProfile acc : eminoAccountProfileList) {
					if (acc.getAccountId() == n) {
						accTarget = acc;
						break;
					}
				}
				System.out.print("Enter the limit...");
				k = sc.nextInt();
				System.out.println("\nTop " + k + " Posters from whom " + accTarget.getUser().getFullName()
						+ " Follows\n-------------------------------------------\n");
				for (AccountProfile acc : FlygramQuery.topPostersInfollowingList.apply(accTarget, k)) {
					System.out.println(acc.getUser().getFullName());
				}
				break;
			case 12:
				System.out.print("Enter the limit...");
				k = sc.nextInt();
				System.out.println("\n" + k + " Newest Posts\n-------------------\n");
				for (Post p : FlygramQuery.topKnewestpost.apply(eminoPostList2, k)) {
					System.out.println("Post" + p.getId() + " belongs to " + p.getAccount().getUser().getFullName());
				}
				break;
			case 13:
				System.out.print("Enter the limit...");
				k = sc.nextInt();
				System.out.println("\nTop " + k + " Accounts with Many Video posts\n----------------------\n");
				for (AccountProfile acc : FlygramQuery.accountsWithManyVideoPosts.apply(eminoAccountProfileList, k)) {
					System.out.println(acc.getUser().getFullName());
				}
				break;
			case 14:
				System.out.print("Enter the limit...");
				k = sc.nextInt();

				System.out.println("\nTop " + k + " Followed Account(s)\n------------------------\n");
				for (AccountProfile acc : FlygramQuery.findTopXfollowedAccount.apply(ericAccountProfile, k)) {
					System.out.println(acc.getUser().getFullName() + " Created on " + acc.getCreationDate());
				}
				break;

			case 15:
				System.out.print("Enter the limit...");
				k = sc.nextInt();
				System.out.println("\n" + k + " Newest Users\n--------------\n");
				for (AccountProfile acc : FlygramQuery.findTopXNewUsers.apply(claudeAccountProfileList, k)) {
					System.out.println(acc.getUser().getFullName());
				}
				break;

			case 16:
				System.out.println("Choose Your Account:\n---------------\n");

				for (AccountProfile acc : claudeAccountProfileList) {
					System.out.println(acc.getAccountId() + " " + acc.getUser().getFullName());
				}
				int x = sc.nextInt();
				AccountProfile accT = new AccountProfile();
				for (AccountProfile acc : claudeAccountProfileList) {
					if (acc.getAccountId() == x) {
						accT = acc;
						break;
					}
				}
				System.out.println("\nList Of Followers of " + accT.getUser().getFullName()
						+ "\n---------------------------------------------\n");
				for (AccountProfile acc : FlygramQuery.findListOfFollowers.apply(accT)) {
					System.out.println(acc.getUser().getFullName());
				}
				break;

			default:
				break;
			}
		} while (choice != 0);

	}
}
