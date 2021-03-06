package masterSpringMvc.search.api;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.TwitterProfile;

public class LightTweet {

	private String profileImageUrl;
	private String user;
	private String text;
	private LocalDateTime date;
	private String lang;
	private Integer retweetCount;

	public LightTweet(String text) {
		this.text = text;
	}

	public static LightTweet ofTweet(Tweet tweet) {
		LightTweet lightTweet = new LightTweet(tweet.getText());

		Date createdAt = tweet.getCreatedAt();
		if (createdAt != null) {
			lightTweet.date = LocalDateTime.ofInstant(createdAt.toInstant(), ZoneId.systemDefault());
		}
		TwitterProfile twitterUser = tweet.getUser();
		if (twitterUser != null) {
			lightTweet.user = twitterUser.getName();
			lightTweet.profileImageUrl = twitterUser.getProfileImageUrl();
		}
		lightTweet.lang = tweet.getLanguageCode();
		lightTweet.retweetCount = tweet.getRetweetCount();
		return lightTweet;

	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Integer getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(Integer retweetCount) {
		this.retweetCount = retweetCount;
	}

}
