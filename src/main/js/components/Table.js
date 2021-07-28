//returns a table with the data

import React from 'react';
import { withStyles, makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const StyledTableCell = withStyles((theme) => ({
    head: {
        backgroundColor: theme.palette.common.black,
        color: theme.palette.common.white,
    },
    body: {
        fontSize: 14,
        backgroundColor: theme.palette.common.black,
    },
}))(TableCell);

const StyledTableRow = withStyles((theme) => ({
    root: {
        '&:nth-of-type(odd)': {
            backgroundColor: theme.palette.action.hover,
        },
    },
}))(TableRow);

function createData(name, Price, PricePercentage, Tweets, TweetsPercentage,
    Ratio, Sentiment, FFSupply, TotalSupply, MarketCap, MarketCapPercentage,
    TotalMarketCap, TotalMarketCapPercentage, Volume, VolumePercentage) {
    return {
        name, Price, PricePercentage, Tweets, TweetsPercentage,
        Ratio, Sentiment, FFSupply, TotalSupply, MarketCap, MarketCapPercentage,
        TotalMarketCap, TotalMarketCapPercentage, Volume, VolumePercentage
    };
}



const useStyles = makeStyles({
    table: {
        minWidth: 700,
    },
});

export default function FinalTable(inputData) {
    const classes = useStyles();
    const rows = [
        createData('ETH', inputData.ethPrice, inputData.ethPercentage, inputData.ethTweets, inputData.ethTweetsPercentage,
            inputData.ethRatio, inputData.ethSentiment, inputData.ethFFSupply, inputData.ethTotalSupply,
            inputData.ethMarketCap, inputData.ethMarketCapPercentage, inputData.ethTotalMarketCap, inputData.ethTotalMarketCapPercentage,
            inputData.ethVolume, inputData.ethVolumePercentage),
        createData('DOGE', inputData.dogePrice, inputData.dogePercentage, inputData.dogeTweets, inputData.dogeTweetsPercentage,
            inputData.dogeRatio, inputData.dogeSentiment, inputData.dogeFFSupply, inputData.dogeTotalSupply,
            inputData.dogeMarketCap, inputData.dogeMarketCapPercentage, inputData.dogeTotalMarketCap,
            inputData.dogeTotalMarketCapPercentage, inputData.dogeVolume, inputData.dogeVolumePercentage),
        createData('BNB', inputData.bnbPrice, inputData.bnbPercentage, inputData.bnbTweets, inputData.bnbTweetsPercentage,
            inputData.bnbRatio, inputData.bnbSentiment, inputData.bnbFFSupply, inputData.bnbTotalSupply,
            inputData.bnbMarketCap, inputData.bnbMarketCapPercentage, inputData.bnbTotalMarketCap,
            inputData.bnbTotalMarketCapPercentage, inputData.bnbVolume, inputData.bnbVolumePercentage),
        createData('LINK', inputData.linkPrice, inputData.linkPercentage, inputData.linkTweets, inputData.linkTweetsPercentage,
            inputData.linkRatio, inputData.linkSentiment, inputData.linkFFSupply, inputData.linkTotalSupply,
            inputData.linkMarketCap, inputData.linkMarketCapPercentage, inputData.linkTotalMarketCap,
            inputData.linkTotalMarketCapPercentage, inputData.linkVolume, inputData.linkVolumePercentage),
        createData('EOS', inputData.eosPrice, inputData.eosPercentage, inputData.eosTweets, inputData.eosTweetsPercentage,
            inputData.eosRatio, inputData.eosSentiment, inputData.eosFFSupply, inputData.eosTotalSupply,
            inputData.eosMarketCap, inputData.eosMarketCapPercentage, inputData.eosTotalMarketCap,
            inputData.eosTotalMarketCapPercentage, inputData.eosVolume, inputData.eosVolumePercentage),
    ];





    return (
        <TableContainer component={Paper}>
            <Table className={classes.table} aria-label="customized table">
                <TableHead>
                    <TableRow>
                        <StyledTableCell style={{ color: 'white', }}>Currency</StyledTableCell>
                        <StyledTableCell align="center">Price</StyledTableCell>
                        <StyledTableCell align="center">PricePercentage</StyledTableCell>
                        <StyledTableCell align="center">Tweets</StyledTableCell>
                        <StyledTableCell align="center">TweetsPercentage</StyledTableCell>
                        <StyledTableCell align="center">Ratio</StyledTableCell>
                        <StyledTableCell align="center">Sentiment</StyledTableCell>
                        <StyledTableCell align="center">FreefloatSupply</StyledTableCell>
                        <StyledTableCell align="center">TotalSupply</StyledTableCell>
                        <StyledTableCell align="center">MarketCap</StyledTableCell>
                        <StyledTableCell align="center">MarketCapPercentage</StyledTableCell>
                        <StyledTableCell align="center">TotalMarketCap</StyledTableCell>
                        <StyledTableCell align="center">TotalMarketCapPercentage</StyledTableCell>
                        <StyledTableCell align="center">Volume</StyledTableCell>
                        <StyledTableCell align="center">VolumePercentage</StyledTableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map((row) => (
                        <StyledTableRow key={row.name}>
                            <StyledTableCell component="th" scope="row" style={{ color: 'white', }}>
                                {row.name}
                            </StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.Price}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.PricePercentage}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.Tweets}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.TweetsPercentage}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.Ratio}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.Sentiment}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.FFSupply}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.TotalSupply}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.MarketCap}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.MarketCapPercentage}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.TotalMarketCap}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.TotalMarketCapPercentage}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.Volume}</StyledTableCell>
                            <StyledTableCell align="center" style={{ color: 'orange', }}>{row.VolumePercentage}</StyledTableCell>
                        </StyledTableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}
