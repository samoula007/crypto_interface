const React = require('react');
const ReactDOM = require('react-dom'); //rendering
const client = require('./client'); //the client
import regeneratorRuntime from 'regenerator-runtime';


import PercentageGraph from './PercentageGraph';
import FinalTable from './Table';



async function App() {

	const api = await fetch('http://localhost:8080/api/dataGetses')
	const response = await api.json()
	const data = await response._embedded.dataGetses[0]

	function GraphPercentage() {
		return PercentageGraph(data);
	}
	function DataTable() {
		return FinalTable(data);
	}


	class Display extends React.Component {
		render() {
			return (
				<div>
					<DataTable />
					<GraphPercentage />
					<p1 style={{ position: 'absolute', bottom: 0, left: 0, }}>
						If tweets data don't show, please wait for a few minutes before calling this page again.
					</p1>
				</div>
			)
		}
	}
	//rendering the frontend
	ReactDOM.render(
		<Display />,
		document.getElementById('react')
	)
}
App()

