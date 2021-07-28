const React = require('react');
// import React from 'react';
// import ReactDOM from 'react-dom';
import { BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';


export default function PercentageGraph(inputData) {
    const table =
        [
            {
                name: 'ETH',
                pricePercentage: parseFloat(inputData.ethPercentage),
                tweetsPercentage: parseFloat(inputData.ethTweetsPercentage),

            },
            {
                name: 'DOGE',
                pricePercentage: parseFloat(inputData.dogePercentage),
                tweetsPercentage: parseFloat(inputData.dogeTweetsPercentage),

            },
            {
                name: 'BNB',
                pricePercentage: parseFloat(inputData.bnbPercentage),
                tweetsPercentage: parseFloat(inputData.bnbTweetsPercentage),

            },
            {
                name: 'LINK',
                pricePercentage: parseFloat(inputData.linkPercentage),
                tweetsPercentage: parseFloat(inputData.linkTweetsPercentage),

            },
            {
                name: 'EOS',
                pricePercentage: parseFloat(inputData.eosPercentage),
                tweetsPercentage: parseFloat(inputData.eosTweetsPercentage),

            },
        ];





    return (
        //<ResponsiveContainer width="100%" aspect={3}>

        <BarChart
            width={500}
            height={300}
            data={table}
            margin={{
                top: 50,
                right: 30,
                left: 20,
                bottom: 5,
            }}
        >
            <CartesianGrid strokeDasharray="3 3" stroke="orange" />
            <XAxis dataKey="name" stroke="orange" />
            <YAxis stroke="orange" />
            <Tooltip fill="orange" />
            <Legend />
            <Bar dataKey="pricePercentage" fill="#ff3369" />
            <Bar dataKey="tweetsPercentage" fill="#4fa8e8" />
        </BarChart>
        //</ResponsiveContainer>

    )


}