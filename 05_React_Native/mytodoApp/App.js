/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React, { Component } from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  TextInput,
  useColorScheme,
  View,
} from 'react-native';

import Heading from './src/components/Main/Heading';
import Input from './src/components/Main/Input';
import SearchBtn from './src/components/Main/SearchBtn'
import SearchButton from './src/components/Main/SearchButton';
import SpotList from './src/components/SearchList/spots/SpotList'

let searchIndex = 0;
class App extends Component {
  constructor() {
    super()
    this.state = {
      inputValue: '',
      searchs: [],
      type: 'All'
    }
    console.log(this.state)
    this.submitSearch = this.submitSearch.bind(this);
    this.toggleComplete = this.toggleComplete.bind(this);
    this.deleteSearch = this.deleteSearch.bind(this);
  }
  inputChange(inputValue) {
    this.setState({inputValue})
  }
  submitSearch() {
    if(this.state.inputValue.match(/^\s*$/)) {
      return;
    }
    const search = {
      title: this.state.inputValue,
      searchIndex,
      complete: false
    }
    searchIndex++; 
    const searchs = [...this.state.searchs, search]
    this.setState({
      searchs,
      inputValue: ''
    })
  }
  deleteSearch(searchIndex) {
    let {searchs} = this.state;
    searchs = searchs.filter((search) => search.searchIndex!=searchIndex);
    this.setState({searchs});
  }
  toggleComplete(searchIndex) {
    let searchs = this.state.searchs;
    searchs.forEach((search)=> {
      if (search.searchIndex===searchIndex) {
        search.complete = !search.complete;
      }
    })
    this.setState({searchs});
  }
  render() {
    const {inputValue, searchs} = this.state;
    return (
      <View style={styles.container}>
      <ScrollView 
        keyboardShouldPersistTaps='always'
        style={styles.content}>
        <Heading />    
        <Input 
          inputValue={inputValue}
          inputChange={(text) => this.inputChange(text)}/>
        <SpotList 
          toggleComplete={this.toggleComplete}
          deleteSearch={this.deleteSearch}
          spots={searchs}/>
        <SearchBtn submitSearch={this.submitSearch} />
      </ScrollView>
    </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white'
  },
  content: {
    flex: 1,
    paddingTop: 60
  }
});

export default App;
