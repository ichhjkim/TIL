import React from 'react';
import {
    View,
    Text,
    StyleSheet
} 
from 'react-native';
import Spot from './Spot';

const SpotList = ({spots, deleteSearch, toggleComplete}) => {
    spots = spots.map((spot, i) => {
    return (
        
        <Spot
            deleteSearch={deleteSearch}
            toggleComplete={toggleComplete}
            key={spot.searchIndex}
            spot={spot}/>
        )
    })
    return (
        <View>
            {spots}
        </View>
    )
}

export default SpotList;