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
	// variables for sentiment
	private String ethSentiment;
	private String dogeSentiment;
	private String bnbSentiment;
	private String linkSentiment;
	private String eosSentiment;
	// variables for ff supply
	private String ethFFSupply;
	private String dogeFFSupply;
	private String bnbFFSupply;
	private String linkFFSupply;
	private String eosFFSupply;
	// variables for total supply
	private String ethTotalSupply;
	private String dogeTotalSupply;
	private String bnbTotalSupply;
	private String linkTotalSupply;
	private String eosTotalSupply;
	// variables for market cap + %
	private String ethMarketCap;
	private String dogeMarketCap;
	private String bnbMarketCap;
	private String linkMarketCap;
	private String eosMarketCap;
	private String ethMarketCapPercentage;
	private String dogeMarketCapPercentage;
	private String bnbMarketCapPercentage;
	private String linkMarketCapPercentage;
	private String eosMarketCapPercentage;
	// variables for total market cap + %
	private String ethTotalMarketCap;
	private String dogeTotalMarketCap;
	private String bnbTotalMarketCap;
	private String linkTotalMarketCap;
	private String eosTotalMarketCap;
	private String ethTotalMarketCapPercentage;
	private String dogeTotalMarketCapPercentage;
	private String bnbTotalMarketCapPercentage;
	private String linkTotalMarketCapPercentage;
	private String eosTotalMarketCapPercentage;
	// variables for volume + %
	private String ethVolume;
	private String dogeVolume;
	private String bnbVolume;
	private String linkVolume;
	private String eosVolume;
	private String ethVolumePercentage;
	private String dogeVolumePercentage;
	private String bnbVolumePercentage;
	private String linkVolumePercentage;
	private String eosVolumePercentage;

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
		// sentiment
		// a good idea would be that the ratio is set on the yesterday price action
		// in order to predict the price of today. basically, the sentiment
		// predicts the next day. Currently using today price + yesterday tweets
		this.ethSentiment = RatioCalculator.getSentiment(DataBase.uuidETH, DataBase.eth);
		this.dogeSentiment = RatioCalculator.getSentiment(DataBase.uuidDOGE, DataBase.doge);
		this.bnbSentiment = RatioCalculator.getSentiment(DataBase.uuidBNB, DataBase.bnb);
		this.linkSentiment = RatioCalculator.getSentiment(DataBase.uuidLINK, DataBase.link);
		this.eosSentiment = RatioCalculator.getSentiment(DataBase.uuidEOS, DataBase.eos);
		// ffsupply
		this.ethFFSupply = CurrenciesPrice.getFFSupply(DataBase.uuidETH);
		this.dogeFFSupply = CurrenciesPrice.getFFSupply(DataBase.uuidDOGE);
		this.bnbFFSupply = CurrenciesPrice.getFFSupply(DataBase.uuidBNB);
		this.linkFFSupply = CurrenciesPrice.getFFSupply(DataBase.uuidLINK);
		this.eosFFSupply = CurrenciesPrice.getFFSupply(DataBase.uuidEOS);
		// total supply
		this.ethTotalSupply = CurrenciesPrice.getTotalSupply(DataBase.uuidETH);
		this.dogeTotalSupply = CurrenciesPrice.getTotalSupply(DataBase.uuidDOGE);
		this.bnbTotalSupply = CurrenciesPrice.getTotalSupply(DataBase.uuidBNB);
		this.linkTotalSupply = CurrenciesPrice.getTotalSupply(DataBase.uuidLINK);
		this.eosTotalSupply = CurrenciesPrice.getTotalSupply(DataBase.uuidEOS);
		// market cap + %
		this.ethMarketCap = CurrenciesPrice.getMarketCap(DataBase.uuidETH);
		this.dogeMarketCap = CurrenciesPrice.getMarketCap(DataBase.uuidDOGE);
		this.bnbMarketCap = CurrenciesPrice.getMarketCap(DataBase.uuidBNB);
		this.linkMarketCap = CurrenciesPrice.getMarketCap(DataBase.uuidLINK);
		this.eosMarketCap = CurrenciesPrice.getMarketCap(DataBase.uuidEOS);
		this.ethMarketCapPercentage = CurrenciesPrice.getMarketCapPercentage(DataBase.uuidETH);
		this.dogeMarketCapPercentage = CurrenciesPrice.getMarketCapPercentage(DataBase.uuidDOGE);
		this.bnbMarketCapPercentage = CurrenciesPrice.getMarketCapPercentage(DataBase.uuidBNB);
		this.linkMarketCapPercentage = CurrenciesPrice.getMarketCapPercentage(DataBase.uuidLINK);
		this.eosMarketCapPercentage = CurrenciesPrice.getMarketCapPercentage(DataBase.uuidEOS);
		// total market cap + %
		this.ethTotalMarketCap = CurrenciesPrice.getTotalMarketCap(DataBase.uuidETH);
		this.dogeTotalMarketCap = CurrenciesPrice.getTotalMarketCap(DataBase.uuidDOGE);
		this.bnbTotalMarketCap = CurrenciesPrice.getTotalMarketCap(DataBase.uuidBNB);
		this.linkTotalMarketCap = CurrenciesPrice.getTotalMarketCap(DataBase.uuidLINK);
		this.eosTotalMarketCap = CurrenciesPrice.getTotalMarketCap(DataBase.uuidEOS);
		this.ethTotalMarketCapPercentage = CurrenciesPrice.getTotalMarketCapPercentage(DataBase.uuidETH);
		this.dogeTotalMarketCapPercentage = CurrenciesPrice.getTotalMarketCapPercentage(DataBase.uuidDOGE);
		this.bnbTotalMarketCapPercentage = CurrenciesPrice.getTotalMarketCapPercentage(DataBase.uuidBNB);
		this.linkTotalMarketCapPercentage = CurrenciesPrice.getTotalMarketCapPercentage(DataBase.uuidLINK);
		this.eosTotalMarketCapPercentage = CurrenciesPrice.getTotalMarketCapPercentage(DataBase.uuidEOS);
		// volume + %
		this.ethVolume = CurrenciesPrice.getVolume(DataBase.uuidETH);
		this.dogeVolume = CurrenciesPrice.getVolume(DataBase.uuidDOGE);
		this.bnbVolume = CurrenciesPrice.getVolume(DataBase.uuidBNB);
		this.linkVolume = CurrenciesPrice.getVolume(DataBase.uuidLINK);
		this.eosVolume = CurrenciesPrice.getVolume(DataBase.uuidEOS);
		this.ethVolumePercentage = CurrenciesPrice.getVolumePercentage(DataBase.uuidETH);
		this.dogeVolumePercentage = CurrenciesPrice.getVolumePercentage(DataBase.uuidDOGE);
		this.bnbVolumePercentage = CurrenciesPrice.getVolumePercentage(DataBase.uuidBNB);
		this.linkVolumePercentage = CurrenciesPrice.getVolumePercentage(DataBase.uuidLINK);
		this.eosVolumePercentage = CurrenciesPrice.getVolumePercentage(DataBase.uuidEOS);

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

	// Getters for sentiment
	public String getEthSentiment() {
		return ethSentiment;
	}

	public String getDogeSentiment() {
		return dogeSentiment;
	}

	public String getBnbSentiment() {
		return bnbSentiment;
	}

	public String getLinkSentiment() {
		return linkSentiment;
	}

	public String getEosSentiment() {
		return eosSentiment;
	}

	// Getters for FF supply
	public String getEthFFSupply() {
		return ethFFSupply;
	}

	public String getDogeFFSupply() {
		return dogeFFSupply;
	}

	public String getBnbFFSupply() {
		return bnbFFSupply;
	}

	public String getLinkFFSupply() {
		return linkFFSupply;
	}

	public String getEosFFSupply() {
		return eosFFSupply;
	}

	// Getters for total supply
	public String getEthTotalSupply() {
		return ethTotalSupply;
	}

	public String getDogeTotalSupply() {
		return dogeTotalSupply;
	}

	public String getBnbTotalSupply() {
		return bnbTotalSupply;
	}

	public String getLinkTotalSupply() {
		return linkTotalSupply;
	}

	public String getEosTotalSupply() {
		return eosTotalSupply;
	}

	// Getters for market cap + %
	public String getEthMarketCap() {
		return ethMarketCap;
	}

	public String getDogeMarketCap() {
		return dogeMarketCap;
	}

	public String getBnbMarketCap() {
		return bnbMarketCap;
	}

	public String getLinkMarketCap() {
		return linkMarketCap;
	}

	public String getEosMarketCap() {
		return eosMarketCap;
	}

	public String getEthMarketCapPercentage() {
		return ethMarketCapPercentage;
	}

	public String getDogeMarketCapPercentage() {
		return dogeMarketCapPercentage;
	}

	public String getBnbMarketCapPercentage() {
		return bnbMarketCapPercentage;
	}

	public String getLinkMarketCapPercentage() {
		return linkMarketCapPercentage;
	}

	public String getEosMarketCapPercentage() {
		return eosMarketCapPercentage;
	}

	// Getters for total market cap + %
	public String getEthTotalMarketCap() {
		return ethTotalMarketCap;
	}

	public String getDogeTotalMarketCap() {
		return dogeTotalMarketCap;
	}

	public String getBnbTotalMarketCap() {
		return bnbTotalMarketCap;
	}

	public String getLinkTotalMarketCap() {
		return linkTotalMarketCap;
	}

	public String getEosTotalMarketCap() {
		return eosTotalMarketCap;
	}

	public String getEthTotalMarketCapPercentage() {
		return ethTotalMarketCapPercentage;
	}

	public String getDogeTotalMarketCapPercentage() {
		return dogeTotalMarketCapPercentage;
	}

	public String getBnbTotalMarketCapPercentage() {
		return bnbTotalMarketCapPercentage;
	}

	public String getLinkTotalMarketCapPercentage() {
		return linkTotalMarketCapPercentage;
	}

	public String getEosTotalMarketCapPercentage() {
		return eosTotalMarketCapPercentage;
	}

	// Getters for volume + %
	public String getEthVolume() {
		return ethVolume;
	}

	public String getDogeVolume() {
		return dogeVolume;
	}

	public String getBnbVolume() {
		return bnbVolume;
	}

	public String getLinkVolume() {
		return linkVolume;
	}

	public String getEosVolume() {
		return eosVolume;
	}

	public String getEthVolumePercentage() {
		return ethVolumePercentage;
	}

	public String getDogeVolumePercentage() {
		return dogeVolumePercentage;
	}

	public String getBnbVolumePercentage() {
		return bnbVolumePercentage;
	}

	public String getLinkVolumePercentage() {
		return linkVolumePercentage;
	}

	public String getEosVolumePercentage() {
		return eosVolumePercentage;
	}

}
