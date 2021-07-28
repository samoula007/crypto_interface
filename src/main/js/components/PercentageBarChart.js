//returns a percentage bar chart for the the price and tweets

const React = require('react');
// import React from 'react';
// import ReactDOM from 'react-dom';
import { BarChart, Bar, Cell, XAxis, YAxis, CartesianGrid, Tooltip, Legend, ResponsiveContainer } from 'recharts';


export default function PercentageBarChart(inputData) {
    const table =
        [
            {
                name: 'ETH',
                pricePercentage: parseFloat(inputData.ethPercentage),
                tweetsPercentage: parseFloat(inputData.ethTweetsPercentage),
                marketCapPercentage: parseFloat(inputData.ethMarketCapPercentage),
                totalMarketCapPercentage: parseFloat(inputData.ethTotalMarketCapPercentage),
                volumePercentage: parseFloat(inputData.ethVolumePercentage),
            },
            {
                name: 'DOGE',
                pricePercentage: parseFloat(inputData.dogePercentage),
                tweetsPercentage: parseFloat(inputData.dogeTweetsPercentage),
                marketCapPercentage: parseFloat(inputData.dogeMarketCapPercentage),
                totalMarketCapPercentage: parseFloat(inputData.dogeTotalMarketCapPercentage),
                volumePercentage: parseFloat(inputData.dogeVolumePercentage),
            },
            {
                name: 'BNB',
                pricePercentage: parseFloat(inputData.bnbPercentage),
                tweetsPercentage: parseFloat(inputData.bnbTweetsPercentage),
                marketCapPercentage: parseFloat(inputData.bnbMarketCapPercentage),
                totalMarketCapPercentage: parseFloat(inputData.bnbTotalMarketCapPercentage),
                volumePercentage: parseFloat(inputData.bnbVolumePercentage),
            },
            {
                name: 'LINK',
                pricePercentage: parseFloat(inputData.linkPercentage),
                tweetsPercentage: parseFloat(inputData.linkTweetsPercentage),
                marketCapPercentage: parseFloat(inputData.linkMarketCapPercentage),
                totalMarketCapPercentage: parseFloat(inputData.linkTotalMarketCapPercentage),
                volumePercentage: parseFloat(inputData.linkVolumePercentage),
            },
            {
                name: 'EOS',
                pricePercentage: parseFloat(inputData.eosPercentage),
                tweetsPercentage: parseFloat(inputData.eosTweetsPercentage),
                marketCapPercentage: parseFloat(inputData.eosMarketCapPercentage),
                totalMarketCapPercentage: parseFloat(inputData.eosTotalMarketCapPercentage),
                volumePercentage: parseFloat(inputData.eosVolumePercentage),
            },
        ];





    return (
        <ResponsiveContainer width="100%" aspect={3}>

            <BarChart
                width={999}
                height={500}
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
                <Legend />s
                <Bar dataKey="pricePercentage" fill="#ff3369" />
                <Bar dataKey="tweetsPercentage" fill="#4fa8e8" />
                <Bar dataKey="marketCapPercentage" fill="#f75fe5" />
                <Bar dataKey="totalMarketCapPercentage" fill="#ffc107" />
                <Bar dataKey="volumePercentage" fill="#5ff7c5" />
            </BarChart>
        </ResponsiveContainer>

    )


}