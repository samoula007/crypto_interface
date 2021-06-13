'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = { dataGetses: [] };
	}

	componentDidMount() { // <2>
		client({ method: 'GET', path: '/api/dataGetses' }).done(response => {
			this.setState({ dataGetses: response.entity._embedded.dataGetses });
		});
	}

	render() { // <3>
		return (
			<DataList dataGetses={this.state.dataGetses} />
		)
	}
}
// end::app[]

// tag::employee-list[]
class DataList extends React.Component {
	render() {
		const dataGetses = this.props.dataGetses.map(dataGets =>
			<DataGets key={dataGets._links.self.href} dataGets={dataGets} />
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>ETH</th>
						<th>DOGE</th>
						<th>NEO</th>
						<th>LINK</th>
						<th>EOS</th>
					</tr>
					{dataGetses}
				</tbody>
			</table>
		)
	}
}
// end::employee-list[]

// tag::employee[]
class DataGets extends React.Component {
	render() {
		return (
			<tr>
				<td>{this.props.dataGets.ethPrice}</td>
				<td>{this.props.dataGets.dogePrice}</td>
				<td>{this.props.dataGets.neoPrice}</td>
				<td>{this.props.dataGets.linkPrice}</td>
				<td>{this.props.dataGets.eosPrice}</td>
			</tr>
		)
	}
}
// end::employee[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]
