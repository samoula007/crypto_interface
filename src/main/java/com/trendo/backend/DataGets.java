//package declaration
package com.trendo.backend;

//imports for currencies prices
//spring imports
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//spring entity
@Entity
// class getting any necessary data
public class DataGets {
	// entity id
	private @Id @GeneratedValue Long id;
	// variables for currencies
	private String ethPrice;
	private String dogePrice;
	private String bnbPrice;
	private String linkPrice;
	private String eosPrice;
	private String ethPercentage;
	private String dogePercentage;
	private String bnbPercentage;
	private String linkPercentage;
	private String eosPercentage;
	// variables for twitter
	private String ethTweets;
	private String dogeTweets;
	private String bnbTweets;
	private String linkTweets;
	private String eosTweets;
	private String ethTweetsPercentage;
	private String dogeTweetsPercentage;
	private String bnbTweetsPercentage;
	private String linkTweetsPercentage;
	private String eosTweetsPercentage;
	// variables for ratio
	private String ethRatio;
	private String dogeRatio;
	private String bnbRatio;
	private String linkRatio;
	private String eosRatio;

	// calling prices
	public DataGets() throws Exception {
		// currencies
		this.ethPrice = CurrenciesPrice.getPrice(DataBase.uuidETH);
		this.dogePrice = CurrenciesPrice.getPrice(DataBase.uuidDOGE);
		this.bnbPrice = CurrenciesPrice.getPrice(DataBase.uuidBNB);
		this.linkPrice = CurrenciesPrice.getPrice(DataBase.uuidLINK);
		this.eosPrice = CurrenciesPrice.getPrice(DataBase.uuidEOS);
		this.ethPercentage = CurrenciesPrice.getDailyPercentage(DataBase.uuidETH);
		this.dogePercentage = CurrenciesPrice.getDailyPercentage(DataBase.uuidDOGE);
		this.bnbPercentage = CurrenciesPrice.getDailyPercentage(DataBase.uuidBNB);
		this.linkPercentage = CurrenciesPrice.getDailyPercentage(DataBase.uuidLINK);
		this.eosPercentage = CurrenciesPrice.getDailyPercentage(DataBase.uuidEOS);
		// twitter api
		this.ethTweets = TweetCount.getTweetCountString(DataBase.eth, DataBase.yesterday);
		this.dogeTweets = TweetCount.getTweetCountString(DataBase.doge, DataBase.yesterday);
		this.bnbTweets = TweetCount.getTweetCountString(DataBase.bnb, DataBase.yesterday);
		this.linkTweets = TweetCount.getTweetCountString(DataBase.link, DataBase.yesterday);
		this.eosTweets = TweetCount.getTweetCountString(DataBase.eos, DataBase.yesterday);
		this.ethTweetsPercentage = TweetCount.getTweetsPercentChange(DataBase.eth);
		this.dogeTweetsPercentage = TweetCount.getTweetsPercentChange(DataBase.doge);
		this.bnbTweetsPercentage = TweetCount.getTweetsPercentChange(DataBase.bnb);
		this.linkTweetsPercentage = TweetCount.getTweetsPercentChange(DataBase.link);
		this.eosTweetsPercentage = TweetCount.getTweetsPercentChange(DataBase.eos);
		// currencies/tweets ratio
		this.ethRatio = RatioCalculator.getRatio(DataBase.uuidETH, DataBase.eth);
		this.dogeRatio = RatioCalculator.getRatio(DataBase.uuidDOGE, DataBase.doge);
		this.bnbRatio = RatioCalculator.getRatio(DataBase.uuidBNB, DataBase.bnb);
		this.linkRatio = RatioCalculator.getRatio(DataBase.uuidLINK, DataBase.link);
		this.eosRatio = RatioCalculator.getRatio(DataBase.uuidEOS, DataBase.eos);
		// in the ratio class, add the weird functions i wrote in my notebook
		// write the logged data in a text file
		// display the data as graphs on the frontend
	}

	// Getters for currencies
	public Long getId() {
		return id;
	}

	public String getEthPrice() {
		return ethPrice;
	}

	public String getDogePrice() {
		return dogePrice;
	}

	public String getBnbPrice() {
		return bnbPrice;
	}

	public String getLinkPrice() {
		return linkPrice;
	}

	public String getEosPrice() {
		return eosPrice;
	}

	public String getEthPercentage() {
		return ethPercentage;
	}

	public String getDogePercentage() {
		return dogePercentage;
	}

	public String getBnbPercentage() {
		return bnbPercentage;
	}

	public String getLinkPercentage() {
		return linkPercentage;
	}

	public String getEosPercentage() {
		return eosPercentage;
	}

	// Getters for twitter

	public String getEthTweets() {
		return ethTweets;
	}

	public String getDogeTweets() {
		return dogeTweets;
	}

	public String getBnbTweets() {
		return bnbTweets;
	}

	public String getLinkTweets() {
		return linkTweets;
	}

	public String getEosTweets() {
		return eosTweets;
	}

	public String getEthTweetsPercentage() {
		return ethTweetsPercentage;
	}

	public String getDogeTweetsPercentage() {
		return dogeTweetsPercentage;
	}

	public String getBnbTweetsPercentage() {
		return bnbTweetsPercentage;
	}

	public String getLinkTweetsPercentage() {
		return linkTweetsPercentage;
	}

	public String getEosTweetsPercentage() {
		return eosTweetsPercentage;
	}

	// Getters for ratios

	public String getEthRatio() {
		return ethRatio;
	}

	public String getDogeRatio() {
		return dogeRatio;
	}

	public String getBnbRatio() {
		return bnbRatio;
	}

	public String getLinkRatio() {
		return linkRatio;
	}

	public String getEosRatio() {
		return eosRatio;
	}

}
