import { styles } from 'ansi-colors';
import React from 'react';
import {
        View,
        Text,
        StyleSheet}
from 'react-native';

const Heading = () => {
  return (
    <View style={headingStyles.header}>
        <Text style={headingStyles.headerText}>
            todos
        </Text>
    </View>
  )
}

const headingStyles = StyleSheet.create({
    header: {
        marginTop: 80
    },
    headerText: {
        textAlign: 'center',
        fontSize: 72,
        color: 'rgba(175, 47, 47, 0.25)',
        fontWeight: '100'
    }
})

export default Heading;