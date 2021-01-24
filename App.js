/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar, NativeModules, TouchableOpacity
} from 'react-native';

import {
  Header,
  Colors,
} from 'react-native/Libraries/NewAppScreen';

class App extends React.Component {

  showToast = () => {

    if (NativeModules.Toast) {
      NativeModules.Toast.show("Hi ! I am a Toast")
    }
  }

  render() {
    console.log('NM ',NativeModules);
    return (
      <>
        <StatusBar barStyle="dark-content" />
        <SafeAreaView>
          <ScrollView
            contentInsetAdjustmentBehavior="automatic"
            style={styles.scrollView}>
            <Header />

            <View style={styles.body}>
              <View style={styles.sectionContainer}>

                <TouchableOpacity style={styles.button} onPress={this.showToast}>
                  <Text style={styles.sectionTitle}>Show Toast</Text>
                </TouchableOpacity>
              </View>

            </View>
          </ScrollView>
        </SafeAreaView>
      </>
    );
  }

};

const styles = StyleSheet.create({
  scrollView: {
    backgroundColor: Colors.lighter,

  },
  button: {
    backgroundColor: '#999',
    justifyContent: 'center',
    alignItems: 'center',
    paddingVertical: 5
  },
  body: {
    backgroundColor: Colors.white,
    flex: 1
  },
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 20,
    fontWeight: '400',
    color: Colors.black,
  },

});

export default App;
