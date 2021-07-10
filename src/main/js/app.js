//important
'use strict';

//imports as consts
const React = require('react');
const ReactDOM = require('react-dom'); //rendering
const client = require('./client'); //the client

//App class component to link with api
class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = { dataGetses: [] };
	}

	componentDidMount() {
		client({ method: 'GET', path: '/api/dataGetses' }).done(response => {
			this.setState({ dataGetses: response.entity._embedded.dataGetses });
		});
	}

	render() {
		return (
			<DataList dataGetses={this.state.dataGetses} />
		)
	}
}

//Creating the table
class DataList extends React.Component {
	render() {
		const dataGetses = this.props.dataGetses.map(dataGets =>
			<DataGets key={dataGets._links.self.href} dataGets={dataGets} />
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>$ETH</th>
						<th>%ETH</th>
						<th>$DOGE</th>
						<th>%DOGE</th>
						<th>$BNB</th>
						<th>%BNB</th>
						<th>$LINK</th>
						<th>%LINK</th>
						<th>$EOS</th>
						<th>%EOS</th>
						<th>Tweets ETH</th>
						<th>%Tweets ETH</th>
						<th>Tweets DOGE</th>
						<th>%Tweets DOGE</th>
						<th>Tweets BNB</th>
						<th>%Tweets BNB</th>
						<th>Tweets LINK</th>
						<th>%Tweets LINK</th>
						<th>Tweets EOS</th>
						<th>%Tweets EOS</th>
						<th>ETH $/T ratio</th>
						<th>DOGE $/T ratio</th>
						<th>BNB $/T ratio</th>
						<th>LINK $/T ratio</th>
						<th>EOS $/T ratio</th>
						<th>ETH sentiment</th>
						<th>DOGE sentiment</th>
						<th>BNB sentiment</th>
						<th>LINK sentiment</th>
						<th>EOS sentiment</th>
					</tr>
					{dataGetses}
				</tbody>
			</table>
		)
	}
}

//getting data for the list
class DataGets extends React.Component {
	render() {
		return (
			<tr>
				{/* currencies */}
				<td>{this.props.dataGets.ethPrice}</td>
				<td>{this.props.dataGets.ethPercentage}</td>
				<td>{this.props.dataGets.dogePrice}</td>
				<td>{this.props.dataGets.dogePercentage}</td>
				<td>{this.props.dataGets.bnbPrice}</td>
				<td>{this.props.dataGets.bnbPercentage}</td>
				<td>{this.props.dataGets.linkPrice}</td>
				<td>{this.props.dataGets.linkPercentage}</td>
				<td>{this.props.dataGets.eosPrice}</td>
				<td>{this.props.dataGets.eosPercentage}</td>
				{/*twitter */}
				<td>{this.props.dataGets.ethTweets}</td>
				<td>{this.props.dataGets.ethTweetsPercentage}</td>
				<td>{this.props.dataGets.dogeTweets}</td>
				<td>{this.props.dataGets.dogeTweetsPercentage}</td>
				<td>{this.props.dataGets.bnbTweets}</td>
				<td>{this.props.dataGets.bnbTweetsPercentage}</td>
				<td>{this.props.dataGets.linkTweets}</td>
				<td>{this.props.dataGets.linkTweetsPercentage}</td>
				<td>{this.props.dataGets.eosTweets}</td>
				<td>{this.props.dataGets.eosTweetsPercentage}</td>
				{/*ratios */}
				<td>{this.props.dataGets.ethRatio}</td>
				<td>{this.props.dataGets.dogeRatio}</td>
				<td>{this.props.dataGets.bnbRatio}</td>
				<td>{this.props.dataGets.linkRatio}</td>
				<td>{this.props.dataGets.eosRatio}</td>
				{/*sentiment */}
				<td>{this.props.dataGets.ethSentiment}</td>
				<td>{this.props.dataGets.dogeSentiment}</td>
				<td>{this.props.dataGets.bnbSentiment}</td>
				<td>{this.props.dataGets.linkSentiment}</td>
				<td>{this.props.dataGets.eosSentiment}</td>
			</tr >

		)
	}
}

//rendering the frontend
ReactDOM.render(
	<App />,
	document.getElementById('react')
)

