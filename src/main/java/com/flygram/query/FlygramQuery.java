package com.flygram.query;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.*;

import com.flygram.Domain.AccountProfile;
import com.flygram.Domain.EAccountPrivacy;
import com.flygram.Domain.Post;
import com.flygram.Domain.PostComment;
import com.flygram.Domain.VideoPost;
import com.flygram.interfaces.TriFunction;

public class FlygramQuery {

	// QUERIES FOR JEAN CLAUDE MUGENZI
	static BiFunction<List<Post>, Integer, List<AccountProfile>> findTopXAccountWithManyPost = (list, x) -> list
			.stream().map(Post::getAccount).collect(Collectors.groupingBy(acc -> acc, Collectors.counting())).entrySet()
			.stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue())).limit(x).map(p -> p.getKey())
			.collect(Collectors.toList());

	static BiFunction<List<Post>, Integer, List<AccountProfile>> findTopXAccountWithManyLikes = (list, x) -> list
			.stream().flatMap(p -> p.getPostLikeList().stream())
			.collect(Collectors.groupingBy(pl -> pl.getAccount(), Collectors.counting())).entrySet().stream()
			.sorted((acct1, acct2) -> acct2.getValue().compareTo(acct1.getValue())).limit(x).map(a -> a.getKey())
			.collect(Collectors.toList());

	static BiFunction<AccountProfile, LocalDateTime, Boolean> isAfter = (account,
			startDate) -> (account.getCreationDate().isAfter(startDate)) ? true : false;

	static BiFunction<AccountProfile, LocalDateTime, Boolean> isBefore = (account,
			endDate) -> (account.getCreationDate().isBefore(endDate)) ? true : false;

	static TriFunction<List<AccountProfile>, LocalDateTime, LocalDateTime, List<AccountProfile>> findAccountCreatedInAPeriodX = (
			list, startDate, endDate) -> list.stream()
					.filter(acct -> isAfter.apply(acct, startDate) & isBefore.apply(acct, endDate))
					.collect(Collectors.toList());

	static TriFunction<List<AccountProfile>, LocalDateTime, LocalDateTime, Double> findAverageOfAccountCreatedPerDayInAPeriodX = (
			list, startDate,
			endDate) -> Double.valueOf(findAccountCreatedInAPeriodX.apply(list, startDate, endDate).size())
					/ Period.between(startDate.toLocalDate(), endDate.toLocalDate()).getDays();

	// QUERIES FOR JEAN DE LA PAIX DUKOMEZEDUSENGE
	static BiFunction<List<Post>, Integer, List<Post>> findTopOldestPost = (p, k) -> p.stream()
			.sorted((p1, p2) -> p1.getPostDate().compareTo(p2.getPostDate())).limit(k).collect(Collectors.toList());

	static BiFunction<List<AccountProfile>, Integer, List<AccountProfile>> findTopCommenter = (c, k) -> c.stream()
			.flatMap(p -> p.getPostCommentList().stream())
			.collect(Collectors.groupingBy(p -> p.getAccount(), Collectors.counting())).entrySet().stream()
			.sorted((r1, r2) -> (int) (r2.getValue() - r1.getValue())).map(d -> d.getKey()).limit(k)
			.collect(Collectors.toList());

	static BiFunction<List<PostComment>, Integer, List<String>> topUsedCommentWords = (p, k) -> p.stream()
			.map(w -> w.getDescription()).flatMap(c -> Stream.of(c.split(" "))).sorted()
			.collect(Collectors.groupingBy(o -> o, Collectors.counting())).entrySet().stream()
			.sorted((e1, e2) -> (int) (e2.getValue() - e1.getValue())).map(r -> r.getKey()).limit(k)
			.collect(Collectors.toList());

	// QUERIES FOR FELIX DIDIER NIKUBWIMANA
	static BiFunction<List<Post>, Integer, List<Post>> topXLikedPost = (listOfPost, value) -> listOfPost.stream()
			.flatMap(x -> x.getPostLikeList().stream())
			.collect(Collectors.groupingBy(p -> p.getPost(), Collectors.counting())).entrySet().stream()
			.sorted((e1, e2) -> (int) (e1.getValue() - e2.getValue())).limit(value).map(e -> e.getKey())
			.collect(Collectors.toList());

	static BiFunction<List<AccountProfile>, Integer, List<AccountProfile>> topKOldestUsers = (list, k) -> list.stream()
			.sorted((acc1, acc2) -> acc1.getCreationDate().compareTo(acc2.getCreationDate())).limit(k)
			.collect(Collectors.toList());

	static TriFunction<List<AccountProfile>, EAccountPrivacy, String, Long> countByGenderDistributionAndPrivacy = (list,
			privacy, gender) -> list.stream()
					.filter(x -> x.getGender().equals(gender) && x.getPrivacy().equals(privacy))
					.collect(Collectors.counting());
			
	// QUERIES FOR ISABANE JANVIER
	static BiFunction<AccountProfile, Integer, List<AccountProfile>> topPostersInfollowingList = (ac, k) -> ac
			.getFollowingList().stream().map(y -> y.getFollowing()).flatMap(s -> s.getPostList().stream())
			.collect(Collectors.groupingBy(Post::getAccount, Collectors.counting())).entrySet().stream()
			.sorted((acc1, acc2) -> 
			(int) (acc1.getValue() - acc2.getValue()))
			.map(l -> l.getKey()).limit(k)
			.collect(Collectors.toList());

	static BiFunction<List<Post>, Integer, List<Post>> topKnewestpost = (p, k) -> p.stream()
			.sorted(Comparator.comparing(Post::getPostDate)).filter(pf -> pf.getPostCommentList().size() == 0).limit(k)
			.collect(Collectors.toList());

	static BiFunction<List<AccountProfile>, Integer, List<AccountProfile>> accountsWithManyVideoPosts = (ac, k) -> ac
			.stream().flatMap(p -> p.getPostList().stream()).filter(pv -> pv instanceof VideoPost)
			.map(v -> (VideoPost) v).collect(Collectors.groupingBy(x -> x.getAccount(), Collectors.counting()))
			.entrySet().stream().sorted((p1, p2) -> 
			(int) (p2.getValue() - p1.getValue()))
			.map(x -> x.getKey()).limit(k)
			.collect(Collectors.toList());

	// QUERIES FOR ERIC NKURIKIYIMANA
	static BiFunction<List<AccountProfile>, Integer, List<AccountProfile>> findTopXfollowedAccount = (acc, n) -> acc
			.stream().flatMap(s -> s.getFollowingList().stream())
			.collect(Collectors.groupingBy(t -> t.getFollowing(), Collectors.counting())).entrySet().stream()
			.sorted((a, b) -> (int) (b.getValue() - a.getValue())).map(l -> l.getKey()).limit(n)
			.collect(Collectors.toList());

	static BiFunction<List<AccountProfile>, Integer, List<AccountProfile>> findTopXNewUsers = (list, x) -> list.stream()
			.sorted(Comparator.comparing(AccountProfile::getCreationDate).reversed()).limit(x)
			.collect(Collectors.toList());

	static Function<AccountProfile, List<AccountProfile>> findListOfFollowers = acc -> acc.getFollowerList().stream()
			.map(d -> d.getFollower()).collect(Collectors.toList());

}
