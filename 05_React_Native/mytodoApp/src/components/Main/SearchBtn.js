import React from 'react';
import {
    View,
    Text,
    StyleSheet,
    TouchableHighlight
} from 'react-native';

const SearchBtn = ({submitSearch}) => {
    return (
        <View style={searchBtnStyles.buttonContainer}>
            <TouchableHighlight
                underlayColor='#efefef'
                style={searchBtnStyles.button}
                onPress={submitSearch}>
                    <Text style={searchBtnStyles.submit}>
                        search
                    </Text>
            </TouchableHighlight>
        </View>
    )
}

const searchBtnStyles = StyleSheet.create({
    buttonContainer: {
        alignItems: 'flex-end'
    },
    button: {
        height: 50,
        paddingLeft: 20,
        paddingRight: 20,
        backgroundColor: '#ffffff',
        width: 200,
        marginRight: 20,
        marginTop: 15,
        borderWidth: 1,
        borderColor: 'rgba(0,0,0,.1)',
        justifyContent: 'center',
        alignItems: 'center'
    },
    submit: {
        color: '#666666',
        fontWeight: '600'
    }
})

export default SearchBtn