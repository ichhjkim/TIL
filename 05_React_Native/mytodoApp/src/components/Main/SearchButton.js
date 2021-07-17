import { styles } from 'ansi-colors';
import React from 'react';
import {
    Text,
    TouchableHighlight,
    StyleSheet
}
from 'react-native';

const SearchButton = ({onPress, complete, name})=> {
    return (
        <TouchableHighlight
            onPress={onPress}
            underlayColor='#efefef'
            style={SearchButtonStyles.button}>
                <Text
                    style={[
                        SearchButtonStyles.text,
                        complete ? SearchButtonStyles.complete: null,
                        name==='Delete' ? SearchButtonStyles.deleteButton: null
                    ]}>
                    {name}
                </Text>
        </TouchableHighlight>
    )
}   

const SearchButtonStyles = StyleSheet.create({
    button: {
        alignSelf: 'flex-end',
        padding: 7,
        borderColor: '#ededed',
        borderWidth: 1,
        borderRadius: 4,
        marginRight: 5
    },
    test : {
        color: '#666666'
    },
    complete: {
        color: 'green',
        fontWeight: 'bold'
    },
    deleteButton: {
        color: 'rgba(175, 47, 47, 1)'
    }
})

export default SearchButton;