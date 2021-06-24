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
						<th>$NEO</th>
						<th>%NEO</th>
						<th>$LINK</th>
						<th>%LINK</th>
						<th>$EOS</th>
						<th>%EOS</th>
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
				<td>{this.props.dataGets.ethPrice}</td>
				<td>{this.props.dataGets.ethPercentage}</td>
				<td>{this.props.dataGets.dogePrice}</td>
				<td>{this.props.dataGets.dogePercentage}</td>
				<td>{this.props.dataGets.neoPrice}</td>
				<td>{this.props.dataGets.neoPercentage}</td>
				<td>{this.props.dataGets.linkPrice}</td>
				<td>{this.props.dataGets.linkPercentage}</td>
				<td>{this.props.dataGets.eosPrice}</td>
				<td>{this.props.dataGets.eosPercentage}</td>
			</tr>
		)
	}
}

//rendering the frontend
ReactDOM.render(
	<App />,
	document.getElementById('react')
)

