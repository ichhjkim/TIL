import React from 'react';
import {
    View,
    Text,
    StyleSheet
} 
from 'react-native';
import SearchButton from '../../Main/SearchButton';

const Spot = ({spot, toggleComplete, deleteSearch}) => {
    return (
        <View style={SpotStyles.searchContainer}>
            <Text style={SpotStyles.searchText}>
                {spot.title}
            </Text>
            <View style={SpotStyles.buttons}>
                <SearchButton
                    name='Done'
                    complete={spot.complete}
                    onPress={()=>toggleComplete(spot.searchIndex)}>
                </SearchButton>
                <SearchButton
                    name='Delete'
                    onPress={()=>deleteSearch(spot.searchIndex)}>

                </SearchButton>
            </View>
        </View>
    )
}

const SpotStyles = StyleSheet.create({
    searchContainer: {
        marginLeft: 20,
        marginRight: 20,
        backgroundColor: '#ffffff',
        borderTopWidth: 1,
        borderRightWidth: 1,
        borderLeftWidth: 1,
        borderColor: '#ededed',
        paddingLeft: 14,
        paddingTop: 7,
        paddingBottom: 7,
        shadowOpacity: 0.2,
        shadowRadius: 3,
        //shadowColor: '#000000',
        shadowOffset: {width: 2, height: 2},
        flexDirection: 'row',
        alignItems: 'center'
    },
    searchText : {
        fontSize: 17
    },
    buttons: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'flex-end',
        alignItems: 'center'
    }
})

export default Spot;