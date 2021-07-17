import React from 'react';

import {
        View,
        TextInput,
        StyleSheet
}
from 'react-native';

const Input = ({inputValue, inputChange}) => {
    return (
        <View style={inputStyles.inputContainer}>
            <TextInput 
                value={inputValue}
                style={inputStyles.inputText}
                placeholder="오늘 할일은?"
                placeholderTextColor="#CACACA"
                selectionColor="#666666"
                onChangeText={inputChange}/>
        </View>
    )
}

const inputStyles = StyleSheet.create({
    inputContainer: {
        marginLeft: 20,
        marginRight: 20,
        shadowOpacity: 0.2,
        shadowRadius: 3,
        shadowColor: '#000000',
        shadowOffset: {width: 2, height: 2}
    },
    inputText: {
        height: 60,
        backgroundColor: '#ffffff',
        paddingLeft: 15,
        paddingRight: 15,
        borderColor: 'black',
        color: 'black'
    }
})

export default Input;